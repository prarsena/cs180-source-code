<#
.SYNOPSIS
    CS180 Course Environment Setup Script
    
.DESCRIPTION
    This script automates the installation of tools needed for CS180.
    It performs the following actions:
    1. Checks for Administrator privileges (Required to install software).
    2. Installs VS Code, Git, and OpenJDK 25 using the Windows Package Manager (Winget).
    3. Creates the standard course directory in your Bentley OneDrive.
    4. Clones the course repository.
    5. Opens the project in VS Code.

.NOTES
    Author: Peter Arsenault / CS180 
    Usage: Run in PowerShell as Administrator.
#>

# --- STEP 1: SAFETY CHECKS ---
Write-Host "🔍 Checking permissions..." -ForegroundColor Cyan

# This complicated line checks if the current user has 'Administrator' roles.
$isAdmin = ([Security.Principal.WindowsPrincipal] [Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)

if (-not $isAdmin) {
    Write-Warning "⛔ ERROR: You are not running as Administrator."
    Write-Host "   Please close this window."
    Write-Host "   Right-click PowerShell and select 'Run as Administrator'."
    Write-Host "   Then run this command again."
    Exit
}

Write-Host "✅ Permissions good! Starting setup..." -ForegroundColor Green

# --- STEP 2: INSTALL TOOLS (Winget) ---
# Winget is the official Windows Package Manager (like an App Store for the command line).
# The '-e' flag ensures we get the EXACT ID, so we don't install a copycat app.
# The '--silent' flag prevents pop-up windows from interrupting you.

Write-Host "📦 Installing VS Code..." -ForegroundColor Cyan
winget install -e --id Microsoft.VisualStudioCode --source winget --silent --accept-source-agreements --accept-package-agreements

Write-Host "📦 Installing Git (Version Control)..." -ForegroundColor Cyan
winget install -e --id Git.Git --source winget --silent --accept-source-agreements --accept-package-agreements

Write-Host "📦 Installing OpenJDK 25 (Java)..." -ForegroundColor Cyan
winget install -e --id Oracle.JDK.25 --source winget --silent --accept-source-agreements --accept-package-agreements

# Refresh environment variables immediately so git and code work in this terminal
Write-Host "🔄 Refreshing environment variables..." -ForegroundColor Cyan
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")

# --- STEP 2b: LOCATE THE NEW JDK & FIX "javapath" CONFLICTS ---
# Some Windows images ship with a legacy Oracle JRE that registers
# "C:\Program Files\Common Files\Oracle\Java\javapath" ahead of everything else on PATH.
# That shim can shadow the JDK we just installed, which breaks the Java extension.
# Rather than fight PATH ordering, we find the real JDK folder and point JAVA_HOME /
# the Java extension directly at it.
$jdkHome = Get-ChildItem "C:\Program Files\Java" -Directory -Filter "jdk-25*" -ErrorAction SilentlyContinue |
    Sort-Object Name -Descending | Select-Object -First 1 -ExpandProperty FullName

if (-not $jdkHome) {
    Write-Warning "⚠️ Could not locate the installed JDK under 'C:\Program Files\Java'. You may need to set java.jdt.ls.java.home manually in VS Code."
} else {
    Write-Host "   Found JDK at $jdkHome" -ForegroundColor Green
    [Environment]::SetEnvironmentVariable("JAVA_HOME", $jdkHome, "Machine")
    $env:JAVA_HOME = $jdkHome

    $javaOnPath = (Get-Command java -ErrorAction SilentlyContinue).Source
    if ($javaOnPath -and ($javaOnPath -notlike "$jdkHome*")) {
        Write-Warning "⚠️ 'java' on PATH resolves to $javaOnPath, not the JDK we just installed."
        Write-Host "   This is usually a legacy Oracle 'javapath' shortcut from an older Java install." -ForegroundColor Yellow
        Write-Host "   JAVA_HOME has been set to $jdkHome so VS Code uses the correct runtime regardless of PATH order." -ForegroundColor Yellow
    }
}

# --- STEP 3: CONFIGURE DIRECTORIES ---
# We use your Bentley OneDrive to ensure your work is backed up automatically.

# Try multiple common OneDrive locations
$oneDrivePaths = @(
    "$env:USERPROFILE\OneDrive - Bentley University",
    "D:\OneDrive - Bentley University",
    "$env:OneDrive\..\OneDrive - Bentley University"
)

$oneDrivePath = $null
foreach ($path in $oneDrivePaths) {
    if (Test-Path $path) {
        $oneDrivePath = $path
        break
    }
}

# If we found OneDrive, use it; otherwise fall back to Documents
if ($oneDrivePath) {
    $courseRoot = "$oneDrivePath\CS180"
    $sourceDir = "$courseRoot\source-code"
    Write-Host "📂 checking for directory: $sourceDir" -ForegroundColor Cyan
} else {
    Write-Warning "⚠️ Could not find 'OneDrive - Bentley University'."
    Write-Host "   Defaulting to your local Documents folder instead."
    $sourceDir = "$env:USERPROFILE\Documents\CS180\source-code"
    Write-Host "📂 checking for directory: $sourceDir" -ForegroundColor Cyan
}

# Create the folder if it doesn't exist
if (-not (Test-Path $sourceDir)) {
    New-Item -ItemType Directory -Force -Path $sourceDir | Out-Null
    Write-Host "   Created $sourceDir" -ForegroundColor Green
}

# --- STEP 4: CLONE REPOSITORY ---
# This pulls the actual Java files from GitHub.

if (Test-Path "$sourceDir\.git") {
    Write-Host "   Repository already exists. Pulling latest updates..." -ForegroundColor Green
    Set-Location $sourceDir
    git pull
} else {
    Write-Host "   Cloning course materials..." -ForegroundColor Green
    git clone https://github.com/prarsena/cs180-source-code.git "$sourceDir"
}

# --- STEP X: CUSTOMIZE TERMINAL PROMPT ---
Write-Host "🎨 Customizing Terminal prompt..." -ForegroundColor Cyan

# Define the function as a string
$profileContent = @"
function prompt { 
    `$Drive = (Get-Location).Drive.Name
    `$Leaf = Split-Path -Path `$PWD -Leaf
    "PS `${Drive}:\`$Leaf> "
}
"@

# Check if the user has a profile; if not, create it
if (!(Test-Path $PROFILE)) {
    New-Item -ItemType File -Path $PROFILE -Force
}

# Append the prompt function if it's not already there
if (!(Select-String -Path $PROFILE -Pattern "function prompt")) {
    Add-Content -Path $PROFILE -Value "`n$profileContent"
    Write-Host "   Short prompt added to `$PROFILE." -ForegroundColor Green
}

# --- STEP 6: GENERATE WINDOWS-SPECIFIC SETTINGS ---
$settingsDir = "$sourceDir\.vscode"
if (!(Test-Path $settingsDir)) { New-Item -ItemType Directory -Path $settingsDir }

$settingsContent = @'
{
    "code-runner.runInTerminal": true,
    "code-runner.showExecutionMessage": false,
    "code-runner.clearPreviousOutput": false,
    "code-runner.saveFileBeforeRun": true,
    "terminal.integrated.lineHeight": 1.2,
    "code-runner.executorMap": {
        "java": "cls; cd $dir; java $fileName"
    },
    "terminal.integrated.defaultProfile.windows": "PowerShell",
    "terminal.integrated.profiles.windows": {
        "PowerShell": {
            "source": "PowerShell",
            "args": ["-NoExit", "-ExecutionPolicy", "Bypass"]
        }
    },
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-25",
            "path": "__JDK_HOME__",
            "default": true
        }
    ],
    "java.jdt.ls.java.home": "__JDK_HOME__",
    "java.view.package.enabled": false,
    "editor.inlineSuggest.enabled": false,
    "editor.suggest.showInlineDetails": false,
    "github.copilot.enable": {
        "*": false
    },
    "editor.minimap.enabled": false,
    "chat.mcp.gallery.enabled": false,
    "vsintellicode.modify.editor.suggestSelection": "disabled"
}
'@

# Point the Java extension straight at the JDK we located earlier so it ignores PATH order/legacy javapath shims
$resolvedJdkHome = if ($jdkHome) { $jdkHome } else { "C:\Program Files\Java\jdk-25" }
$settingsContent = $settingsContent.Replace("__JDK_HOME__", $resolvedJdkHome.Replace("\", "\\"))

$settingsContent | Out-File -FilePath "$settingsDir\settings.json" -Encoding utf8
Write-Host "⚙️  Windows settings applied to .vscode/settings.json" -ForegroundColor Green

# --- STEP 5: LAUNCH VS CODE ---
Write-Host "🧩 Installing VS Code Extensions (Lean Mode)..." -ForegroundColor Cyan
# Force-install only the two essentials
# We use 'call' operator (&) to ensure PowerShell waits for it to finish
& code --install-extension redhat.java --force
& code --install-extension formulahendry.code-runner --force

Write-Host "🚀 Setup Complete! Opening VS Code..." -ForegroundColor Green

# Refresh environment variables so VS Code sees the new Java installation immediately
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")

code "$sourceDir"
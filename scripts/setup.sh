#!/bin/bash

# ==============================================================================
# CS180 Course Environment Setup Script (macOS)
# ==============================================================================
# REPO: https://github.com/prarsena/cs180-source-code.git

# --- STEP 1: PERMISSION & OS CHECK ---
echo "🔍 Checking system status..."

if [[ "$OSTYPE" != "darwin"* ]]; then
  echo "⛔ ERROR: This script is for macOS only. Please use setup.ps1 for Windows."
  exit 1
fi

if [[ $EUID -eq 0 ]]; then
   echo "⛔ ERROR: Please do not run this script with 'sudo'."
   echo "   Just run: bash setup.sh"
   exit 1
fi

# --- STEP 2: INSTALL HOMEBREW (IF MISSING) ---
if ! command -v brew &> /dev/null; then
    echo "📦 Installing Homebrew (Package Manager)..."
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    
    # Activate Homebrew for this session
    if [[ -f /opt/homebrew/bin/brew ]]; then
        eval "$(/opt/homebrew/bin/brew shellenv)"
    else
        eval "$(/usr/local/bin/brew shellenv)"
    fi
else
    echo "✅ Homebrew is already installed. Skipping..."
fi

# --- STEP 3: INSTALL TOOLS ---
echo "📦 Installing/Updating Tools..."

# Install Git and OpenJDK 25 (Gracefully handles updates)
brew install git openjdk
brew install --cask visual-studio-code

# --- STEP 4: LINK JAVA & TOOLS ---
echo "🔗 Linking Java 25 to System Paths..."
# This sudo command allows 'java --version' to work system-wide
sudo ln -sfn "$(brew --prefix openjdk)/libexec/openjdk.jdk" /Library/Java/JavaVirtualMachines/openjdk.jdk 2>/dev/null

# Add VS Code to PATH (if missing)
if ! command -v code &> /dev/null; then
    echo "   Adding 'code' command to Zsh profile..."
    echo 'export PATH="$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"' >> ~/.zprofile
    export PATH="$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
fi

# --- STEP 5: CONFIGURE DIRECTORIES ---
# Defines the specific Bentley OneDrive path
ONE_DRIVE_DIR="$HOME/Library/CloudStorage/OneDrive-BentleyUniversity"
TARGET_DIR="$ONE_DRIVE_DIR/CS180/source-code"

# Fallback to Documents if OneDrive isn't set up yet
if [ ! -d "$ONE_DRIVE_DIR" ]; then
    echo "⚠️  OneDrive not found. Using Documents/CS180 instead."
    TARGET_DIR="$HOME/Documents/CS180/source-code"
fi

mkdir -p "$TARGET_DIR"

# --- STEP 6: CLONE REPO ---
if [ -d "$TARGET_DIR/.git" ]; then
    echo "✅ Repo exists. Pulling latest updates..."
    cd "$TARGET_DIR" && git pull
else
    echo "🚚 Cloning course materials..."
    # Clones the contents directly into the source-code folder
    git clone https://github.com/prarsena/cs180-source-code.git "$TARGET_DIR"
fi

# --- STEP 7: INSTALL EXTENSIONS ---
echo "🧩 Installing Extensions..."
code --install-extension redhat.java --force
code --install-extension formulahendry.code-runner --force

# --- STEP 8: GENERATE MAC SETTINGS ---
mkdir -p "$TARGET_DIR/.vscode"
BREW_JAVA_PATH=$(brew --prefix openjdk)

# Note: The backslash before $fullFileName prevents the script from trying to read it as a variable
cat <<EOF > "$TARGET_DIR/.vscode/settings.json"
{
    "code-runner.runInTerminal": true,
    "code-runner.showExecutionMessage": false,
    "code-runner.clearPreviousOutput": true,
    "code-runner.saveFileBeforeRun": true,
    "code-runner.executorMap": {
        "java": "clear; cd \$dir; java \$fileName"
    },
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-25",
            "path": "$BREW_JAVA_PATH",
            "default": true
        }
    ],
    "editor.minimap.enabled": false,
    "java.view.package.enabled": false,
    "editor.inlineSuggest.enabled": false,
    "editor.suggest.showInlineDetails": false,
    "chat.mcp.gallery.enabled": false
}
EOF

echo "🚀 Setup Complete! Opening VS Code..."
code "$TARGET_DIR"
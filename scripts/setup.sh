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
echo "   You may be prompted for your password to link Java system-wide..."
if sudo -n true 2>/dev/null; then
    # Already have sudo privileges
    sudo ln -sfn "$(brew --prefix openjdk)/libexec/openjdk.jdk" /Library/Java/JavaVirtualMachines/openjdk.jdk 2>/dev/null
else
    # Request sudo access, but don't fail the script if user cancels
    if sudo -v 2>/dev/null; then
        sudo ln -sfn "$(brew --prefix openjdk)/libexec/openjdk.jdk" /Library/Java/JavaVirtualMachines/openjdk.jdk 2>/dev/null
        echo "✅ Java linked successfully."
    else
        echo "⚠️  Skipping Java system link (requires sudo). Java will still work via Homebrew."
    fi
fi

# Add VS Code to PATH (if missing)
if ! command -v code &> /dev/null; then
    echo "   Adding 'code' command to Zsh profile..."
    echo 'export PATH="$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"' >> ~/.zprofile
    export PATH="$PATH:/Applications/Visual Studio Code.app/Contents/Resources/app/bin"
fi

# --- STEP 5: CONFIGURE DIRECTORIES ---
# Try multiple common OneDrive locations
ONEDRIVE_PATHS=(
    "$HOME/Library/CloudStorage/OneDrive-BentleyUniversity"
    "$HOME/Documents/OneDrive - Bentley University"
    "$HOME/OneDrive - Bentley University"
    "$HOME/OneDrive"
)

ONE_DRIVE_DIR=""
for path in "${ONEDRIVE_PATHS[@]}"; do
    if [ -d "$path" ]; then
        ONE_DRIVE_DIR="$path"
        break
    fi
done

# If OneDrive found, use it; otherwise fall back to Documents
if [ -n "$ONE_DRIVE_DIR" ]; then
    TARGET_DIR="$ONE_DRIVE_DIR/CS180/source-code"
    echo "📂 Using OneDrive: $ONE_DRIVE_DIR"
else
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

cat <<EOF > "$TARGET_DIR/.vscode/settings.json"
{
    "code-runner.runInTerminal": true,
    "code-runner.showExecutionMessage": false,
    "code-runner.clearPreviousOutput": false,
    "code-runner.saveFileBeforeRun": true,
    "terminal.integrated.lineHeight": 1.2,
    "code-runner.executorMap": {
        "java": "clear; cd \$dir; java \$fileName"
    },
    "terminal.integrated.defaultProfile.osx": "zsh",
    "editor.minimap.enabled": false,
    "java.view.package.enabled": false,
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-25",
            "path": "/opt/homebrew/opt/openjdk/libexec/openjdk.jdk/Contents/Home",
            "default": true
        }
    ],
    "java.jdt.ls.java.home": "/opt/homebrew/opt/openjdk/libexec/openjdk.jdk/Contents/Home",
    "editor.inlineSuggest.enabled": false,
    "editor.suggest.showInlineDetails": false,
    "github.copilot.enable": {
        "*": false
    },
    "chat.mcp.gallery.enabled": false,
    "vsintellicode.modify.editor.suggestSelection": "disabled"
}
EOF

echo "🚀 Setup Complete! Opening VS Code..."
code "$TARGET_DIR"
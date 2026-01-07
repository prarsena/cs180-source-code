#!/bin/bash

# ==============================================================================
# CS180 Course Environment Setup Script (macOS)
# ==============================================================================
# DESCRIPTION:
#   This script sets up the Java development environment for macOS.
#   It handles Homebrew, VS Code, Git, and Java 25.
#
# AUDIT NOTE:
#   This script will ask for your generic Mac login password.
#   This is required by 'sudo' to install software.
#   Your password is NOT sent to any remote server.
# ==============================================================================

# --- STEP 1: SAFETY CHECKS ---
echo "🔍 Checking system status..."

# On Mac, we DO NOT want to run the whole script as 'sudo' (Root).
# Homebrew (the installer tool) forbids running as root for security reasons.
if [[ $EUID -eq 0 ]]; then
   echo "⛔ ERROR: Please do not run this script with 'sudo'."
   echo "   Just run: bash setup.sh"
   echo "   (The script will ask for permissions when needed)"
   exit 1
fi

echo "⚠️  NOTE: You may be asked for your Mac password during installation."
echo "   When typing, you will NOT see asterisks or dots. This is normal."
echo "   Type the password blindly and press Enter."
echo ""

# --- STEP 2: INSTALL HOMEBREW ---
# Homebrew is the standard package manager for macOS.
# We check if 'brew' command exists. If not, we install it.

if ! command -v brew &> /dev/null; then
    echo "📦 Installing Homebrew..."
    # This URL is the official Homebrew installation script
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    
    # After install, we must add Homebrew to the system PATH so the terminal 'sees' it.
    echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> ~/.zprofile
    eval "$(/opt/homebrew/bin/brew shellenv)"
else
    echo "✅ Homebrew is already installed."
fi

# --- STEP 3: INSTALL TOOLS ---
echo "📦 Installing/Updating Tools..."

# The '--cask' flag is used for graphical applications like VS Code.
brew install --cask visual-studio-code

# Standard command line tools
brew install git openjdk

# --- STEP 4: CONFIGURE DIRECTORIES ---
# Target the specific OneDrive folder.
# We use "$HOME" to make sure it works for any user (pete, student1, etc.)

TARGET_DIR="$HOME/Library/CloudStorage/OneDrive-BentleyUniversity/CS180/source-code"

echo "📂 Checking directory: $TARGET_DIR"

# If the student hasn't set up OneDrive yet, warn them but continue in Documents.
if [ ! -d "$HOME/Library/CloudStorage/OneDrive-BentleyUniversity" ]; then
    echo "⚠️  WARNING: OneDrive folder not found."
    echo "   Saving to 'Documents/CS180' instead."
    TARGET_DIR="$HOME/Documents/CS180/source-code"
fi

mkdir -p "$TARGET_DIR"

# --- STEP 5: CLONE REPOSITORY ---
if [ -d "$TARGET_DIR/.git" ]; then
    echo "   Repo exists. Updating..."
    cd "$TARGET_DIR"
    git pull
else
    echo "   Cloning course materials..."
    git clone https://github.com/your-username/my-java-course.git "$TARGET_DIR"
fi

# --- STEP 6: GENERATE MAC-SPECIFIC SETTINGS ---
mkdir -p "$TARGET_DIR/.vscode"

# Homebrew paths differ between Intel and Apple Silicon Macs. 
# This variable handles both.
BREW_JAVA_PATH=$(brew --prefix openjdk)

cat <<EOF > "$TARGET_DIR/.vscode/settings.json"
{
    "code-runner.runInTerminal": true,
    "code-runner.showExecutionMessage": false,
    "code-runner.clearPreviousOutput": true,
    "code-runner.saveFileBeforeRun": true,
    "code-runner.executorMap": {
        "java": "java --enable-preview \$fileName"
    },
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-25",
            "path": "$BREW_JAVA_PATH",
            "default": true
        }
    ],
    "java.view.package.enabled": false,
    "editor.inlineSuggest.enabled": false,
    "editor.suggest.showInlineDetails": false,
    "chat.mcp.gallery.enabled": false,
    "vsintellicode.modify.editor.suggestSelection": "disabled"
}
EOF

echo "⚙️  macOS settings applied to .vscode/settings.json"

# --- STEP 7: Install VS Code Extensions ---
echo "🧩 Installing VS Code Extensions (Lean Mode)..."
# Force-install only the two essentials
code --install-extension redhat.java --force
code --install-extension formulahendry.code-runner --force

# --- STEP 8: FINISH ---
echo "🚀 Setup Complete! Opening VS Code..."

# 'code' command opens Visual Studio Code.
# We open the folder directly so all project settings apply immediately.
code "$TARGET_DIR"
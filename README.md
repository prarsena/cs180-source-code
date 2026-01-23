# Open Programming: Java I

## 🪛 Tool Setup

### macOS

For Mac, open Terminal and paste this command: 

```bash
curl -sSL https://raw.githubusercontent.com/prarsena/cs180-source-code/main/scripts/setup.sh -o ~/setup.sh
chmod +x ~/setup.sh
bash ~/setup.sh
```

Notes:

- Before Homebrew can run, macOS often intercepts it and demands to install "Xcode Command Line Tools." This pops up a separate window that takes 5-10 minutes to download/install.
- When it asks for a password, type your Mac login password and hit Enter. You won't see the cursor move or dots appear. This is normal security. 



### Windows

For Windows, search for PowerShell. Right-click PowerShell and select Run as Administrator. Then paste this command:

```powershell
irm https://raw.githubusercontent.com/prarsena/cs180-source-code/main/scripts/setup.ps1 | iex
```

If you get a red "Running scripts is disabled on this system" error, use this "One-Time Unlock" command and then run the above command again:

```powershell
Set-ExecutionPolicy Bypass -Scope Process -Force
irm https://raw.githubusercontent.com/prarsena/cs180-source-code/main/scripts/setup.ps1 | iex
```

## Auditing the script

If you want ensure the script I'm telling you to run is safe:

1. **Read the comments**: Every major action is explained in green/gray text.
2. **Verify the URLs**: The scripts pull from official sources:
   - winget (Microsoft/Windows default)
   - brew.sh (The standard Mac tool)
   - github.com (Your specific course repo)
3. **No Data Exfiltration**: There are no curl or upload commands sending your data out. There are only install commands bringing tools in.


## 🛠️ Troubleshooting Your Java Environment

If clicking the "Play" button in VS Code doesn't work, verify these three components manually in your terminal:

1. Verify Java 25: Type java --version.

Expected: openjdk 25.x.x. If it says 1.8 or 11, the script didn't update your Path.

2. Verify the Preview Flag: Type java --enable-preview.

Expected: An error message like error: no source file. This is actually good—it means the command was recognized. If it says unrecognized option, you aren't on JDK 25.

3. Verify VS Code Settings: Open a .java file. Look at the bottom right of the VS Code window. Does it say JavaSE-25?

If not, click it and select JavaSE-25 from the list.

# Manual Tooling Setup (Fallback)

If the automated scripts fail, you must install and configure the tools yourself. Follow these steps carefully. Tutors will reference this guide if you need help.

---

### Windows Manual Setup

**1. Install Windows Terminal (Recommended)**
- Open the **Microsoft Store**.
- Search for **"Windows Terminal"** and install it. It provides a modern command-line experience.

**2. Install Core Tools with Winget**
- Open **Windows Terminal** as an **Administrator**. To do this, find it in the Start Menu, right-click it, and select "Run as administrator."
- The script uses `winget`, the official Windows Package Manager, to install software. You will do the same. Copy and paste each command below into the terminal one at a time and press Enter.

```powershell
# Install Visual Studio Code
winget install -e --id Microsoft.VisualStudioCode

# Install Git (for source code management)
winget install -e --id Git.Git

# Install Java Development Kit (JDK) Version 25
winget install -e --id Oracle.JDK.25
```

**3. Create Course Folder and Clone Repository**
- Close the administrator terminal and open a **regular Windows Terminal**.
- Run the following commands to create a folder in your Bentley OneDrive and download the course source code.

```powershell
# Create a directory in your university OneDrive
New-Item -ItemType Directory -Path "$env:USERPROFILE\OneDrive - Bentley University\CS180" -ErrorAction SilentlyContinue

# Navigate into that directory
Set-Location "$env:USERPROFILE\OneDrive - Bentley University\CS180"

# Download the course code from GitHub
git clone https://github.com/prarsena/cs180-source-code.git
```

**4. Install VS Code Extensions**
- Open **Visual Studio Code**.
- In the activity bar on the left, click the **Extensions** icon (it looks like four squares).
- Search for and install the following extensions:
  - `Extension Pack for Java` (by Microsoft)
  - `Code Runner` (by Jun Han)

**5. Restart Your Computer**
- A restart ensures all system paths and environment variables are correctly loaded.

---

### macOS Manual Setup

**1. Install Homebrew**
- Open the **Terminal** app (you can find it in `Applications/Utilities`).
- Homebrew is the standard package manager for macOS. Paste this command to install it:
  ```bash
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  ```
- The installer may ask for your password. This is your Mac login password.

**2. Install Core Tools with Homebrew**
- Once Homebrew is installed, run these commands in the Terminal to install the necessary tools.

```bash
# Install Git, Java, and VS Code
brew install git openjdk

# Install VS Code application
brew install --cask visual-studio-code
```

**3. Link Java for System-Wide Access**
- This step makes the `java` command available everywhere. You will likely be prompted for your password.
  ```bash
  sudo ln -sfn "$(brew --prefix openjdk)/libexec/openjdk.jdk" /Library/Java/JavaVirtualMachines/openjdk.jdk
  ```

**4. Create Course Folder and Clone Repository**
- Run the following commands in your terminal to create a folder and download the course code. This will place it in your university OneDrive if found, otherwise in your Documents folder.

```bash
# Determine the target directory
TARGET_DIR="$HOME/Library/CloudStorage/OneDrive-BentleyUniversity/CS180"
if [ ! -d "$TARGET_DIR" ]; then
  TARGET_DIR="$HOME/Documents/CS180"
fi

# Create the directory
mkdir -p "$TARGET_DIR"

# Navigate into it
cd "$TARGET_DIR"

# Download the course code from GitHub
git clone https://github.com/prarsena/cs180-source-code.git
```

**5. Install VS Code Extensions**
- Open **Visual Studio Code**.
- In the activity bar on the left, click the **Extensions** icon (it looks like four squares).
- Search for and install the following extensions:
  - `Extension Pack for Java` (by Microsoft)
  - `Code Runner` (by Jun Han)

**6. Restart Your Computer**
- A restart ensures all system paths and environment variables are correctly loaded.

---

## VS Code Configuration (Required for All Students)

After installing the tools, you must configure VS Code to use them correctly.

### 1. Find Your Java 25 Path

First, you need to find where Java was installed.
- **Windows:** Run `winget list Oracle.JDK.25` in PowerShell. The path is usually `C:\Program Files\Java\jdk-25`.
- **macOS:** Run `brew --prefix openjdk` in the Terminal. The path is usually `/opt/homebrew/opt/openjdk`.

### 2. Configure settings.json

1. Open VS Code.
2. Press `Ctrl+,` (Windows) or `Cmd+,` (Mac) to open Settings.
3. In the top-right corner of the Settings window, click the **"Open Settings (JSON)"** icon (it looks like a file with a curly brace `{}`).
4. Add the following configuration. **You must replace `/path/to/your/jdk-25` with the actual path you found in the step above.**

   - **Important:** For Windows paths, change backslashes (`\`) to forward slashes (`/`). For example, `C:\Program Files\Java\jdk-25` becomes `C:/Program Files/Java/jdk-25`.

```json
{
  // Add these settings inside the main curly braces {}
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-25",
      "path": "/path/to/your/jdk-25", // <-- PASTE YOUR PATH HERE
      "default": true
    }
  ],
  "java.jdt.ls.java.home": "/path/to/your/jdk-25", // <-- PASTE YOUR PATH HERE
  "java.configuration.checkProjectSettingsExclusions": false,
  "code-runner.executorMap": {
    "java": "cls; cd $dir; java $fileName"
  },
  "code-runner.runInTerminal": true
}
```

### 3. Final Verification Checklist

After completing all steps, verify your setup:
1. **Open the `cs180-source-code` folder in VS Code.** Use `File > Open Folder...` and select the cloned repository.
2. **Open a Java file,** such as `source-code/chapter-01/HelloWorld.java`.
3. **Check Java Version:** Look at the bottom-right of the VS Code window. It should say **JavaSE-25**. If not, click it and select the correct version.
4. **Run the Code:** Click the **Play button** (triangle icon) in the top-right of the editor.
5. **Check the Output:** The integrated terminal should open and display "Hello, World!".

If all steps are successful, your environment is correctly configured.



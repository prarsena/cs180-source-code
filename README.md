# Open Programming: Java I

## 🪛 Tool Setup

### macOS

For Mac, open Terminal and paste this command: 

```bash
curl -sSL https://raw.githubusercontent.com/prarsena/cs180-source-code/main/scripts/setup.sh | bash
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

## Summary of Student Experience
1. Run the setup script.
2. VS Code opens.
3. Pop-up: "Do you want to install the recommended extensions?" → Click Install.
4. Open File1.java.
5. Type IO. → You get a clean list of methods (println, readln).
6. Press Play → You get clean output in the terminal.
# Student Details Console

A Java console application that collects and validates student academic information, then displays a formatted summary.

Developed by **Moses Tandu Zachariah Hissen** — 24_BCC_BU_R_0016  
Bachelor of Business Computing, Bugema University

---

## What the Program Does

1. Displays a welcome banner
2. Prompts the student to enter five fields:
   - Full Name
   - Student ID
   - Course Name
   - Year of Study (must be a number between 1 and 6)
   - Email Address (must contain `@` and `.`)
3. Validates each field — if invalid, shows an error and asks again
4. Displays a clean formatted summary of all entered details

### Sample Output

```
======================================================
     Student Details Console
     Please enter your academic information below.
======================================================

  Enter your Full Name     : Moses Tandu
  Enter your Student ID    : 24/BCC/BU/R/0016
  Enter your Course Name   : Bachelor of Business Computing
  Enter your Year of Study : 1
  Enter your Email Address : moses@example.com

======================================================
  STUDENT DETAILS SUMMARY
  Full Name     : Moses Tandu
  Student ID    : 24BCC001
  Course        : Bachelor of Computer Science
  Year of Study : 2
  Email         : moses@example.com
======================================================
  Details recorded successfully.
======================================================
```

---

## Requirements

- **Java JDK 8 or higher** — [Download here](https://www.oracle.com/java/technologies/downloads/)
- No frameworks, no build tools, no extra libraries needed

---

## How to Run

### Option 1 — Double-click (easiest)

| OS | What to do |
|----|------------|
| Windows | Double-click `run.bat` |
| Mac / Linux | Run `./run.sh` in terminal |

### Option 2 — Terminal / Command Prompt

```bash
# Navigate to the project folder
cd "The Program code"

# Compile
javac Main.java

# Run
java Main
```

### Option 3 — VS Code with Code Runner

1. Open this folder in VS Code
2. Open `Main.java`
3. Press `Ctrl+Alt+N`

> The `.vscode/settings.json` file is included — it automatically configures Code Runner to run in the terminal so you can type input normally.

---

## Project Structure

```
The Program code/
├── Main.java            ← entire program in one file
├── run.bat              ← run script for Windows
├── run.sh               ← run script for Mac / Linux
├── README.md            ← this file
└── .vscode/
    └── settings.json    ← VS Code Code Runner configuration
```

---

## Author

**Moses Tandu Zachariah Hissen**  
Student ID: 24_BCC_BU_R_0016  
Bachelor of Business Computing 
Bugema University

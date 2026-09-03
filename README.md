# Project Report: Student Details Console Application

**Student Name:** [Moses Tandu Zachariah Hissen]  
**Course:** [Bachelors of Business Computing]  
**Date:** September 3, 2026  
**Language:** Java  
**Tool:** VS Code with JDK

---

## 1. Introduction

This report documents the development of a Java console application that prompts a student to enter their personal and academic details, validates the input, and displays the information in a formatted summary. The project was built as a professional-grade console program using plain Java — no frameworks, no build tools — just the JDK and VS Code.

---

## 2. How I Built It

### Planning the Requirements

Before writing a single line of code, I defined what the program needed to do. The requirements covered five key areas:

- Displaying a welcome banner on startup
- Collecting five student fields: Full Name, Student ID, Course Name, Year of Study, and Email Address
- Validating each field and re-prompting on invalid input
- Showing a clean, bordered summary of all entered details
- Exiting gracefully with the correct status code

### Designing the Architecture

I used a layered architecture to separate concerns cleanly:

```
Main
 └── ConsoleSession  (orchestrator)
      ├── Prompter   (handles all I/O)
      ├── Validator  (pure validation logic)
      └── Formatter  (pure string formatting)
```

Each layer had a single responsibility, which made the code easier to write, read, and test.

### Building Layer by Layer

**Step 1 — Value Objects**  
I started with the data models: `StudentDetails` (an immutable class holding the five fields) and `ValidationResult` (a simple result type with a `valid` flag and an optional error message). These had no dependencies and were the foundation everything else built on.

**Step 2 — Validator**  
A stateless utility class with three static methods:
- `validateNonBlank` — rejects empty or whitespace-only strings
- `validateYearOfStudy` — checks the input is an integer between 1 and 6
- `validateEmail` — checks for exactly one `@` and at least one `.` after it

**Step 3 — Formatter**  
Another stateless class responsible for all display strings. It produced the welcome banner, the summary block with aligned labels, and the confirmation message. All borders were exactly 54 `=` characters wide.

**Step 4 — Prompter**  
The only class that touched `System.in` and `System.out`. It wrapped a `BufferedReader` over `stdin` and exposed three simple methods: `prompt`, `print`, and `printError`.

**Step 5 — ConsoleSession**  
The orchestrator. It called `Formatter` for the banner, then looped through each field using `Prompter` to collect input and `Validator` to check it. On failure it printed an error and looped again. Once all fields were collected it built a `StudentDetails` object and printed the formatted summary.

**Step 6 — Main**  
The entry point. It wired everything together, caught unexpected exceptions, and controlled the exit code.

---

## 3. What I Learnt

**Separation of concerns**  
Splitting I/O, validation, and formatting into separate classes made each piece much simpler to think about. When a bug appeared, I knew exactly which class to look in.

**Immutability**  
Making `StudentDetails` immutable (no setters, only a constructor) meant I never had to worry about its state changing unexpectedly after creation.

**Input validation loops**  
Using a `while(true)` loop with a `break` on valid input is a clean, readable pattern for retry logic in console programs.

**Stateless utility classes**  
`Validator` and `Formatter` have no instance state, so they are trivially testable — just call a method with an input and check the output, no setup required.

**Java I/O**  
Wrapping `System.in` in a `BufferedReader` via `InputStreamReader` with a UTF-8 charset is the correct, professional way to read console input in Java — not `System.console()` which can return null in some environments.

**Exit codes**  
Using `System.exit(0)` for success and `System.exit(1)` for unexpected errors is a standard convention for console programs that other tools and scripts can rely on.

---

## 4. Challenges

**Keeping prompt labels aligned**  
Getting all five prompt strings to line up visually took some trial and error. The solution was to pad each label to the same character width using `%-13s` format specifiers in `String.format`.

**Email validation without a regex**  
I chose not to use a regular expression for email validation to keep things simple and readable. Instead I checked three conditions manually: non-blank, exactly one `@`, and at least one `.` after the `@`. The challenge was ordering those checks correctly and giving clear error messages for each failure case.

**IOException handling**  
Reading from `stdin` can throw `IOException`. Deciding where to handle it — versus where to declare `throws IOException` and let it propagate — required thinking about the right level of abstraction. I settled on letting it bubble up to `Main` where a single catch block handles all unexpected errors uniformly.

**Designing for testability without a test framework**  
Because `Prompter` wraps `System.in`, testing `ConsoleSession` with scripted input meant the `Prompter` constructor needed to accept an `InputStream` parameter rather than hardcoding `System.in`. This constructor injection pattern made the class testable without any mocking framework.

---

## 5. Conclusion

The Student Details Console is a small but complete professional-grade Java application. It demonstrates clean architecture, proper input validation, layered separation of concerns, and graceful error handling — the same principles used in production software at scale. Building it layer by layer, starting from pure data models and working up to the entry point, made the process straightforward and the result easy to maintain.

**To run the program:**
```bash
cd src
javac *.java
java Main
```

import java.io.IOException;

/**
 * Orchestrates the full student-details collection lifecycle:
 * welcome banner → prompt/validate loop for each field → summary display.
 */
public class ConsoleSession {

    private final Prompter prompter;

    /**
     * Creates a new session backed by the given {@code prompter}.
     * {@link Validator} and {@link Formatter} are stateless utility classes
     * and are used directly via their static methods.
     *
     * @param prompter the I/O adapter used for all console interaction
     */
    public ConsoleSession(Prompter prompter) {
        this.prompter = prompter;
    }

    /**
     * Runs the full collection lifecycle:
     * <ol>
     *   <li>Display the welcome banner.</li>
     *   <li>Prompt/validate each of the five fields, re-prompting on error.</li>
     *   <li>Display the summary and confirmation message.</li>
     *   <li>Return the completed {@link StudentDetails}.</li>
     * </ol>
     *
     * @return the validated {@link StudentDetails} entered by the student
     * @throws IOException if an I/O error occurs while reading from stdin
     */
    public StudentDetails run() throws IOException {
        // 1. Welcome banner
        prompter.print(Formatter.buildWelcomeBanner());

        // 2. Blank line
        prompter.print("");

        // 3. Collect each field with retry loop

        // Full Name
        String fullName;
        while (true) {
            String value = prompter.prompt("  Enter your Full Name     : ");
            ValidationResult result = Validator.validateNonBlank(value, "Full Name");
            if (result.isValid()) {
                fullName = value;
                break;
            }
            prompter.printError("  [!] " + result.getErrorMessage());
        }

        // Student ID
        String studentId;
        while (true) {
            String value = prompter.prompt("  Enter your Student ID    : ");
            ValidationResult result = Validator.validateNonBlank(value, "Student ID");
            if (result.isValid()) {
                studentId = value;
                break;
            }
            prompter.printError("  [!] " + result.getErrorMessage());
        }

        // Course Name
        String courseName;
        while (true) {
            String value = prompter.prompt("  Enter your Course Name   : ");
            ValidationResult result = Validator.validateNonBlank(value, "Course Name");
            if (result.isValid()) {
                courseName = value;
                break;
            }
            prompter.printError("  [!] " + result.getErrorMessage());
        }

        // Year of Study
        String yearRaw;
        while (true) {
            String value = prompter.prompt("  Enter your Year of Study : ");
            ValidationResult result = Validator.validateYearOfStudy(value);
            if (result.isValid()) {
                yearRaw = value;
                break;
            }
            prompter.printError("  [!] " + result.getErrorMessage());
        }

        // Email Address
        String email;
        while (true) {
            String value = prompter.prompt("  Enter your Email Address : ");
            ValidationResult result = Validator.validateEmail(value);
            if (result.isValid()) {
                email = value;
                break;
            }
            prompter.printError("  [!] " + result.getErrorMessage());
        }

        // 4. Build StudentDetails
        StudentDetails details = new StudentDetails(
                fullName,
                studentId,
                courseName,
                Integer.parseInt(yearRaw.trim()),
                email
        );

        // 5. Blank line
        prompter.print("");

        // 6. Summary
        prompter.print(Formatter.buildSummary(details));

        // 7. Confirmation
        prompter.print(Formatter.buildConfirmationMessage());

        // 8. Return
        return details;
    }
}

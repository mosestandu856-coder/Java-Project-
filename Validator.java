/**
 * Stateless utility class for validating individual student detail fields.
 *
 * All methods are pure — no side effects, no I/O.
 */
public final class Validator {

    // Prevent instantiation
    private Validator() {}

    /**
     * Returns an error result if {@code value} is null or blank (empty / whitespace-only),
     * otherwise returns ok.
     *
     * @param value     the raw string to check
     * @param fieldName the human-readable field name used in the error message
     */
    public static ValidationResult validateNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            return ValidationResult.error(fieldName + " must not be blank.");
        }
        return ValidationResult.ok();
    }

    /**
     * Attempts to parse {@code raw} as an integer and checks that it falls within
     * [1, 6] inclusive.
     *
     * Returns an error result if:
     * <ul>
     *   <li>{@code raw} cannot be parsed as an integer, or</li>
     *   <li>the parsed value is outside the range [1, 6].</li>
     * </ul>
     *
     * @param raw the raw string supplied by the student
     */
    public static ValidationResult validateYearOfStudy(String raw) {
        int year;
        try {
            year = Integer.parseInt(raw == null ? "" : raw.trim());
        } catch (NumberFormatException e) {
            return ValidationResult.error("Year of Study must be an integer between 1 and 6.");
        }
        if (year < 1 || year > 6) {
            return ValidationResult.error("Year of Study must be between 1 and 6 inclusive.");
        }
        return ValidationResult.ok();
    }

    /**
     * Validates an email address against the following rules:
     * <ol>
     *   <li>Must not be blank.</li>
     *   <li>Must contain exactly one {@code @} character.</li>
     *   <li>The substring after the {@code @} must contain at least one {@code .} character.</li>
     * </ol>
     *
     * @param value the raw email string supplied by the student
     */
    public static ValidationResult validateEmail(String value) {
        // Rule 1: non-blank
        ValidationResult blankCheck = validateNonBlank(value, "Email Address");
        if (!blankCheck.isValid()) {
            return blankCheck;
        }

        // Rule 2: exactly one '@'
        long atCount = value.chars().filter(c -> c == '@').count();
        if (atCount != 1) {
            return ValidationResult.error(
                    "Email Address must contain exactly one '@' character.");
        }

        // Rule 3: at least one '.' after the '@'
        String afterAt = value.substring(value.indexOf('@') + 1);
        if (!afterAt.contains(".")) {
            return ValidationResult.error(
                    "Email Address must contain at least one '.' after the '@'.");
        }

        return ValidationResult.ok();
    }
}

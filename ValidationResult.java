/**
 * Value object representing the outcome of a single field validation.
 *
 * Use the static factory methods to construct instances:
 *   ValidationResult.ok()             — valid, no error message
 *   ValidationResult.error("reason")  — invalid, with a descriptive message
 */
public final class ValidationResult {

    private final boolean valid;
    private final String  errorMessage; // null when valid

    private ValidationResult(boolean valid, String errorMessage) {
        this.valid        = valid;
        this.errorMessage = errorMessage;
    }

    /** Returns a valid result with no error message. */
    public static ValidationResult ok() {
        return new ValidationResult(true, null);
    }

    /** Returns an invalid result with the supplied error message. */
    public static ValidationResult error(String message) {
        return new ValidationResult(false, message);
    }

    public boolean isValid()          { return valid; }
    public String  getErrorMessage()  { return errorMessage; }
}

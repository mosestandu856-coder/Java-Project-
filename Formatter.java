/**
 * Stateless utility class that produces formatted display strings for the
 * Student Details Console. Contains no I/O — all methods return strings.
 */
public final class Formatter {

    /** Width of every border row (satisfies the ≥ 50 character requirement). */
    public static final int BORDER_WIDTH = 54;

    /** Prevent instantiation. */
    private Formatter() {}

    // -----------------------------------------------------------------------
    // Internal helpers
    // -----------------------------------------------------------------------

    private static String border() {
        return "=".repeat(BORDER_WIDTH);
    }

    private static String sep() {
        return System.lineSeparator();
    }

    // -----------------------------------------------------------------------
    // Public API
    // -----------------------------------------------------------------------

    /**
     * Returns the welcome banner shown at application startup.
     *
     * <pre>
     * ======================================================
     *      Student Details Console
     *      Please enter your academic information below.
     * ======================================================
     * </pre>
     */
    public static String buildWelcomeBanner() {
        String b = border();
        return b + sep()
             + "     Student Details Console" + sep()
             + "     Please enter your academic information below." + sep()
             + b;
    }

    /**
     * Returns a bordered summary block containing all five student fields.
     * Labels are left-aligned and padded so the {@code :} character lines up
     * in a consistent column.
     *
     * <pre>
     * ======================================================
     *   STUDENT DETAILS SUMMARY
     *   Full Name     : &lt;value&gt;
     *   Student ID    : &lt;value&gt;
     *   Course        : &lt;value&gt;
     *   Year of Study : &lt;value&gt;
     *   Email         : &lt;value&gt;
     * ======================================================
     * </pre>
     */
    public static String buildSummary(StudentDetails details) {
        // "Year of Study" is the longest label (13 chars); pad all to that width.
        String b   = border();
        String fmt = "  %-13s : %s";

        return b + sep()
             + "  STUDENT DETAILS SUMMARY" + sep()
             + String.format(fmt, "Full Name",     details.getFullName()) + sep()
             + String.format(fmt, "Student ID",    details.getStudentId()) + sep()
             + String.format(fmt, "Course",        details.getCourseName()) + sep()
             + String.format(fmt, "Year of Study", details.getYearOfStudy()) + sep()
             + String.format(fmt, "Email",         details.getEmail()) + sep()
             + b;
    }

    /**
     * Returns the confirmation message shown after the summary.
     *
     * <pre>
     *   Details recorded successfully.
     * ======================================================
     * </pre>
     */
    public static String buildConfirmationMessage() {
        return "  Details recorded successfully." + sep()
             + border();
    }
}

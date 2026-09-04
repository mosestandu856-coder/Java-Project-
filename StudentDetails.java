/**
 * Immutable value object holding the five collected student fields.
 */
public final class StudentDetails {

    private final String fullName;
    private final String studentId;
    private final String courseName;
    private final int    yearOfStudy;
    private final String email;

    public StudentDetails(String fullName, String studentId,
                          String courseName, int yearOfStudy, String email) {
        this.fullName    = fullName;
        this.studentId   = studentId;
        this.courseName  = courseName;
        this.yearOfStudy = yearOfStudy;
        this.email       = email;
    }

    public String getFullName()    { return fullName; }
    public String getStudentId()   { return studentId; }
    public String getCourseName()  { return courseName; }
    public int    getYearOfStudy() { return yearOfStudy; }
    public String getEmail()       { return email; }
}

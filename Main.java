import java.util.Scanner;

public class Main {

    // ─── Entry point ────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("     Student Details Console");
        System.out.println("     Please enter your academic information below.");
        System.out.println("======================================================");
        System.out.println();

        // Full Name
        String fullName;
        while (true) {
            System.out.print("  Enter your Full Name     : ");
            fullName = sc.nextLine().trim();
            if (!fullName.isEmpty()) break;
            System.err.println("  [!] Full Name must not be blank.");
        }

        // Student ID
        String studentId;
        while (true) {
            System.out.print("  Enter your Student ID    : ");
            studentId = sc.nextLine().trim();
            if (!studentId.isEmpty()) break;
            System.err.println("  [!] Student ID must not be blank.");
        }

        // Course Name
        String courseName;
        while (true) {
            System.out.print("  Enter your Course Name   : ");
            courseName = sc.nextLine().trim();
            if (!courseName.isEmpty()) break;
            System.err.println("  [!] Course Name must not be blank.");
        }

        // Year of Study
        int yearOfStudy = 0;
        while (true) {
            System.out.print("  Enter your Year of Study : ");
            String raw = sc.nextLine().trim();
            try {
                yearOfStudy = Integer.parseInt(raw);
                if (yearOfStudy >= 1 && yearOfStudy <= 6) break;
                System.err.println("  [!] Year of Study must be between 1 and 6.");
            } catch (NumberFormatException e) {
                System.err.println("  [!] Year of Study must be an integer between 1 and 6.");
            }
        }

        // Email Address
        String email;
        while (true) {
            System.out.print("  Enter your Email Address : ");
            email = sc.nextLine().trim();
            if (email.isEmpty()) {
                System.err.println("  [!] Email Address must not be blank.");
            } else if (email.chars().filter(c -> c == '@').count() != 1) {
                System.err.println("  [!] Email Address must contain exactly one '@' character.");
            } else if (!email.substring(email.indexOf('@') + 1).contains(".")) {
                System.err.println("  [!] Email Address must contain at least one '.' after the '@'.");
            } else {
                break;
            }
        }

        sc.close();

        // ─── Summary ────────────────────────────────────────────────────────────
        System.out.println();
        System.out.println("======================================================");
        System.out.println("  STUDENT DETAILS SUMMARY");
        System.out.printf ("  %-13s : %s%n", "Full Name",     fullName);
        System.out.printf ("  %-13s : %s%n", "Student ID",    studentId);
        System.out.printf ("  %-13s : %s%n", "Course",        courseName);
        System.out.printf ("  %-13s : %d%n", "Year of Study", yearOfStudy);
        System.out.printf ("  %-13s : %s%n", "Email",         email);
        System.out.println("======================================================");
        System.out.println("  Details recorded successfully.");
        System.out.println("======================================================");
    }
}

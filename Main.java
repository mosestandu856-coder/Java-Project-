public class Main {

    public static void main(String[] args) {
        try {
            Prompter prompter = new Prompter(System.in, System.out);
            ConsoleSession session = new ConsoleSession(prompter);
            session.run();
            System.exit(0);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            System.exit(1);
        }
    }
}

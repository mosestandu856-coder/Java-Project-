import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Prompter {

    private final BufferedReader reader;
    private final PrintStream out;

    public Prompter(InputStream in, PrintStream out) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        this.out = out;
    }

    /**
     * Prints {@code label} to out (no newline), then reads and returns one
     * trimmed line from the input stream. Returns an empty string on EOF.
     */
    public String prompt(String label) throws IOException {
        out.print(label);
        String line = reader.readLine();
        return (line == null) ? "" : line.trim();
    }

    /**
     * Prints {@code text} followed by a newline to out.
     */
    public void print(String text) {
        out.println(text);
    }

    /**
     * Prints {@code message} to standard error.
     */
    public void printError(String message) {
        System.err.println(message);
    }
}

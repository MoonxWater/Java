package Project_4;

public class NoBooksIssuedException extends Exception {
    public NoBooksIssuedException() {
        super("No books issued yet");
    }
}

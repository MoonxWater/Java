package Project_4;

public class LibraryEmptyException extends Exception {
    public LibraryEmptyException() {
        super("Library is empty.");
    }
}

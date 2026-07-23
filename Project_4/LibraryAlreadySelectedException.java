package Project_4;

public class LibraryAlreadySelectedException extends Exception {
    public LibraryAlreadySelectedException() {
        super("Library is already selected");
    }
}

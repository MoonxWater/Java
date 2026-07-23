package Project_4;

public class LibraryAlreadyExistsException extends Exception {
    public LibraryAlreadyExistsException() {
        super("Library already exists");
    }
}

package Project_4;

public class LibraryDeletionException extends Exception {
    public LibraryDeletionException() {
        super("Cannot delete library (either currently selected or last library)");
    }
}

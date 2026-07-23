package Project_4;

public class OnlyLibraryDeletionException extends Exception {
    public OnlyLibraryDeletionException() {
        super("Cannot delete last library");
    }
}

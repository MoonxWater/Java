package Project_4;

public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException() {
        super("Book Already Exists");
    }
}

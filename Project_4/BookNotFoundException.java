package Project_4;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found.");
    }
}

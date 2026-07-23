package Project_4;

public class BookAlreadyIssuedException extends Exception {    
    public BookAlreadyIssuedException() {
        super("Book already issued");
    }
}

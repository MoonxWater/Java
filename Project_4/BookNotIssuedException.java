package Project_4;

public class BookNotIssuedException extends Exception{
    public BookNotIssuedException() {
        super("Book has yet to be issued");
    }
}

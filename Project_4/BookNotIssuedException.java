package Project_4;

public class BookNotIssuedException extends Exception{
    @Override
    public String getMessage() {
        return "Book has yet to be issued";
    }
    public static void main(String[] args) throws BookNotIssuedException {
        throw new BookNotIssuedException();
    }
}

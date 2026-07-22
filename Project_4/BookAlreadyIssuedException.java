package Project_4;

public class BookAlreadyIssuedException extends Exception {
    @Override
    public String getMessage() {
        return "Book already issued";
    }
    public static void main(String[] args) throws BookAlreadyIssuedException {
        throw new BookAlreadyIssuedException();
    }
}

package Project_4;

public class BookAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
            return "Book Already Exists";
    }
    
    public static void main(String[] args) throws BookAlreadyExistsException {
        throw new BookAlreadyExistsException();
    }
}

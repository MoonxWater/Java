package Project_4;

public class BookNotFoundException extends Exception {
    public static void main(String[] args) throws BookNotFoundException {
        throw new BookNotFoundException();
    }
}

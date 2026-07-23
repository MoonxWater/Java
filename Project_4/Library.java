package Project_4;
import java.util.ArrayList;

public class Library {
    public static ArrayList<Book> books = new ArrayList<>();

    public static void addBook(int id, String title, String author) throws BookAlreadyExistsException {
        if (!books.isEmpty()) {
            for (Book b : books) {
                    if (b.getID() == id || b.getTitle().equals(title)) {
                        throw new BookAlreadyExistsException();
                    }
                }
            }

        books.add(new Book(id, title, author, false));
        System.out.printf("Book \"%s\" added successfully.\n", title);
    }

    public static void removeBook(int id) throws LibraryEmptyException, BookNotFoundException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        for (Book b : books) {
            if (b.getID() == id) {
                books.remove(b);
                System.out.println("Book removed successfully");
                return;
            }
        }

        throw new BookNotFoundException();
    }

    public static Book findBook(int id) throws BookNotFoundException, LibraryEmptyException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        for (Book b : books) {
            if (b.getID() == id) {
                return b;
            }
        }

        throw new BookNotFoundException();
    }

    public static boolean bookExists(int id) throws BookNotFoundException, LibraryEmptyException {
        if (findBook(id) != null) return true;

        return false;
    }
    
    public static void issueBook(int id) throws BookNotFoundException, BookAlreadyIssuedException, LibraryEmptyException {
        if (bookExists(id)) {
            findBook(id).issue();
            System.out.println("Book issued successfully");

        } else System.out.println("Book does not exist");
    }

    public static void returnBook(int id) throws BookNotFoundException, BookNotIssuedException, LibraryEmptyException {
        if (bookExists(id)) {

            Book found = findBook(id);

            if (found.isIssued()) {
                found.retBook();
                System.out.println("Book returned successfully");
            } else {
                throw new BookNotIssuedException();
            }

        } else throw new BookNotFoundException();
    }

    public static void displayBooks() throws LibraryEmptyException {
        if (books.isEmpty()) throw new LibraryEmptyException();
        
        for (Book b : books) {
            b.display();
            System.out.println();
        }
    }

    public static void availableBooks() throws LibraryEmptyException, NoBooksAvailableException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        boolean found = false;
        
        for (Book b : books) {
            if (!b.isIssued()) {
                b.display();
                found = true;
                System.out.println();
            }
        }

        if (found == false) {
            throw new NoBooksAvailableException();
        }
    }

    public static void issuedBooks() throws LibraryEmptyException, NoBooksIssuedException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        boolean found = false;
        
        for (Book b : books) {
            if (b.isIssued()) {
                b.display();
                found = true;
                System.out.println();
            }
        }

        if (found == false) {
            throw new NoBooksIssuedException();
        }
    }
}

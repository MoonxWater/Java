package Project_4;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private String name;

    public Library(String name) {
        this.name = name;
    }
    
    public void rename(String name) {
        if (name.equals(this.name)) {
            System.out.println("Please provide a new name");
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(int id, String title, String author) throws BookAlreadyExistsException {
        for (Book b : books) {
                if (b.getID() == id || b.getTitle().equals(title)) {
                    throw new BookAlreadyExistsException();
                }
        }

        books.add(new Book(id, title, author, false));
        System.out.printf("Book \"%s\" added successfully.\n", title);
    }

    public void removeBook(int id) throws LibraryEmptyException, BookNotFoundException {
        if (books.isEmpty()) throw new LibraryEmptyException();
        
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == id) {
                books.remove(books.get(i));
                System.out.println("Book removed successfully");
                return;
            }
        }

        throw new BookNotFoundException();
    }

    public Book findBook(int id) throws BookNotFoundException, LibraryEmptyException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        for (Book b : books) {
            if (b.getID() == id) {
                return b;
            }
        }

        throw new BookNotFoundException();
    }
    
    public void issueBook(int id) throws BookNotFoundException, BookAlreadyIssuedException, LibraryEmptyException {
        Book found = findBook(id);

        found.issue();
        System.out.println("Book issued successfully");
    }

    public void returnBook(int id) throws BookNotFoundException, BookNotIssuedException, LibraryEmptyException {
        Book found = findBook(id);

        found.retBook();
        System.out.println("Book returned successfully");
    }

    public void displayBooks() throws LibraryEmptyException {
        if (books.isEmpty()) throw new LibraryEmptyException();
        
        for (Book b : books) {
            b.display();
            System.out.println();
        }
    }

    public void availableBooks() throws LibraryEmptyException, NoBooksAvailableException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        boolean found = false;
        
        for (Book b : books) {
            if (!b.isIssued()) {
                b.display();
                found = true;
                System.out.println();
            }
        }

        if (!found) {
            throw new NoBooksAvailableException();
        }
    }

    public void issuedBooks() throws LibraryEmptyException, NoBooksIssuedException {
        if (books.isEmpty()) throw new LibraryEmptyException();

        boolean found = false;

        for (Book b : books) {
            if (b.isIssued()) {
                b.display();
                found = true;
                System.out.println();
            }
        }

        if (!found) {
            throw new NoBooksIssuedException();
        }
    }
}
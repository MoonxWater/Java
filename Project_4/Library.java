package Project_4;
import java.util.ArrayList;

public class Library {
    public static ArrayList<Book> books = new ArrayList<>();

    public static boolean addBook(int id, String title, String author) {
        if (!books.isEmpty()) {
            for (Book b : books) {
                try {
                    if (b.getID() == id || b.getTitle() == title) {
                    throw new BookAlreadyExistsException();
                    }
                } catch (BookAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }

        books.add(new Book(id, title, author, false));
        System.out.printf("Book \"%s\" added successfully.\n", title);
        return true;
    }

    public static void removeBook(int id) {
        if (books.isEmpty()) 
            System.out.println("No books in the library");

        for (Book b : books) {
            if (b.getID() == id) {
                books.remove(b);
                System.out.println("Book removed successfully");
            }
        }

        try {
            throw new BookNotFoundException();
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Book findBook(int id) throws NullPointerException {
        for (Book b : books) {
            if (b.getID() == id) {
                return b;
            }
        }

        try {
            throw new BookNotFoundException();
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
            return new Book(-1, "null", "null", false);
        }
    }

    public static boolean bookExists(int id) {
        if (findBook(id) instanceof Book) return true;

        else return false;
    }
    
    public static void issueBook(int id) {
        if (bookExists(id)) {
            findBook(id).issue();
            System.out.println("Book issued successfully");

        } else System.out.println("Book does not exist");
    }

    public static void returnBook(int id) {
        if (bookExists(id)) {
            findBook(id).retBook();
            System.out.println("Book returned successfully");

        } else System.out.println("Book does not exist");
    }

    public static void displayBooks() {
        for (Book b : books) {
            b.display();
            System.out.println();
        }
    }

    public static void availableBooks() {
        for (Book b : books) {
            if (!b.isIssued()) b.display();
            System.out.println();
        }
    }
}

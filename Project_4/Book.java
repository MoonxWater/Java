package Project_4;

public class Book {
    private final int id;
    private final String title;   
    private final String author;
    private boolean issued;

    Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issued: " + issued);
    } 

    public void issue() {
        try {
            if (isIssued()) throw new BookAlreadyIssuedException();

            else issued = true;
        } catch (BookAlreadyIssuedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook() {
        try {
            if (!isIssued()) throw new BookNotIssuedException();

            else issued = false;
        } catch (BookNotIssuedException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isIssued() {
        return issued;
    }
}

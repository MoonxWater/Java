package Project_4;

public class Book {
    private final int id;
    private final String title;   
    private final String author;
    private boolean issued;

    public Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issued: " + issued);
    } 

    public void issue() throws BookAlreadyIssuedException{
        if (isIssued()) throw new BookAlreadyIssuedException();

        else issued = true;
    }

    public void retBook() throws BookNotIssuedException {
        if (!isIssued()) throw new BookNotIssuedException();

        else issued = false;
    }
}

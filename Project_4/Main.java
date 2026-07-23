package Project_4;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String cur_interface = "book";

    public static void display_menu(String menu_type) {
        if (menu_type.equals("main")) {
            System.out.println("====== " + LibraryManager.currentLibrary().name + " ======\n" + //
        "1. Add Book\n" + //
        "2. Display Books\n" + //
        "3. Issue Book\n" + //
        "4. Return Book\n" + //
        "5. Remove Book\n" + //
        "6. Search Book\n" + //
        "7. Library Ops\n" + //
        "8. Exit");
        } else if (menu_type.equals("library_op")) {
            System.out.println("==== Library Operations ====\n" + //
                "1. Switch Library\n" + //
                "2. View Libraries\n" + //
                "3. Create Library\n" + //
                "4. Delete Library\n" + //
                "5. Back");
        } else if (menu_type.equals("books")) {
            System.out.println("==== Book Display Options ====\n" + //
            "1. All Books\n" + //
            "2. Available Books\n" + //
            "3. Issued Books\n" + //
            "4. Back");
        }
    }

    public static void libraryChoiceHandler() {
        display_menu("library_op");

        System.out.print("Choice: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        switch (choice) {
            case 1:
                System.out.print("Enter Library Number: ");
                int library_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    LibraryManager.changeLibrary(library_id - 1);
                    System.out.println("Library changed successfully.");
                } catch (LibraryNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch(IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("==== All Libraries ====");

                LibraryManager.displayLibraries();
                break;
            
            case 3:
                System.out.print("Enter name of new Library: ");
                String newLib_name = sc.nextLine();

                try {
                    LibraryManager.createLibrary(newLib_name);
                    System.out.println("Library " + newLib_name + " created succesfully.");
                } catch (LibraryAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                System.out.println("Delete Library");
                LibraryManager.displayLibraries();
                System.out.print("Enter name of Library to delete: ");
                String delLib_name = sc.nextLine();

                try {
                    LibraryManager.deleteLibrary(delLib_name);System.out.println("Library " + delLib_name + " deleted successfully.");
                } catch (LibraryNotFoundException | LibraryDeletionException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                cur_interface = "book";
                break;
        
            default:
                System.out.println("Invalid Choice!");
                libraryChoiceHandler();
                break;
        }

        System.out.println();
    }
    
    public static boolean primaryChoiceHandler(Library library) {
        display_menu("main");
        System.out.print("Choice: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        if (choice == 8) {
            System.out.println("\nThank You!");
            return false;
        }

        switch (choice) {
            case 1:
                System.out.print("Enter Book ID: ");
                int add_id = Integer.parseInt(sc.nextLine().trim());
                
                System.out.print("Enter Title of Book: ");
                String add_title = sc.nextLine();

                System.out.print("Enter Author of Book: ");
                String author = sc.nextLine();

                try {
                    library.addBook(add_id, add_title, author);
                } catch (BookAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                display_menu("books");

                System.out.print("Choice: ");
                int display_type = Integer.parseInt(sc.nextLine().trim());

                try {
                    if (display_type == 1) {
                        System.out.println("====== All Books ======");
                        library.displayBooks();
                    } else if (display_type == 2) {
                        System.out.println("====== Available ======");
                        library.availableBooks();
                    } else if (display_type == 3) {
                        System.out.println("====== Issued ======");
                        library.issuedBooks();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                } catch (NoBooksAvailableException | NoBooksIssuedException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                System.out.print("Enter Book ID to issue: ");
                int issue_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    library.issueBook(issue_id);
                } catch (BookNotFoundException | BookAlreadyIssuedException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;   

            case 4:
                System.out.print("Enter Book ID to return: ");
                int return_id = Integer.parseInt(sc.nextLine().trim());
                
                try {
                    library.returnBook(return_id);
                } catch (BookNotFoundException | BookNotIssuedException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 5:
                System.out.print("Enter Book ID: ");
                int remove_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    library.removeBook(remove_id);
                } catch (BookNotFoundException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 6:
                System.out.print("Enter Book ID: ");
                int find_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    Book found = library.findBook(find_id);

                    System.out.println();
                    found.display();
                } catch (BookNotFoundException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;
            
            case 7:
                System.out.println();
                cur_interface = "library";
                libraryChoiceHandler();
                break;

            default:
                System.out.println("Invalid Choice!");
                primaryChoiceHandler(library);
                break;
        }

        System.out.print("Press Enter to continue...");
        sc.nextLine();

        System.out.println();

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Initilising new Library 'Default'...");
        
        try {
            LibraryManager.createLibrary("Default");
            LibraryManager.changeLibrary(0);
        } catch (ArrayIndexOutOfBoundsException | LibraryNotFoundException | LibraryAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Press Enter to continue...");
        sc.nextLine();

        boolean flag = true;

        while (flag) {
            if (cur_interface.equals("book")) {
                flag = primaryChoiceHandler(LibraryManager.currentLibrary());
            } else if (cur_interface.equals("library")) {
                libraryChoiceHandler();
            }
        }
        
        sc.close();
    }
}
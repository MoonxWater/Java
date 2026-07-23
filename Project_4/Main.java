package Project_4;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String cur_interface = "book";

    public static int getIntInput(String prompt) {
        try {
            System.out.print(prompt);
            int res = Integer.parseInt(sc.nextLine().trim());
            return res;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
        return getIntInput(prompt);
    }

    public static String getStrInput(String prompt) {
        System.out.print(prompt);
        String res = sc.nextLine();
        return res;
    }

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
            System.out.println("\n==== Book Display Options ====\n" + //
            "1. All Books\n" + //
            "2. Available Books\n" + //
            "3. Issued Books\n" + //
            "4. Back\n");
        }
    }

    public static void libraryChoiceHandler() {
        display_menu("library_op");

        int choice = getIntInput("Choice: ");

        switch (choice) {
            case 1:// switch library
                int library_id = getIntInput("Enter Library Number: ");

                try {
                    LibraryManager.changeLibrary(library_id - 1);
                    System.out.println("Library changed successfully.");
                } catch(IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:// display
                System.out.println("==== All Libraries ====");

                LibraryManager.displayLibraries();
                break;
            
            case 3:// create library
                String newLib_name = getStrInput("Enter name of new Library: ");

                try {
                    LibraryManager.createLibrary(newLib_name);
                    System.out.println("Library '" + newLib_name + "' created succesfully.");
                } catch (LibraryAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:// delete library
                System.out.println("Delete Library");
                LibraryManager.displayLibraries();
                String delLib_name = getStrInput("Enter name of Library to delete: ");

                try {
                    LibraryManager.deleteLibrary(delLib_name);System.out.println("Library " + delLib_name + " deleted successfully.");
                } catch (LibraryNotFoundException | LibraryDeletionException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:// back
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
        int choice = getIntInput("Choice: ");

        if (choice == 8) {
            System.out.println("\nThank You!");
            return false;
        }

        switch (choice) {
            case 1:// add book
                int add_id = getIntInput("Enter Book ID: ");
                
                String add_title = getStrInput("Enter Title of Book: ");

                String author = getStrInput("Enter Author of Book: ");

                try {
                    library.addBook(add_id, add_title, author);
                } catch (BookAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:// book display
                display_menu("books");

                int display_type = getIntInput("Choice: ");

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

            case 3:// issue
                int issue_id = getIntInput("Enter Book ID to issue: ");

                try {
                    library.issueBook(issue_id);
                } catch (BookNotFoundException | BookAlreadyIssuedException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;   

            case 4:// return
                int return_id = getIntInput("Enter Book ID to return: ");
                
                try {
                    library.returnBook(return_id);
                } catch (BookNotFoundException | BookNotIssuedException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 5:// remove
                int remove_id = getIntInput("Enter Book ID: ");

                try {
                    library.removeBook(remove_id);
                } catch (BookNotFoundException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 6:// search
                int find_id = getIntInput("Enter Book ID: ");

                try {
                    Book found = library.findBook(find_id);

                    System.out.println();
                    found.display();
                } catch (BookNotFoundException | LibraryEmptyException e) {
                    System.out.println(e.getMessage());
                }
                break;
            
            case 7:// library
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
        } catch (ArrayIndexOutOfBoundsException | LibraryAlreadyExistsException e) {
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
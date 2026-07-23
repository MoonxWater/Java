package Project_4;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void choiceHandler(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter Book ID: ");
                int add_id = Integer.parseInt(sc.nextLine().trim());
                
                System.out.print("Enter Title of Book: ");
                String add_title = sc.nextLine();

                System.out.print("Enter Author of Book: ");
                String author = sc.nextLine();

                try {
                    Library.addBook(add_id, add_title, author);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("1. All Books\n2. Available Books\n3. Issued Books");
                System.out.print("Choice: ");
                int display_type = Integer.parseInt(sc.nextLine().trim());

                try {
                    if (display_type == 1) {
                        System.out.println("====== All Books ======");
                        Library.displayBooks();
                    } else if (display_type == 2) {
                        System.out.println("====== Available ======");
                        Library.availableBooks();
                    } else if (display_type == 3) {
                        System.out.println("====== Issued ======");
                        Library.issuedBooks();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println();
                break;

            case 3:
                System.out.print("Enter Book ID to issue: ");
                int issue_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    Library.issueBook(issue_id);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;   

            case 4:
                System.out.print("Enter Book ID to return: ");
                int return_id = Integer.parseInt(sc.nextLine().trim());
                
                try {
                    Library.returnBook(return_id);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 5:
                System.out.print("Enter Book ID: ");
                int remove_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    Library.removeBook(remove_id);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break; 

            case 6:
                System.out.print("Enter Book ID: ");
                int find_id = Integer.parseInt(sc.nextLine().trim());

                try {
                    Book found = Library.findBook(find_id);

                    System.out.println();
                    if (found != null) found.display();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }

    public static void main(String[] args) {
        
        String menu = "====== Library ======\n" + //
        "\n" + //
        "1. Add Book\n" + //
        "2. Display Books\n" + //
        "3. Issue Book\n" + //
        "4. Return Book\n" + //
        "5. Remove Book\n" + //
        "6. Search Book\n" + //
        "7. Exit";

        while (true) {
            System.out.println(menu);
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 7) {
                System.out.println("\nThank You!");
                break;
            }

            System.out.println();

            choiceHandler(choice);

            System.out.println("Press Enter to continue...");
                sc.nextLine();
        }
        
        sc.close();
    }
}

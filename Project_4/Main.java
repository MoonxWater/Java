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

                Library.addBook(add_id, add_title, author);

                System.out.println("Waiting...");
                sc.nextLine();
                break;

            case 2:
                System.out.println("====== All Books ======");
                Library.displayBooks();

                System.out.println("====== Available ======");
                Library.availableBooks();
                break;

            case 3:
                System.out.print("Enter Book ID to issue: ");
                int issue_id = Integer.parseInt(sc.nextLine().trim());

                Library.issueBook(issue_id);
                break;   

            case 4:
                System.out.print("Enter Book ID to return: ");
                int return_id = Integer.parseInt(sc.nextLine().trim());

                Library.returnBook(return_id);
                break; 

            case 5:
                System.out.print("Enter Book ID: ");
                int remove_id = Integer.parseInt(sc.nextLine().trim());

                Library.removeBook(remove_id);
                break; 

            case 6:
                System.out.print("Enter Book ID: ");
                int find_id = Integer.parseInt(sc.nextLine().trim());

                Book found = Library.findBook(find_id);

                if (found.getID() != -1) found.display();
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

            if (choice == 7) break;

            choiceHandler(choice);
        }
        
        sc.close();
    }
}

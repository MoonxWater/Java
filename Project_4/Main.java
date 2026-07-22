package Project_4;
import java.util.Scanner;

public class Main {
    public static void choiceHandler(int choice) {
        switch (choice) {
            case 1:
                
                break;
            case 2:
                
                break;

            case 3:
                
                break;   

            case 4:
                
                break; 

            case 5:
                
                break; 

            case 6:
                
                break;

            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            int choice = sc.nextInt();

            if (choice == 7) break;

            choiceHandler(choice);
        }

        sc.close();
    }
}

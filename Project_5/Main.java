package Project_5;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("==== Contact Ops ====\n" + //
                        "1. Add contact\n" + //
                        "2. Search contact\n" + //
                        "3. Update contact\n" + //
                        "4. Delete contact\n" + //
                        "5. Display all contacts\n" + //
                        "6. Exit");
    }

    public static String getStrInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int getIntInput(String prompt) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(sc.nextLine().trim());

        } catch (NumberFormatException e) {
            System.out.println("Invalid Input!");
            return getIntInput(prompt);

        }
    }

    public static boolean choiceHandler() {
        int choice = getIntInput("Choice: ");

        if (choice == 6) {
            System.out.println("Thank you!");
            return false;
        }

        switch (choice) {
            case 1:
                System.out.println("\n==== Add Contact ====");
                String create_name = getStrInput("Enter name: ");
                String create_number = getStrInput("Enter number: ");

                Contact.addContact(create_name, create_number);
                break;

            case 2: 
                System.out.println("\n==== Search Contact ====\n1. Search by name\n2. Search by number");
                int search_choice = getIntInput("Choice: ");
                String search_data = getStrInput("Enter seach parameter: ");

                if (search_choice == 3) 
                    break;

                if (search_choice == 1) {
                    Contact.findContact("name", search_data);

                } else if (search_choice == 2) {
                    Contact.findContact("number", search_data);

                } else {
                    System.out.println("Invalid Choice!");

                }
                break;

            case 3:
                System.out.println("\n==== Update Contact ====\n1. Update name\n2. Update number\n3. Back");

                int update_choice = getIntInput("Choice: ");

                String data = getStrInput("Enter contact name/number: ");

                if (update_choice == 3)
                    break;

                if (update_choice == 1) {
                    String new_name = getStrInput("Enter new name: ");
                    Contact.rename(data, new_name);

                } else if (update_choice == 2) {
                    String new_number = getStrInput("Enter new number: ");
                    Contact.updateNumber(data, new_number);

                } else {
                    System.out.println("Invalid Choice!");
                    choiceHandler();

                }
                break;

            case 4: 
                System.out.println("\n==== Delete Contact ====");

                String del_name = getStrInput("Enter name: ");

                Contact.deleteContact(del_name);
                break;

            case 5:
                System.out.println("\n==== All Contacts ====");

                Contact.displayAll();
                break;

            default:
                System.out.println("Invalid Input!");
                break;
        }
        return true;
    }
    
    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            displayMenu();

            flag = choiceHandler();

            System.out.println();
        }
        sc.close();
    }
}

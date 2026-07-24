package Project_5;
import java.util.HashMap;
import java.util.Map;

public class Contact {
    private static HashMap<String, String> contacts = new HashMap<>(); 

    public static void addContact(String name, String number) {
        if (contacts.containsKey(name)) {
            contacts.put(name, number);
            System.out.println("Contact added successfully");
        } else System.out.println("Contact already exists");
    }
    
    public static void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact removed successfully");
        } else System.out.println("Contact does not exist");
    }

    public static void displayAll() {
        if (contacts.isEmpty()) System.out.println("No Contacts");

        int i = 1;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(i + ". " + entry.getKey() + " --> " + entry.getValue());
            i++;
        }
    }

    public static String getName(String number) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue() == number) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String getNumber(String name) {
        return contacts.get(name);
    }

    public static void rename(String name, String new_name) {
        if (new_name.equals(name)) {
            System.out.println("Choose a new name");
            return;
        }
        contacts.put(new_name, contacts.get(name));
        contacts.remove(name);
    }

    public static void updateNumber(String name, String new_number) {
        if (new_number.equals(contacts.get(name))) {
            System.out.println("Choose a new number");
            return;
        }

        contacts.put(name, new_number);
    }

    public static void findContact(String search_type, String data) {
        String val = (search_type.equals("name")) ? getNumber(data) : getName(data);

        if (val == null) {
            System.out.println("Contact not found");
            return;
        }
        
        System.out.println(getName(val));
    }
}

package Project_5;
import java.util.HashMap;
import java.util.Map;

public class Contact {
    private HashMap<String, String> contacts = new HashMap<>(); 
    
    public String getName(String number) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue() == number) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getNumber(String name) {
        return contacts.get(name);
    }

    public void rename(String name, String new_name) {
        if (new_name.equals(name)) {
            System.out.println("Choose a new name");
            return;
        }
        contacts.put(new_name, contacts.get(name));
        contacts.remove(name);
    }

    public void updateNumber(String name, String new_number) {
        if (new_number.equals(contacts.get(name))) {
            System.out.println("Choose a new number");
            return;
        }

        contacts.put(name, new_number);
    }
}

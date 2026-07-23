package Project_4;
import java.util.ArrayList;

public class LibraryManager {
    public static final ArrayList<Library> libraries = new ArrayList<>();
    private static Library cur_lib;

    public static void displayLibraries() {
        int i = 0;

        for (Library l : libraries) {
            System.out.println((i + 1) + ". " + l.getName());
            i++;
        }
    }

    public static void changeLibrary(int id) throws IndexOutOfBoundsException {
        Library found = libraries.get(id);

        if (found.equals(cur_lib)) {
            System.out.println("Library already selected.");
            return;
        } 

        cur_lib = found;
    }

    public static Library currentLibrary() {
        return cur_lib;
    }

    public static void createLibrary(String name) throws LibraryAlreadyExistsException {
        try {
            findLibrary(name);
            throw new LibraryAlreadyExistsException();
        } catch (LibraryNotFoundException e) {
            libraries.add(new Library(name));
        }
    }

    public static void deleteLibrary(String name) throws LibraryNotFoundException, LibraryDeletionException {
        Library found = findLibrary(name);
        
        if (libraries.size() == 1 || found.equals(cur_lib)) throw new LibraryDeletionException();

        libraries.remove(found);
    }

    public static Library findLibrary(String name) throws LibraryNotFoundException {
        for (Library l : libraries) {
            if (l.getName().equals(name)) {
                return l;
            }
        }

        throw new LibraryNotFoundException();
    }
}
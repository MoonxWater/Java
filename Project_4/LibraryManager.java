package Project_4;
import java.util.ArrayList;

public class LibraryManager {
    public static final ArrayList<Library> libraries = new ArrayList<>();
    private static Library cur_lib;

    public static void displayLibraries() {
        int i = 0;

        for (Library l : libraries) {
            System.out.println((i + 1) + ". " + l.name);
            i++;
        }
    }

    public static void changeLibrary(int id) throws LibraryNotFoundException, IndexOutOfBoundsException {
        cur_lib = libraries.get(id);
    }

    public static Library currentLibrary() {
        return cur_lib;
    }

    public static void createLibrary(String name) throws LibraryAlreadyExistsException {
        libraries.add(new Library(name));
    }

    public static void deleteLibrary(String name) throws LibraryNotFoundException, OnlyLibraryDeletionException {
        if (libraries.size() == 1) throw new OnlyLibraryDeletionException();
        Library found = findLibrary(name);

        libraries.remove(found);
    }

    public static Library findLibrary(String name) throws LibraryNotFoundException {
        for (Library l : libraries) {
            if (l.name.equals(name)) {
                return l;
            }
        }

        throw new LibraryNotFoundException();
    }
}
import java.util.ArrayList;

public class Searching {

    // ================================================
    // LINEAR SEARCH (O(n))
    // ================================================
    public static Task searchByName(ArrayList<Task> arr, String name) {
        for (Task t : arr) {       // O(n)
            if (t.name.equalsIgnoreCase(name)) return t;
        }
        return null;
    }
}

import java.util.ArrayList;

public class RecursionDisplay {

    // ================================================
    // DISPLAY TASKS REKURSIF (O(n))
    // ================================================
    public static void displayRecursive(ArrayList<Task> arr, int index) {
        if (index == arr.size()) {
            return;
        }

        System.out.println(arr.get(index));
        displayRecursive(arr, index + 1); // rekursi
    }
}

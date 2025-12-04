import java.util.ArrayList;

public class Sorting {

    // ================================================
    // MERGE SORT BY DEADLINE (O(n log n))
    // ================================================
    public static void mergeSort(ArrayList<Task> arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Rekursi → WAJIB dalam tugas
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(ArrayList<Task> arr, int left, int mid, int right) {
        ArrayList<Task> temp = new ArrayList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr.get(i).deadline.compareTo(arr.get(j).deadline) <= 0) {
                temp.add(arr.get(i++));
            } else {
                temp.add(arr.get(j++));
            }
        }

        while (i <= mid) temp.add(arr.get(i++));
        while (j <= right) temp.add(arr.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            arr.set(left + k, temp.get(k));
        }
    }
}

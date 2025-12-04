import java.util.*;

public class Main {
    static PriorityQueueTask pq = new PriorityQueueTask();
    static int counterID = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TO DO LIST PRIORITY SYSTEM =====");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Ambil Tugas Prioritas Tertinggi");
            System.out.println("3. Tampilkan Semua (Rekursif)");
            System.out.println("4. Sorting by Deadline (Merge Sort)");
            System.out.println("5. Cari Task (Searching)");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask(sc);
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    displayTasksRecursive();
                    break;
                case 4:
                    sortDeadline();
                    break;
                case 5:
                    searchTask(sc);
                    break;
                case 6:
                    return;
            }
        }
    }

    // Tambah Data
    public static void addTask(Scanner sc) {
        System.out.print("Nama Tugas: ");
        String name = sc.nextLine();

        System.out.print("Prioritas (1=tinggi, 3=rendah): ");
        int priority = sc.nextInt();
        sc.nextLine();

        System.out.print("Deadline (YYYY-MM-DD): ");
        String deadline = sc.nextLine();

        Task t = new Task(counterID++, name, priority, deadline);
        pq.insert(t);

        System.out.println("Tugas berhasil ditambahkan.");
    }

    // Ambil tugas paling prioritas
    public static void removeTask() {
        Task t = pq.remove();
        if (t == null) {
            System.out.println("Tidak ada tugas.");
        } else {
            System.out.println("Tugas diambil: " + t);
        }
    }

    // Tampilkan rekursif
    public static void displayTasksRecursive() {
        RecursionDisplay.displayRecursive(pq.getAll(), 0);
    }

    // Sorting Deadline
    public static void sortDeadline() {
        ArrayList<Task> arr = pq.getAll();
        Sorting.mergeSort(arr, 0, arr.size() - 1);
        System.out.println("Sorting berdasarkan deadline selesai.");
    }

    // Searching
    public static void searchTask(Scanner sc) {
        System.out.print("Cari nama tugas: ");
        String name = sc.nextLine();

        Task result = Searching.searchByName(pq.getAll(), name);

        if (result == null)
            System.out.println("Tugas tidak ditemukan.");
        else
            System.out.println("Ditemukan: " + result);
    }
}

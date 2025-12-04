import java.util.ArrayList;

public class PriorityQueueTask {
    private ArrayList<Task> heap;

    public PriorityQueueTask() {
        heap = new ArrayList<>();
    }

    // ================================================
    // INSERT TASK KE DALAM HEAP (O(log n))
    // ================================================
    public void insert(Task t) {
        heap.add(t);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        // O(log n)
        while (index > 0) {
            int parent = (index - 1) / 2;

            // prioritas kecil = lebih penting
            if (heap.get(index).priority < heap.get(parent).priority) {
                swap(index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }

    // ================================================
    // REMOVE TASK PRIORITAS TERTINGGI (O(log n))
    // ================================================
    public Task remove() {
        if (heap.isEmpty()) return null;

        Task root = heap.get(0);
        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    private void heapifyDown(int index) {
        // O(log n)
        int smallest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < heap.size() &&
            heap.get(left).priority < heap.get(smallest).priority) {
            smallest = left;
        }

        if (right < heap.size() &&
            heap.get(right).priority < heap.get(smallest).priority) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int a, int b) {
        Task temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public ArrayList<Task> getAll() {
        return heap;
    }
}

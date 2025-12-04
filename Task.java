public class Task {
    int id;
    String name;
    int priority; // 1 = tinggi, 3 = rendah
    String deadline;

    public Task(int id, String name, int priority, String deadline) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[ID: " + id + " | " + name + " | Prioritas: " + priority + " | Deadline: " + deadline + "]";
    }
}

public class Task {
    int id;
    String title;
    String priority;
    boolean completed;

    Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task[ID=" + id + ", Title=" + title + ", Priority=" + priority + ", Completed=" + completed + "]";
    }
}

import java.util.NoSuchElementException;

public class Queue {
    private Node front, rear;

    void enqueue(Task task) {
        Node newNode = new Node(task);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    Task dequeue() {
        if (front == null) throw new NoSuchElementException("Queue is empty");
        Task task = front.task;
        front = front.next;
        if (front == null) rear = null;
        return task;
    }
}



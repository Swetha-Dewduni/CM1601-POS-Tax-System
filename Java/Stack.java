import java.util.NoSuchElementException;

public class Stack {
    private Node top;

    void push(Task task) {
        Node newNode = new Node(task);
        newNode.next = top;
        top = newNode;
    }

    Task pop() {
        if (top == null) throw new NoSuchElementException("Stack is empty");
        Task task = top.task;
        top = top.next;
        return task;
    }
}




public class LinkedList {
    Node head;

    void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void removeTask(int id) {
        if (head == null) return;
        if (head.task.id == id) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.task.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    void bubbleSortByPriority() {
        if (head == null) return;
        boolean swapped;
        Node current;
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                if (getPriorityValue(current.task.priority) < getPriorityValue(current.next.task.priority)) {
                    Task temp = current.task;
                    current.task = current.next.task;
                    current.next.task = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    int getPriorityValue(String priority) {
        return switch (priority) {
            case "High" -> 3;
            case "Medium" -> 2;
            case "Low" -> 1;
            default -> 0;
        };
    }

    void displayTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    void displayTasksByPriority(String priority) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.priority.equalsIgnoreCase(priority)) {
                System.out.println(temp.task);
            }
            temp = temp.next;
        }
    }

    void searchTaskByTitle(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.title.equalsIgnoreCase(title)) {
                System.out.println(temp.task);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    void searchTaskById(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.id == id) {
                System.out.println(temp.task);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }
}

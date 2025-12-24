import java.util.Scanner;

public class TaskManagementSystem {
    LinkedList taskList = new LinkedList();
    Stack undoStack = new Stack();
    Queue taskQueue = new Queue();
    int taskIdCounter = 1;

    void addTask(String title, String priority) {
        Task task = new Task(taskIdCounter++, title, priority);
        taskList.addTask(task);
        undoStack.push(task);
        System.out.println("Task added successfully.");
    }

    void removeTask(int id) {
        taskList.removeTask(id);
        System.out.println("Task removed successfully.");
    }

    void undoLastTask() {
        if (undoStack == null) {
            System.out.println("No task to undo.");
            return;
        }
        Task lastTask = undoStack.pop();
        removeTask(lastTask.id);
        System.out.println("Last task undone successfully.");
    }

    void displayTasks() {
        taskList.displayTasks();
    }

    void sortTasksByPriority() {
        taskList.bubbleSortByPriority();
    }

    void viewTasksByPriority(String priority) {
        taskList.displayTasksByPriority(priority);
    }

    void searchTaskByTitle(String title) {
        taskList.searchTaskByTitle(title);
    }

    void searchTaskById(int id) {
        taskList.searchTaskById(id);
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Undo Last Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Sort Tasks by Priority");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Search Task by Title");
            System.out.println("8. Search Task by ID");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task priority (Low/Medium/High): ");
                    String priority = scanner.nextLine();
                    system.addTask(title, priority);
                    break;
                case 2:
                    System.out.print("Enter task ID to remove: ");
                    int id = scanner.nextInt();
                    system.removeTask(id);
                    break;
                case 3:
                    system.undoLastTask();
                    break;
                case 4:
                    System.out.println("Task List:");
                    system.displayTasks();
                    break;
                case 5:
                    system.sortTasksByPriority();
                    System.out.println("Tasks sorted by priority.");
                    break;
                case 6:
                    System.out.print("Enter priority to view (Low/Medium/High): ");
                    String viewPriority = scanner.nextLine();
                    system.viewTasksByPriority(viewPriority);
                    break;
                case 7:
                    System.out.print("Enter task title to search: ");
                    String searchTitle = scanner.nextLine();
                    system.searchTaskByTitle(searchTitle);
                    break;
                case 8:
                    System.out.print("Enter task ID to search: ");
                    int searchId = scanner.nextInt();
                    system.searchTaskById(searchId);
                    break;
                case 9:
                    System.out.println("Exiting Task Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

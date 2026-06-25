package DSA.TaskManagementSystem;

public class TaskLinkedList {

    private Task head;

    // Add Task
    public void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
    }

    // Search Task
    public Task searchTask(int taskId) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == taskId) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks
    public void traverseTasks() {

        if (head == null) {
            System.out.println("No Tasks Available");
            return;
        }

        Task temp = head;

        while (temp != null) {

            System.out.println(
                    "Task ID: " + temp.taskId +
                    ", Name: " + temp.taskName +
                    ", Status: " + temp.status);

            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("Task List is Empty");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully");
            return;
        }

        Task current = head;
        Task previous = null;

        while (current != null && current.taskId != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task Not Found");
            return;
        }

        previous.next = current.next;
        System.out.println("Task Deleted Successfully");
    }
}
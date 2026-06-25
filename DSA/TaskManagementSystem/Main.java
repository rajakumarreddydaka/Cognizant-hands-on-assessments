package DSA.TaskManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskLinkedList taskList = new TaskLinkedList();

        int choice;

        do {

            System.out.println("\nWelcome to TASK MANAGEMENT SYSTEM ");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display All Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Task Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Task Status: ");
                        String status = sc.nextLine();

                        taskList.addTask(id, name, status);

                        System.out.println("Task Added Successfully.");
                        break;

                    case 2:

                        System.out.print("Enter Task ID to Search: ");
                        int searchId = sc.nextInt();

                        Task found = taskList.searchTask(searchId);

                        if (found != null) {
                            System.out.println("\nTask Found");
                            System.out.println("Task ID : " + found.taskId);
                            System.out.println("Task Name : " + found.taskName);
                            System.out.println("Status : " + found.status);
                        } else {
                            System.out.println("Task Not Found.");
                        }

                        break;

                    case 3:

                        System.out.println("\n===== TASK LIST =====");
                        taskList.traverseTasks();
                        break;

                    case 4:

                        System.out.print("Enter Task ID to Delete: ");
                        int deleteId = sc.nextInt();

                        taskList.deleteTask(deleteId);
                        break;

                    case 5:

                        System.out.println("Exiting Task Management System...");
                        break;

                    default:

                        System.out.println("Invalid Choice! Please select between 1 and 5.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input! Please enter numeric values where required.");
                sc.nextLine(); // clear invalid input

                choice = 0;

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}
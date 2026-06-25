package DSA.EmployeeManagementSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;

        // Taking array size safely
        while (true) {
            try {
                System.out.print("Enter maximum number of employees: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Size must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                sc.nextLine();
            }
        }

        Employee[] employees = new Employee[n];

        while (true) {

            System.out.println("\nWelcome to Employee Management System");
            System.out.println("Click 1 ,To Add Employee");
            System.out.println("Click 2 ,Search Employee");
            System.out.println("Click 3 ,Traverse Employees");
            System.out.println("Click 4 ,Delete Employee");
            System.out.println("Click 5 ,Exit");
            System.out.print("Enter your choice: ");

            try {

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        try {

                            System.out.print("Enter Employee ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Employee Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Position: ");
                            String position = sc.nextLine();

                            System.out.print("Enter Salary: ");
                            long salary = sc.nextLong();

                            Employee e = new Employee(id, name, position, salary);

                            Employee.add(employees, e);

                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input! Please enter correct values.");
                            sc.nextLine();
                        }

                        break;

                    case 2:

                        try {

                            System.out.print("Enter Employee ID to Search: ");
                            int searchId = sc.nextInt();

                            boolean found = Employee.Search(employees, searchId);

                            if (found) {
                                System.out.println("Employee Found.");
                            } else {
                                System.out.println("Employee Not Found.");
                            }

                        } catch (InputMismatchException ex) {
                            System.out.println("Employee ID must be an integer.");
                            sc.nextLine();
                        }

                        break;

                    case 3:

                        boolean empty = true;

                        for (Employee emp : employees) {
                            if (emp != null) {
                                empty = false;
                                break;
                            }
                        }

                        if (empty) {
                            System.out.println("No employee records available.");
                        } else {
                            Employee.traverse(employees);
                        }

                        break;

                    case 4:

                        try {

                            System.out.print("Enter Employee ID to Delete: ");
                            int deleteId = sc.nextInt();

                            Employee.delete(employees, deleteId);

                        } catch (InputMismatchException ex) {
                            System.out.println("Employee ID must be an integer.");
                            sc.nextLine();
                        }

                        break;

                    case 5:

                        System.out.println("Thank you for using Employee Management System.");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Choice! Please choose between 1 and 5.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid menu option.");
                sc.nextLine();
            }
        }
    }
}
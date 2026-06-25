package DSA.SortingCustomerOrders;
import java.util.*;
public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of orders: ");
        int n =sc.nextInt();
        sc.nextLine();

        Order[] arr = new Order[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Order " + (i + 1));

            int orderId;
            long totalPrice;

            // Order ID Input Validation
            while (true) {
                try {
                    System.out.print("Enter Order ID: ");
                    orderId = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Order ID must be an integer.");
                    sc.nextLine();
                }
            }

            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();

            // Total Price Input Validation
            while (true) {
                try {
                    System.out.print("Enter Total Price: ");
                    totalPrice = sc.nextLong();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Total Price must be an Integer.");
                    sc.nextLine();
                }
            }
            arr[i] = new Order(orderId, customerName, totalPrice);
        }

        Order[] bubbleArr = arr.clone();
        Order[] quickArr = arr.clone();

        System.out.println("\nOrders Before Sorting:");
        Order.display(arr);

        // Bubble Sort
        Order.bubbleSort(bubbleArr);
        System.out.println("\nOrders After applying Bubble Sort:");
        Order.display(bubbleArr);

        // Quick Sort
        Order.quickSort(quickArr, 0, arr.length - 1);
        System.out.println("\nOrders After applying Quick Sort :");
        Order.display(quickArr);

        sc.close();
    }
}

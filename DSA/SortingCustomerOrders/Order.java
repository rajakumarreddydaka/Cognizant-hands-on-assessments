package DSA.SortingCustomerOrders;

public class Order {
   int orderId; 
   String customerName;
   long totalPrice;

    Order(int orderId , String customerName , long totalPrice){
      this.orderId=orderId;
      this.customerName =customerName;
      this.totalPrice =totalPrice;
    }

    //Method to sort using bubble sort :
     public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //Method to sort using Quick Sort :
    public static void quickSort(Order[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition Method
    private static int partition(Order[] arr, int low, int high) {

        long pivot = arr[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                    i++;
            Order temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    //Method to display the data :
      public static void display(Order[] arr) {
        for (Order o : arr) {
            System.out.println(
                    "Order ID: " + o.orderId +
                    " Customer: " + o.customerName +
                    " Total Price: " + o.totalPrice);
        }
    }
}
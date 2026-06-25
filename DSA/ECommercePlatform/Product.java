package DSA.ECommercePlatform;

public class Product {
    int productId;
    String productName,category;

    Product(int pid , String pname , String cat){
        productId =pid;
        productName =pname;
        category =cat;
    }
    // Method to add the data into the array :
    public static boolean add(Product[] arr, Product p) {
        // Checking duplicate productId
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].productId == p.productId) {
                System.out.println("Product ID already exists. Cannot add.");
                return false;
            }
        }
             // Inserting the data into the array :
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = p;
                System.out.println("Product added successfully.");
                return true;
            }
        }
        System.out.println("Array is full.");
        return false;
    }
    // Method to display the data in the array :
     public static void display(Product[] arr) {
        System.out.println("\nProducts List:");
        for (Product p : arr) {
            if (p != null) {
                System.out.println("ID: " + p.productId +" Name: " + p.productName +
                        " Category: " + p.category);
            }
        }
    }

    //Method for linear search :
    public static Product linearsearch(Product []arr, int k){
        for(Product p:arr){
            if(p.productId ==k){
                return p;
            }
        }
        return null;
    }

    //Method for binary Search:
    public static Product binarysearch(Product []arr, int k){
        int low =0,high = arr.length-1;

        while(low<high){
            int mid =low+(high-low)/2;
            if(arr[mid].productId==k){
                return arr[mid];
            }
            else if(arr[mid].productId<k){
                low =mid+1;
            }
            else{
                high =mid;
            }
        }
        return null;
    }
}

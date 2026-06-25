package DSA.ECommercePlatform;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of users data you will insert :");
        int n =sc.nextInt();
        Product []arr = new Product[n];
        for(int i =0;i<n;i++){
            System.out.println("Enter the details of product "+(i+1));
                int pid = 0;
                try {
                    System.out.print("Product ID: ");
                    pid = sc.nextInt();
                    sc.nextLine(); 
                }
                catch (InputMismatchException e) {
                    System.out.println("Error: Product ID must be an integer.");
                    sc.nextLine(); 
                }
                System.out.print("Product Name :");
            String pname =sc.nextLine();
                System.out.print("Product Category :");
            String category =sc.nextLine();
            Product p = new Product(pid, pname, category);
            Product.add(arr, p);
        }
        System.out.println("The data stored in the Ecommerce platform is : ");
        Product.display(arr);
        System.out.print("\nEnter Product ID to search: ");
        int key = sc.nextInt();

         Product result = Product.linearsearch(arr, key);
        if (result != null) {
            System.out.println("Product Found using the linear search");
            System.out.println("ID: " + result.productId);
            System.out.println("Name: " + result.productName);
            System.out.println("Category: " + result.category);
        } else {
            System.out.println("Product Not Found using the linear search\n");
        }

        Product result2 = Product.binarysearch(arr, key);
        if (result2 != null) {
            System.out.println("Product Found using the binary search");
            System.out.println("ID: " + result2.productId);
            System.out.println("Name: " + result2.productName);
            System.out.println("Category: " + result2.category);
        } else {
            System.out.println("Product Not Found using binary search");
        }
        sc.close();
    }
}

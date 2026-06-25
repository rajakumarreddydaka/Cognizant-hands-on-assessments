package DSA.InventoryManagementSystem;
import java.util.*;
public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,Product>hs = new HashMap<>();
        System.out.println("Welcome to InventoryManagement System");
        System.out.println("You can perform the add,update and delete operations");
        boolean b =true;

      while(b){
        System.out.println("Enter 1 to add data , 2 to update the data , 3 to delete the data , 4 to exit from the inventory management system");
        System.out.print("Enter the choice to perform the required task :");
        int n =sc.nextInt();
        sc.nextLine();

        if(n==1){
          System.out.print("Enter the Product id :");
          String pid =sc.next();
          sc.nextLine();
          System.out.print("Enter the Product Name :");
          String pname =sc.nextLine();
          int q =0;
          double price=0;

          try{
            System.out.print("Enter the quantity of the product :");
           q =sc.nextInt();
            if (q <= 0) {
            System.out.println("Quantity must be greater than 0 cannot able to add the data");
            continue;
            }

          }catch(InputMismatchException e){
           System.out.println("Please Enter a valid integer quantity ");
            sc.nextLine(); 
           }
          
          try{
          System.out.print("Enter the price of product :");
           price =sc.nextDouble();
            if(price <=0){
            System.out.println("Price must be greater than 0 cannot able to add the data ");
            continue;
             }
          }catch(InputMismatchException e){
           System.out.println("Please Enter a valid price");
            sc.nextLine(); 
           }


          if(q>0 && price>0){
            Product p = new Product(pid, pname,q,price);
            Product.add(p,hs);
          }

        }

        else if(n==2){
           System.out.print("Enter the Product id :");
          String pid =sc.next();
          sc.nextLine();
          System.out.print("Enter the Product Name :");
          String pname =sc.nextLine();
          int q =0;
          double price=0;

          try{
            System.out.print("Enter the quantity of the product :");
           q =sc.nextInt();
            if (q <= 0) {
            System.out.println("Quantity must be greater than 0 cannot able to add the data");
            continue;
            }
          }catch(InputMismatchException e){
           System.out.println("Please Enter a valid integer quantity ");
            sc.nextLine(); 
          }
          
          try{
          System.out.print("Enter the price of product :");
           price =sc.nextDouble();
            if(price <=0){
            System.out.println("Price must be greater than 0 cannot able to add the data ");
            continue;
            }
          }catch(InputMismatchException e){
           System.out.println("Please Enter a valid price");
            sc.nextLine(); 
          }
          if(q>0 && price>0){
            Product p = new Product(pid, pname,q,price);
            Product.update(p, hs);
          }
          else{
            System.out.println("There is some error in the data re enter it correctly :");
          }
        }

        else if(n==3){
          System.out.print("Enter the Product id :");
          String pid =sc.next();
          Product.delete(pid, hs);
        }

        else if(n==4){
          System.out.println("Exiting the system");
          b = false;
        }
        
        else{
          System.out.println("Enter a valid number to perform the operations ");
        }

      }//End of the while loop 

      //Displaying the data 
      System.out.println("The final data after all operations :\n");
      System.out.println("PRODUCT ID | PRODUCT NAME | QUANTITY | PRICE");
      Product.display(hs);
      sc.close();
    }
}

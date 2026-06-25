package DSA.InventoryManagementSystem;
import java.util.HashMap;
public class Product{
   String  productId, productName;
   int quantity;
   double price;
  Product(String pid,String pname, int q, double p){
    productId =pid;
    productName =pname;
    quantity =q;
    price =p;
  }  

  //Method to add the data entered by the user :
  public static void add(Product p,HashMap<String ,Product>hs){
    if(!hs.containsKey(p.productId)){
     hs.put(p.productId,p);
     System.out.println("The product data has stored successfully\n");
    }
    else{
        Product existing =hs.get(p.productId);

        if(existing.productName.equals(p.productName) && (existing.price==p.price)){
           existing.quantity +=p.quantity;
        }
        else{
        System.out.println("Cannot add the product , An item already exists "+
         "with that id , add the proper details so that the quantity can be increased \n");
        }
    }
  }
  
  //Method to update the data entered by the user:
  public static void update(Product p,HashMap<String,Product>hs){
    if(!hs.containsKey(p.productId)){
        System.out.println("The Product is added to the inventory\n");
        hs.put(p.productId,p);
    }
    else{
      Product existing =hs.get(p.productId);
      if(p.productName !=null && !p.productName.trim().isEmpty()){
      existing.productName=p.productName;
      System.out.println("The product Name updated successfully\n");
      }
      if(p.price>0){
      existing.price =p.price;
      System.out.println("The price is updated successfully\n");
      }
      if(p.quantity >0){
      existing.quantity =p.quantity;
      System.out.println("The quantity is updated successfully\n");
      }
      System.out.println("The following updates are done to the system\n");
    }
  }

  public static void delete(String pid,HashMap<String,Product>hs){
    if(!hs.containsKey(pid)){
      System.out.println("The Product Id : "+pid+" doesnot exists in the Inventory management System\n");
    }
    else{
      hs.remove(pid);
      System.out.println("The product with Product id :"+pid+" is removed successfully\n");
    }
  }

    public static void display(HashMap<String,Product> hs){
        for(Product p : hs.values()){
    System.out.println(
        p.productId + "\t" +
        p.productName + "\t" +
        p.quantity + "\t" +
        p.price);
        }
      }
}
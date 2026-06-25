package DSA.EmployeeManagementSystem;

public class Employee {
   int employeeId;
   String name, position; 
   long salary;

    Employee(int empid , String name , String position, long sal){
        this.employeeId =empid;
        this.name = name;
        this.position =position;
        this.salary =sal;
    }

    public static boolean add(Employee []arr,Employee e){
        //checking for duplicate employeeId:
        for(int i =0;i<arr.length;i++){
            if(arr[i] !=null &&arr[i].employeeId ==e.employeeId){
                System.out.println("Empployee Id already exists cannot able to add!!");
                return false;
            }
        }

        for(int i =0;i<arr.length;i++){
            if(arr[i] ==null){
                arr[i] =e;
                System.out.println("Employee details addedd successfully");
                return true;
            }
        }
        System.out.println("Array is full. you cannot add data");
        return false;
    }
    public static boolean isEmpty(Employee[] arr) {

     for (int i = 0; i < arr.length; i++) {
        if (arr[i] != null) {
            return false;
        }
     }

    return true;
    }
    public static boolean Search(Employee[] arr, int eid) {

    if (isEmpty(arr)) {
        System.out.println("There is no data to perform this operation.");
        return false;
    }
    for (int i = 0; i < arr.length; i++) {

        if (arr[i] != null && arr[i].employeeId == eid) {
            return true;
        }
    }
    return false;
    }
    
    public static void traverse(Employee[] arr) {

    if (isEmpty(arr)) {
        System.out.println("There is no data to perform this operation.");
        return;
    }

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] != null) {

            System.out.println(
                    "EmployeeId : " + arr[i].employeeId +
                    " Name : " + arr[i].name +
                    " Position : " + arr[i].position +
                    " Salary : " + arr[i].salary);
        }
    }
}

public static boolean delete(Employee[] arr, int empId) {

    if (isEmpty(arr)) {
        System.out.println("There is no data to perform this operation.");
        return false;
    }

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] != null && arr[i].employeeId == empId) {

            for (int j = i; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }

            arr[arr.length - 1] = null;

            System.out.println("Employee deleted successfully.");
            return true;
        }
    }

    System.out.println("Employee not found.");
    return false;
}

}

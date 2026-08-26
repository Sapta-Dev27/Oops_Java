import java.util.*;

class Employee {
    String name ;
    String department;
    long empId;

    Employee(){
        this.name = "DEFAULT_NAME";
        this.department = "DEFAULT_DEPARTMENT";
        this.empId = 111111111;
    }
    Employee(String name , String department , long empId){
        this.name = name;
        this.department = department;
        this.empId= empId;
    }
    Employee(String name) {
        this.name = name;
    }
    Employee( long empId) {
        this.empId = empId;
    }
    public void displayInfo(){
         if( empId != 0 && name != null &&  department !=null){
             System.out.println("Employee Name : " + name);
             System.out.println("Employee Department : " + department);
             System.out.println("Employee EmpId : " + empId);
         }
         if(empId == 0 && department == null){
             System.out.println("Employee Name is :" +name);
             System.out.println("Employee EmpId is NULL");
             System.out.println("Employee Department is NULL");
         }
         if(department == null && name == null) {
             System.out.println("Employee Department is NULL");
             System.out.println("Employee EmpId is :" +empId);
             System.out.println("Employee Name is NULL");
         }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the employee :");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter the department of the employee :");
        String dept = sc.next();
        sc.nextLine();
        System.out.println("Enter the empid of the employee :");
        long empId = sc.nextLong();
        Employee emp1 = new Employee(name,dept,empId);
        Employee emp2 = new Employee(name);
        Employee emp3 = new Employee(empId);
        Employee emp4 = new Employee();
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
    }
}
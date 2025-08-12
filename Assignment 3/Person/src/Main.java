import java.util.Scanner;
class Person{
    String name ;
    int age ;
    String gender;
    Person(String name , int age , String gender){
        this.name = name ;
        this.age = age;
        this.gender = gender;
    }
    public boolean isAdult(int age){
        if(age >= 18 && age <=60){
            return true;
        }
        return false;
    }
    public void displayInfo(String name , int age , String gender){
        System.out.println("Name is :" +name);
        System.out.println("Age is :" +age);
        System.out.println("Gender is :" +gender);
    }
}
class Employee extends Person{
    long empId;
    String dept;
    double Salary;
    Employee(String name , int age , String gender, long empId , String dept, double Salary){
        super(name,age,gender);
        this.empId = empId;
        this.dept = dept;
        this.Salary = Salary;
    }
    public double getBonus(){
        double bonus = (Salary*0.1);
        return bonus;
    }
    public void displayEmployeeInfo(){
       super.displayInfo(name , age , gender);
        System.out.println("Employee id is :" +empId);
        System.out.println("Employee dept is :" +dept);
        System.out.println("Employee salary is :" +Salary);
    }
    public boolean getEligibility() {
        boolean ans = super.isAdult(age);
        return ans;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your age" );
        int age = sc.nextInt();
        System.out.println("Enter your gender");
        String gender = sc.next();
        System.out.println("Enter your id");
        long empId = sc.nextLong();
        System.out.println("Enter your department ");
        String dept = sc.next();
        System.out.println("Enter your Salary");
        double Salary = sc.nextDouble();
        Employee emp1 = new Employee(name , age , gender , empId, dept , Salary);
        emp1.displayEmployeeInfo();
        System.out.println("Is eligible :"+emp1.getEligibility());
        double bonus = emp1.getBonus();
        System.out.println("Bonus is :" +bonus);
    }
}
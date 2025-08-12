import java.util.*;
class Person{
    String name ;
    int age ;
    Person(String name , int age){
        this.name = name ;
        this.age = age;
    }
    public void displayPerson(){
        System.out.println("Name is :" +name);
        System.out.println("AGe is :" +age);
    }
}

class Employee extends Person{
   long empId;
   String dept ;
   Employee(String name , int age , long empId , String dept){
       super(name ,age);
       this.empId=empId;
       this.dept = dept;
   }
   public void displayEmployee(){
       super.displayPerson();
       System.out.println("ID of employee is :" +empId);
       System.out.println("Dept is : " +dept);
   }
}


class Manager extends  Employee{
    int teamSize;
    String project;
    Manager( String name , int age , long empId , String dept , int teamSize , String project){
        super(name , age , empId , dept);
        this.teamSize = teamSize;
        this.project = project;
    }
    public void displayManager(){
        super.displayEmployee();
        System.out.println("Team size is : " + teamSize);
        System.out.println("Project name is : " +project);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter age :");
        int age = sc.nextInt();
        System.out.println("Enter empId :");
        long empId = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter dept :");
        String dept = sc.nextLine();
        System.out.println("Enter teamSize :");
        int teamSize = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter project :");
        String project = sc.nextLine();
        Manager m1 = new Manager(name , age , empId , dept , teamSize , project);
        m1.displayManager();
    }
}
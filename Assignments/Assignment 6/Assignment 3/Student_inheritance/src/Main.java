import java.util.*;
class Person{
    String name ;
    int age;
    Person(String name , int age){
        this.name = name;
        this.age = age;
    }
    public void displayInfo(){
        System.out.println("Name is : " +name);
        System.out.println("Age is : " +age);
    }
}

class Student extends Person{
    long rollNo;
    String course ;
    Student(String name , int age , long rollNo , String Course){
        super(name ,age);
        this.name =name ;
        this.rollNo = rollNo;
        this.course = Course;
    }
    public void displayStudentInfo() {
        super.displayInfo();
        System.out.println("Roll No of student is :" +rollNo);
        System.out.println("Course is : " +course);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person :");
        String name = sc.nextLine();
        System.out.println("Enter the age of the person :");
        int age = sc.nextInt();
        System.out.println("Enter the course of the person :");
        String course = sc.next();
        System.out.println("Enter the roll number of the student :");
        long rollNo = sc.nextLong();
        Student s1 = new Student(name , age , rollNo , course);
        s1.displayStudentInfo();
    }
}
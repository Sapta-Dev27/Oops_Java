import java.util.*;

class Student {
    double marks ;
    String name ;
    long rollNo;
    Student(double marks, String name , long rollNo){
        this.marks = marks ;
        this.name = name;
        this.rollNo=rollNo;
    }
    public String getGrade(){
        if( marks >= 90){
            return "A";
        }
        else if( marks >= 80 && marks < 90){
            return "B";
        }
        else if( marks >=70 && marks < 80){
            return "C";
        }
        else if( marks >=60 && marks < 70){
            return "D";
        }
        else {
            return "F";
        }
    }
    public void displayInfo() {
        System.out.println("Marks: " + marks);
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Grade: " + getGrade());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Marks: ");
        double marks = sc.nextDouble();
        System.out.println("Enter Name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter Roll No: ");
        long rollNo = sc.nextLong();
        Student s1 = new Student(marks,name,rollNo);
        s1.displayInfo();
    }
}
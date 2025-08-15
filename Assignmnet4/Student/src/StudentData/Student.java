package StudentData;

public class Student {
    long rollNo;
     String name ;
    double marks ;

    public Student(long rollNo , String name , double marks ) {
         this.rollNo = rollNo;
         this.name = name ;
         this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Name of student is :" +name);
        System.out.println("Roll number of student is :" +rollNo);
        System.out.println("Marks of student is :" +marks);
    }
}

import java.util.*;
import StudentData.Student;


public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of students ");
        int n = sc.nextInt();

        /*iterative appraoch*/

        for ( int i = 0 ; i < n ; i++ ) {
            System.out.println("Enter student name ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter student marks ");
            double marks = sc.nextDouble();
            System.out.println("Enter student roll no");
            long rollNo = sc.nextLong();
            Student s1 = new Student(rollNo , name , marks);
            s1.displayDetails();
        }

        /* LONG APPROACH */
        /*
        System.out.println("Enter the name of student 1");
        String name1 = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the rollNo of student 1 ");
        long rollNo1 = sc.nextLong();
        System.out.println("Enter the marks of student 1 ");
        double marks1 = sc.nextDouble();
        Student s1 = new Student(rollNo1 , name1, marks1);
        s1.displayDetails();
        System.out.println("Enter the name of student 2 ");
        String name2 = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the rollNo of student 2");
        long rollNo2 = sc.nextLong();
        System.out.println("Enter the marks of student 2");
        double marks2 = sc.nextDouble();
        Student s2 = new Student(rollNo2 , name2 , marks2);
        s2.displayDetails();
        System.out.println("Enter the name of student 3 ");
        String name3 = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the rollNo of student 3");
        long rollNo3 = sc.nextLong();
        System.out.println("Enter the marks of student 3");
        double marks3 = sc.nextDouble();
        Student s3 = new Student(rollNo3 , name3 , marks3);
        s3.displayDetails();*/
    }
}

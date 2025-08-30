import java.util.*;
import university.students.Students;
import university.faculty.Faculty;
import university.administration.SalaryManager;


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student Name");
        String name = sc.nextLine();
        System.out.println("Enter Student Course");
        String course = sc.nextLine();
        int[] marks = new int[5];
        System.out.println("Enter Student Marks");
        for(int i = 0 ; i < 5 ;i++){
            marks[i] = sc.nextInt();
        }
        Students s1 = new Students(id,name,course,marks);
        s1.displayInfo();

        System.out.println("Enter Faculty ID");
        int facId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Faculty Name");
        String facName = sc.nextLine();
        System.out.println("Enter Faculty Dept");
        String facDept = sc.nextLine();
        String[] facSubs = new String[5];
        System.out.println("Assign subjects to faculty");
        for(int i = 0 ; i < 5 ; i++){
            facSubs[i] = sc.nextLine();
        }
        Faculty f1 = new Faculty(facId,facName,facDept,facSubs);
        f1.displayFacultyDetails();

        System.out.println("Enter Employee Salary");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Employee role");
        String  role = sc.nextLine();
        SalaryManager sm1 = new SalaryManager(role,salary);
        double totalSalary =sm1.calculateTotalSalary();
        System.out.println("Total Salary is: "+totalSalary);
    }
}
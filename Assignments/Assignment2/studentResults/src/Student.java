import java.util.Scanner;
class Student {
    int roll;
    String name ;
    int subject1, subject2 , subject3;

    //parameterized constructor//
    Student(int roll_no , String student_name , int subject1_marks , int subject2_marks , int subject3_marks  ) {
        this.roll = roll_no;
        this.name = student_name;
        this.subject1 = subject1_marks;
        this.subject2 = subject2_marks;
        this.subject3 = subject3_marks;
    }
    //default constructor//
    Student(){
        this.roll= 0;
        this.name= "";
        this.subject1= 0;
        this.subject2=0;
        this.subject3=0;
    }
    int totalMarks() {
        return subject1+subject2+subject3;
    }
    double getPercentMarks(){
        return totalMarks()/3.0;
    }
    void displayResults(){
        System.out.println("Roll of student :" + roll);
        System.out.println("Name of student :" + name);
        System.out.println("Marks of student in subject1 :" +subject1);
        System.out.println("Marks of student in subject2 :" +subject2);
        System.out.println("Marks of student in subject3 :" +subject3);
        System.out.println("Total marks of student :"+ totalMarks());
        System.out.println("Percent marks of student :" +getPercentMarks());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll no :");
        int roll_no = sc.nextInt();
        System.out.println("Enter name of student :");
        String student_name = sc.next();
        System.out.println("Enter marks of student in subject1 :");
        int subject1_marks = sc.nextInt();
        System.out.println("Enter marks of student in subject2 :");
        int subject2_marks = sc.nextInt();
        System.out.println("Enter marks of student in subject3 :");
        int subject3_marks = sc.nextInt();
        Student Saptarshi = new Student(roll_no , student_name , subject1_marks , subject2_marks ,subject3_marks);
        Saptarshi.displayResults();
    }
}
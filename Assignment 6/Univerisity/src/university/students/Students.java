package university.students;

public class Students {

    /*creating the dataMembers*/
    int studentId;
    String studentName;
    String studentCourse;
    int[] marks = new int[5];

    /*Default constructor*/
    public Students() {
        this.studentId=0;
        this.studentName="";
        this.studentCourse="";
        for(int i = 0 ; i < 5; i++){
            this.marks[i] = 0;
        }
    }

    /*parameterized Constructor*/
    public Students(int id, String name , String course , int[] marks){
        this.studentId=id;
        this.studentName=name;
        this.studentCourse=course;
        this.marks=marks ;
    }

    /*member Methods : calculateAvgMarks()*/
    public int calculateAvgMarks(){
        int sum = 0;
        int avg = 0;
        for(int i = 0 ; i < 5 ; i++) {
            sum = sum + marks[i];
        }
        avg = sum/5;
        return avg;
    }

    /*member Methods : displayStudentsInfo()*/
    public void displayInfo(){
        System.out.println("Name is " +studentName);
        System.out.println("Course is" +studentCourse);
        for(int i =0 ; i < 5 ; i++) {
            System.out.println("Marks of subject" + (i+1) + "is" + marks[i]);
        }
        System.out.println("Avg marks is" + calculateAvgMarks());
    }
}
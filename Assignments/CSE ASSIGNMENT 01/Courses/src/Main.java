import java.util.*;

class Courses{
    String name ;
    String code ;
    Courses() {
        this.name = "" ;
        this.code = "";
    }
    Courses(String name , String Code){
        this.name = name ;
        this.code = Code;
    }
    public  void getCourseDetails() {
        System.out.println("Course name :" +name);
        System.out.println("Course code :" +code);
    }

    public void setCourseDetails(String n , String c) {
        this.name = n;
        this.code = c ;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st course name :");
        String name = sc.nextLine();
        System.out.println("Enter the 2nd course code :");
        String code = sc.nextLine();
        Courses c1 = new Courses(name , code);
        c1.getCourseDetails();
        System.out.println("Enter the 2nd course name :");
        String name2 = sc.nextLine();
        System.out.println("Enter the 2nd course code :");
        String code2 = sc.nextLine();
        Courses c2 = new Courses();
        c2.setCourseDetails(name2 , code2);
        c2.getCourseDetails();
    }
}
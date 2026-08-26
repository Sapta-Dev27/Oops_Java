import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        String students[] = new String[n];
        for(int i = 0 ; i < n ; i++){
            students[i] = sc.next();
        }
        System.out.println("Enter the desired index of the student: ");
        int index = sc.nextInt();
        try{
            System.out.println("Student Name is : " + students[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index : " +e.getMessage());
        }
        finally {
            System.out.println("Try and catch executed successfully");
        }
    }
}
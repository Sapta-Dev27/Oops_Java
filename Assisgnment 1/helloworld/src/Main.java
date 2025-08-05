import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the 3 numbers :");
    System.out.println("Enter the 1st number :");
    int a = sc.nextInt();
    System.out.println("Enter the 2nd number :");
    int b = sc.nextInt();
    System.out.println("Enter the 3rd Number :");
    int c = sc.nextInt();
    if ( a > b &&  a > c) {
        System.out.println("A is the greatest number");
    }
    else if(  a < b && b > c) {
        System.out.println("B is the greatest number");
    }
    else {
        System.out.println("C is the greatest  number");
    }
    }
}
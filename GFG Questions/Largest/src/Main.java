import java.util.*;

class Largest {
    public int largest(int a , int b , int c) {
        if( a>b && a >c){
            return a;
        }
        else if( b > a && b > c){
            return b;
        }
        else {
            return c;
        }
    }
    public double largest(double a , double b , double c){
        if ( a > b && a > c){
            return a;
        }
        else if( b > c && b > a){
            return b;
        }
        else {
            return c;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st 3  numbers");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        Largest l1 = new Largest();
        int largestNum1 = l1.largest(num1,num2,num3);
        System.out.println(largestNum1);
        System.out.println("Enter the next 3 numbers :");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double largestNum2 = l1.largest(a,b,c);
        System.out.println(largestNum2);
    }
}
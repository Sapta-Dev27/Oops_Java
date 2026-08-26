import org.w3c.dom.css.Rect;

import java.util.*;

class Rectangle {
    double length;
    double width;
    Rectangle(double l , double w) {
        this.length = l;
        this.width = w;
    }
    public double getArea() {
        return length*width;
    }
}

class Factorial {
    int n ;
    Factorial(int n ) {
        this.n =n ;

    }

    public long fact(int n) {
        long factorial ;
        if( n < 0) {
            System.out.println("ERROR: Factorial is negative");
            return -1;
        }
        else if( n == 0){
            return 1;
        }
        else {
            factorial = (n*fact(n-1));
        }
        return factorial;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle:");
        double l = sc.nextDouble();
        System.out.println("Enter the width of the rectangle:");
        double w= sc.nextDouble();
        Rectangle r1 = new Rectangle(l,w);
        System.out.println("Area of the rectangle is:"+r1.getArea());
        System.out.println("Enter the value of n for factorial :");
        int n = sc.nextInt();
        Factorial f1 = new Factorial(n);
        long result = f1.fact(n);
        System.out.println("Factorial of the rectangle is:"+result);
    }
}
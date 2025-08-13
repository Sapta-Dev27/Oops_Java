import java.util.*;

class Square {
    public int calArea(int length) {
        return length * length;
    }
    public double calArea(double length) {
        return length*length;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of your square 1:");
        int length1 = sc.nextInt();
        System.out.println("Enter the length of your square 2:");
        double length2 = sc.nextDouble();
        Square s1 = new Square();
        int area1 = s1.calArea(length1);
        double area2 =s1.calArea(length2);
        System.out.println("The area of the square is: " + area1);
        System.out.println("The area of the square is: " + area2);

    }
}
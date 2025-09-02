import java.util.Scanner;

interface Shape {
    public abstract double calcArea();
}

class Circle implements Shape {
    double radius ;
    Circle(double r) {
        this.radius = r;
    }
    @Override
    public double calcArea() {
        return 3.14*radius*radius;
    }
}

class Rectangle implements  Shape {
    double length;
    double width;
    Rectangle(double l , double w) {
        this.length=l;
        this.width=w;
    }
    @Override
    public double calcArea(){
        return length*width;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length and width");
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        Rectangle r1 = new Rectangle(l,w);
        double area1 = r1.calcArea();
        System.out.println("The area of the rectangle is "+area1);
        System.out.println("Enter the radius");
        double r = sc.nextDouble();
        Circle c1 = new Circle(r);
        double area2 = c1.calcArea();
        System.out.println("The area of the circle is "+area2);
    }
}
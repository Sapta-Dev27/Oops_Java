import java.util.*;
import java.util.concurrent.TransferQueue;

interface Shape {
    public abstract  double calculateArea();
    public  abstract void getShapeType();
}

class Circle implements  Shape {
    double radius;
    Circle (){
        this.radius = 1.0;
    }
    Circle (double radius){
        this.radius=radius;
    }
    @Override
    public double calculateArea(){
        return 3.14*radius*radius;
    }
    @Override
    public void getShapeType() {
        System.out.println("This is a Circle");
    }
}

class Triangle implements  Shape {
    double length;
    double height;
    Triangle(double length, double height){
        this.length=length;
        this.height=height;
    }
    @Override
    public double calculateArea(){
        return 0.5*length*height;
    }
    @Override
    public void getShapeType(){
        System.out.println("This is a Triangle");
    }
}

class Rectangle implements  Shape{
    double a;
    double b ;
    Rectangle(double a , double b) {
        this.a =a ;
        this.b=b;
    }
    @Override
    public double calculateArea(){
        return a*b;
    }
    @Override
    public void getShapeType(){
        System.out.println("This is a Rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle");
        double radius = sc.nextDouble();
        System.out.println("Enter the length of triangle");
        double length = sc.nextDouble();
        System.out.println("Enter the height of triangle");
        double height = sc.nextDouble();
        System.out.println("Enter the length of the rectangle");
        double a = sc.nextDouble();
        System.out.println("Enter the width of the rectangle");
        double b = sc.nextDouble();
        Circle c1 = new Circle(radius);
        Triangle t1 = new Triangle(length, height);
        Rectangle r1 = new Rectangle(a, b);
        c1.getShapeType();
        double circleArea = c1.calculateArea();
        t1.getShapeType();
        double triArea = t1.calculateArea();
        r1.getShapeType();
        double rectArea = r1.calculateArea();
        System.out.println("The area of the circle is " + circleArea);
        System.out.println("The area of the triangle is " + triArea);
        System.out.println("The area of the rectangle is " + rectArea);
        double[] Shapes = new double[3];
        Shapes[0] = circleArea;
        Shapes[1] = triArea;
        Shapes[2] = rectArea;
        System.out.println("Shapes in sorted order");
        Arrays.sort(Shapes);
        for(int i = 0 ; i < Shapes.length; i++) {
            System.out.println((Shapes[i]));
        }
    }
}
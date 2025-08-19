import org.w3c.dom.css.Rect;

import java.util.*;
class Shape {
    public void displayShapeType() {
        System.out.println("I am a shape");
    }
    public double displayShapeArea() {
        System.out.println("This is my shape area");
        return 0;
    }
}

class Circle extends  Shape{
    double radius;
    Circle(double r) {
        this.radius =r;
    }
    @Override
    public void displayShapeType() {
        System.out.println("This is a CIRCLE ");
    }
    @Override
    public double displayShapeArea() {
        System.out.println(" The area of the circle is :" + 3.14*radius*radius);
        return 3.14*radius*radius;
    }
}

class Rectangle extends Shape {
    double length ;
    double width ;
    Rectangle(double l , double w) {
        this.length = l;
        this.width=w;
    }
    @Override
    public void displayShapeType() {
        System.out.println("This is a RECTANGLE ");
    }
    @Override
    public double displayShapeArea(){
        System.out.println("The area of the rectangle is :" + length*width);
        return length*width;
    }
}

class Triangle extends  Shape {
    double length;
    double height ;
    Triangle(double l , double h) {
        this.length =l;
        this.height=h;
    }
    @Override
    public void displayShapeType() {
        System.out.println("This is a rectangle");
    }
    @Override
    public double displayShapeArea() {
        System.out.println("The area of the triangle is :" + 0.5*length*height);
        return 0.5*length*height;
    }
}

public  class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double radius = sc.nextDouble();
        System.out.println("Enter the length of the rectangle");
        double length = sc.nextDouble();
        System.out.println("Enter the breadth of the rectangle");
        double breadth = sc.nextDouble();
        System.out.println("Enter the length of the triangle");
        double lengthTri = sc.nextDouble();
        System.out.println("Enter the height of the triangle");
        double heightTri = sc.nextDouble();
        Circle c1 = new Circle(radius);
        double circleArea = c1.displayShapeArea();
        Rectangle r1 = new Rectangle(length , breadth);
        double rectangleArea = r1.displayShapeArea();
        Triangle t1 = new Triangle(lengthTri,heightTri);
        double triangleArea = t1.displayShapeArea();
        double[] temp = new double[3];
        temp[0] = circleArea;
        temp[1] = rectangleArea;
        temp[2] = triangleArea;
        Arrays.sort(temp);
        System.out.println("AFTER SORTING THE ARRAY:");
        for(int i = 0 ; i < temp.length ; i++) {
            System.out.println(temp[i]);
        }
    }
}
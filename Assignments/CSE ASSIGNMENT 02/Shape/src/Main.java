import java.util.*;

class Shape {
    public void displayShape() {
        System.out.println("This is a Shape");
    }
    public void computeArea() {
        System.out.println(" Area of the  Shape");
    }
}

class Circle extends Shape {
    double radius ;
    Circle(double radius) {
        super();
        this.radius = radius;
    }
    public void displayCircle() {
        super.displayShape();
        super.computeArea();
        System.out.println(" Area of the  Circle" + 3.14*radius*radius) ;
    }

}

class  Rectangle extends  Shape {
    double length ;
    double width ;
    Rectangle(double length, double width) {
        super();
        this.length =length;
        this.width = width;
    }
    public  void displayRectangle() {
        super.displayShape();;
        super.computeArea();
        System.out.println(" Area of the  Rectangle" + length*width);
    }
}

class Parent {
    public void displayParent() {
        System.out.println("This is a Parent");
    }
    public void getCar() {
        System.out.println("This is a old car.");
    }
}

class Child extends  Parent {
    Child(){
        super();
    }
    public  void diplayChild() {
        super.displayParent();
        System.out.println("This is a new CAR");
    }
}

public class Main   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double radius = sc.nextDouble();
        System.out.println( "Enter the length of the circle");
        double lentgh = sc.nextDouble();
        System.out.println( "Enter the width of the circle");
        double width = sc.nextDouble();
        Circle c1 = new Circle(radius);
        c1.displayCircle();
        Rectangle r1 = new Rectangle(lentgh,width);
        r1.displayRectangle();
        Child cc1 = new Child();
        cc1.diplayChild();

    }
}
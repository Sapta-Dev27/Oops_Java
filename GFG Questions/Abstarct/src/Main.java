import java.util.*;
abstract class Shape{
    abstract double calcArea();
    abstract double calcPerimeter();
    public void displayShape(){
        System.out.println("This is a Shape");
    }
}

class Rectangle extends Shape{
   double length;
   double width;
   Rectangle(){
       super();
       this.length=1;
       this.width=1;
   }
   Rectangle(double length,double width){
       super();
       this.length=length;
       this.width=width;
   }
   @Override
   public double calcArea(){
       return length*width;
   }
   @Override
   public double calcPerimeter(){
       return 2*length*width;
   }
   public void displayInfo(){
       super.displayShape();
       System.out.println("This is a Rectangle");
       System.out.println("Area of a Rectangle :" +calcArea());
       System.out.println("Perimeter of a Rectangle :" +calcPerimeter());
   }
}

class Circle extends Shape{
  double radius;
  Circle(){
      this.radius=1;
  }
  Circle(double radius){
      this.radius=radius;
  }
  @Override
  public double calcArea(){
      return 3.14*radius*radius;
  }
  @Override
  public double calcPerimeter(){
      return 2*3.14*radius;
  }
  public void displayInfo(){
      super.displayShape();
      System.out.println("This is a Circle");
      System.out.println("Area of a Circle :" +calcArea());
      System.out.println("Perimeter of a Circle :" +calcPerimeter());
  }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Enter the length:");
        double length = sc.nextDouble();
        System.out.println( "Enter the width:");
        double width = sc.nextDouble();
        System.out.println( "Enter the radius:");
        double radius = sc.nextDouble();
        Circle c1 = new Circle(radius);
        c1.displayInfo();
        Rectangle r1 = new Rectangle(length,width);
        r1.displayInfo();
    }
}
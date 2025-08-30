import java.util.*;

class Rectangle {
    double length;
    double width;
    Rectangle(double length , double width) {
        this.length = length;
        this.width=width;
    }
    Rectangle(){
        this.length=1;
        this.width=1;
    }
    public double getLength(){
        return this.length;
    }
    public double getWidth(){
        return this.width;
    }
    public void setLength(double length){
        if(length < 0){
            System.out.println("INVALID LENGTH");
        }
        else {
            this.length=length;
        }
    }
    public void setWidth(double width){
        if(width < 0){
            System.out.println("INVALID WIDTH");
        }
        else {
            this.width=width;
        }
    }

    public double calArea(){
        return length*width;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length :");
        double length = sc.nextDouble();
        System.out.println("Enter the width :");
        double width = sc.nextDouble();
        Rectangle r1 = new Rectangle(length,width);
        r1.getLength();
        r1.getLength();
        double area1 = r1.calArea();
        System.out.println("The area is :"+area1);
        System.out.println("Enter the length2 :");
        double length2 = sc.nextDouble();
        double width2 = sc.nextDouble();
        Rectangle r2 = new Rectangle();
        r2.setWidth(width2);
        r2.setLength(length2);
        double area2 =r2.calArea();
        System.out.println("The area is :"+area2);

    }
}
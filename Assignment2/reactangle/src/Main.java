import java.util.Scanner;
class Rectangle{
    double width ;
    double length;
    Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }
    Rectangle(double width , double length) {
        this.width= width ;
        this.length = length;
    }
    double calculateArea(){
        return width*length;
    }
    boolean checkIfSquare(){
        return width == length;
    }
    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length and the width of the rectangle");
        System.out.println("Enter the length");
        double length = sc.nextDouble();
        System.out.println("Enter the width");
        double width = sc.nextDouble();
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(width ,length);
        System.out.println("Area of the rectangle 1 is  :" + r1.calculateArea());
        System.out.println("Is it a square :" + r1.checkIfSquare());
        System.out.println("Area of the rectangle 2 is  :" + r2.calculateArea());
        System.out.println("Is it a square :" + r2.checkIfSquare());
    }
}
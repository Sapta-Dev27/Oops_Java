import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the radius of the circle :");
      double radius = sc.nextDouble();
      System.out.println("Given below are the choice :");
      System.out.println(" 1. Diameter of the circle ");
      System.out.println(" 2. Area of the circle");
      System.out.println(" 3. Circumference of the circle");
      System.out.println("Enter your choice :");
      int choice = sc.nextInt();
      switch (choice) {
          case 1 :
              double diameter = 2 * radius;
              System.out.println("The diameter of the circle is " + diameter);
              break;
          case 2 :
              double area = Math.PI * radius * radius ;
              System.out.println("The area of the circle is :" + area);
              break ;
          case 3 :
              double circumference = 2 * Math.PI * radius;
              System.out.println("The circumference of the circle is :" + circumference);
              break;
          default:
              System.out.println("Invalid Choice");
      }
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the 1st Number:");
            int num1 = sc.nextInt();
            System.out.println("Enter the 2nd Number:");
            int num2= sc.nextInt();
            int result = num1/num2;
            System.out.println(result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error in Division By Zero : " +e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Error in the type of the Input given : " +e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error Occured" +e.getMessage());
        }
        finally {
            System.out.println("The try and catch block had been executed successfully");
        }
    }
}
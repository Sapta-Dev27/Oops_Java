import mathutils.Calculator;
import java.util.*;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first number: ");
        int a = sc.nextInt();
        System.out.println("Please enter the second number: ");
        int b = sc.nextInt();

        Calculator calc = new Calculator();
        int sum = calc.add(a,b);
        System.out.println("The result is: " + sum);
        int diff = calc.sub(a,b);
        System.out.println("The result is: " + diff);
        int multiply = calc.multiply(a,b);
        System.out.println("The result is: " + multiply);
        double div = calc.divide(a,b);
        System.out.println("The result is: " + div);
    }
}

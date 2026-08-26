import java.util.*;
 class Calculator {
    public int calSum(int a , int b) {
        return a+b;
    }
    public int calDiff(int a , int b){
        return a-b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        Calculator c1 = new Calculator();
        int sum = c1.calSum(a,b);
        int diff = c1.calDiff(a,b);
        System.out.println("Sum is " + sum);
        System.out.println("Diff is " + diff);
    }
}
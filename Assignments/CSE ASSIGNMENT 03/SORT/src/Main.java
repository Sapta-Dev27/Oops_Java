import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of the array elements ");
        int n = sc.nextInt();
        double[] temp = new double[n];
        System.out.println("Enter the elements of the array ");
        for(int i = 0 ; i < n ; i++) {
            temp[i] = sc.nextDouble();
        }
        Arrays.sort(temp);
        for(int i = 0 ; i < n ;i++) {
            System.out.println(temp[i]);
        }
    }
}
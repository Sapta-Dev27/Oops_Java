import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of  nos: ");
        int n = sc.nextInt();
        int a , sum=0;
        System.out.println("Enter the numbers");
        for(int i = 1 ; i <= n ; i++) {
            System.out.println("Enter number " + (i));
            a = sc.nextInt();
            sum = sum + a;
        }
        System.out.println(sum);

    }
}
import java.util.Scanner;

interface findSquare {
    int findSqrt(int i);
}
class A implements findSquare {

   @Override
    public int findSqrt(int i){
       return i*i;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of square:");
        int n = sc.nextInt();
        A a1 = new A();
        int result  = a1.findSqrt(n);
        System.out.println(result);
    }
}

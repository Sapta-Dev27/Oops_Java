import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number :");
     int n = sc.nextInt();
     if(isPrime(n)) {
         System.out.println( n + " Is a Prime Number");
     }
     else {
         System.out.println( n + " Is not Prime Number");
     }
    }
    public static boolean isPrime(int n ) {
        if ( n == 1) {
            return false ;
        }
        else if( n==2) {
            return true ;
        }
        else {
            for ( int i = 3 ; i <= Math.sqrt(n) ; i+=2) {
                if ( n % i == 0) {
                    return false ;
                }
            }
            return true ;
        }
    }
}
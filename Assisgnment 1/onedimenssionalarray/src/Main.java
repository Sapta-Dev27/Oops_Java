import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the array elements");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the array elements : ");
        for ( int i = 0 ; i < n ; i++) {
            array[i]= sc.nextInt();
        }
        int count_even = 0 ;
        int count_odd = 0 ;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( array[i] %2 == 0) {
                count_even = count_even + 1 ;
            }
            else {
                count_odd = count_odd +1 ;
            }
        }
        System.out.println("The no of even elements in the array is : " +count_even);
        System.out.println("The no of the odd elemnets in the array is : " +count_odd);
    }
}
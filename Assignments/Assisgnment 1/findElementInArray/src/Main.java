import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the no of the array elements : ");
       int n = sc.nextInt() ;
       int[] arr1 = new  int[n];
       System.out.println("Enter the array elements : " );
       for ( int i = 0 ; i < n ; i++) {
           arr1[i] = sc.nextInt();
       }
       System.out.println("Enter the element to be searched : ");
       int element = sc.nextInt();
       int found = 0 ;
       for ( int i = 0 ; i < n ; i++ ) {
           if ( arr1[i] == element) {
               found = found + 1;
               System.out.println("Element is found at the index :" +i);
           }
       }
       if( found == 0 ) {
           System.out.println("Element is not found");
           System.out.println("-1");
       }

    }
}
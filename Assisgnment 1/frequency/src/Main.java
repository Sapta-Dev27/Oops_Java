import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the no of the array elements  : ");
       int n = sc.nextInt();
       int[] arr = new int[n] ;
       System.out.println("Enter the array elements:");
       for(int i = 0 ; i < n ; i++ ) {
           arr[i] = sc.nextInt();
       }
       int count = 0 ;
       System.out.println("Enter the element to be searched :");
       int value = sc.nextInt();
       for ( int i = 0 ; i < n ; i++ ) {
           if(arr[i] == value) {
               count++ ;
           }
       }
        if (count == 0) {
            System.out.println("No such element found");
        }
        else {
            System.out.println("The element given is present " + count + " times in the array");
        }
    }
}
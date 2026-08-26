import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the no of the array elements : " );
      int  n = sc.nextInt();
      int[] arr1 = new int[n];
      System.out.println("Enter the array elements :");
      for ( int i = 0 ; i < n ; i++ )  {
          arr1[i] = sc.nextInt();
      }
      int max = arr1[0];
      int min = arr1[0];
      for ( int i = 1 ; i < n ; i++) {
          if ( arr1[i] > max) {
              max = arr1[i];
          }
          if ( arr1[i] < min)  {
              min = arr1[i];
          }
      }
      System.out.println(" Max element in the array is : " + max);
      System.out.println(" Min element in the array is : " + min);
    }
}
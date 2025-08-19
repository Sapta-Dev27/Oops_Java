import java.util.*;

public class Main{

    public static int majorityElement(int[] arr , int k) {
          int n = arr.length;
          for(int i =0; i<n; i++){
              if(arr[i] == k) {
                  return  i;
              }
          }
          return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements in the array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements in the array :");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched in the array :");
        int k = sc.nextInt();
        int findElement = majorityElement(arr,k);
        if( findElement == -1){
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at index :" + findElement);
        }
    }
}
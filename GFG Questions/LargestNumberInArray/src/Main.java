import java.util.*;

class LargestNumberInArray{
    int n;
    int[] arr = new int[n];

    LargestNumberInArray(int n , int[] arr){
        this.n = n;
        this.arr=arr;
    }
    public int getLargestNumber(){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
           if( arr[i] > largest){
               largest = arr[i];
           }
        }
        return largest;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of array elements   :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements :");
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        LargestNumberInArray l = new LargestNumberInArray(n,arr);
        int number = l.getLargestNumber();
        System.out.println(number);

    }
}
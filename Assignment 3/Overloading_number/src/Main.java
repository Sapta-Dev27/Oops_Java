import java.util.*;
class Calculator {
    public  int Calculate(int a , int b){
        return a+b;
    }
    public double Calculate( double a  , double b) {
        return a*b ;
    }

    public String Calculate( String a ,String b) {
        return a+b;
    }

    public int Calculate(int arr[]){
        int sum = 0;
        int n = arr.length;
        for ( int i = 0 ; i < n ; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the intergers");
       int a ,b ;
       double c, d;
       String str1 , str2 ;
       System.out.println("Enter your choice :");
       int choice = sc.nextInt();
       Calculator calc = new Calculator();
        switch (choice) {
            case 1 :
                System.out.println("Enter the value of a " );
                a = sc.nextInt();
                System.out.println("Enter the value of b " );
                b = sc.nextInt();
                System.out.println("Sum is :" +calc.Calculate(a,b));
                break;
            case 2:
                System.out.println("Enter the value of c " );
                c = sc.nextDouble();
                System.out.println("Enter the value of d " );
                d = sc.nextDouble();
                System.out.println("Product is :" + calc.Calculate(c,d));
                break;
            case 3:
                System.out.println("Enter the value of str1 " );
                str1 = sc.next();
                System.out.println("Enter the value of str2 " );
                str2 = sc.next();
                System.out.println("Concatinacated string is :" + calc.Calculate(str1,str2));
                break;
            case 4:
                System.out.println("Enter the no of array elements :");
                int n = sc.nextInt();
                System.out.println("Enter the value of array elements :");
                int[] arr = new int[n];
                for ( int i = 0 ; i < n ; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Sum of the elements in array is :" + calc.Calculate(arr));
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
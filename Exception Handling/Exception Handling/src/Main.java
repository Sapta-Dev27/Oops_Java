import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st number");
        int num1 = sc.nextInt();
        System.out.println("Enter the 2nd number");
        int num2 = sc.nextInt();
        try {
            int result = (num1/num2);
            System.out.println(result);
        }
        catch (ArithmeticException e){
            if(e.getMessage().equals("/ by zero")){
                System.out.println("Division by zero Occoured");
            }
            else {
                System.out.println("Some error Occoured");
            }
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("Please enter an integer");
        }
        finally {
            System.out.println("This is the FINAL Block of CODE");
        }
    }
}

/* one thing to notice here : If any inputmismatch expection occurs here . Then the "FINALLY" block of code isn't implemeneted
because the error is getting catched in the nextInt() part. SO JVM doesnt even reach the try-catch-finally block of codes . SO
the finally block of code isn't  implemented
 */
/* inorder to  make this implemental what we can do is :
try {
        System.out.println("Enter the 1st number");
        int num1 = sc.nextInt();
        System.out.println("Enter the 2nd number");
        int num2 = sc.nextInt();
        int result = (num1/num2);
        System.out.println(result);
}
catch{
  ....... // code
}
finally {
 ...../// code
}

HERE IF ANY INPUTMISMATCH EXCEPTION TAKES PLACE , FINALLY BLOCK OF CODE WILL TO GET IMPLEMENTED

 */
import java.util.*;

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Please enter your age");
            int age = sc.nextInt();
            if(age < 18){
                throw new InvalidAgeException("You must be at least 18 years old to register.");
            }
            else{
                System.out.println("You are now valid to register.");
            }
        }
        catch (InvalidAgeException e){
            System.out.println("Invalid age :" +e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("You must enter a valid age :" +e.getMessage());
        }
        catch (Exception e){
            System.out.println("Something went wrong :" +e.getMessage());
        }
        finally{
            System.out.println("Goodbye!");
            sc.close();
        }
    }
}

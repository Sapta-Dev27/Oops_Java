import java.util.*;

class PersonName {
    private String firstName;
    private String lastName;

    PersonName(String firstName ,  String lastName){
        this.firstName = firstName;
        this.lastName=lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = sc.next();
        System.out.println("Enter Last Name:");
        String lastName = sc.next();
        PersonName p1 = new PersonName(firstName, lastName);
        String fullName = p1.getFullName();
        System.out.println("Full Name: "+fullName);
    }
}
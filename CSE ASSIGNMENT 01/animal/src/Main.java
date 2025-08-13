import java.util.*;

class Animal {
   public void makeSound() {
       System.out.println("Some Generic animal sound");
   }
   public boolean isNoisy(int decibel) {
       if(decibel > 70){
           return true ;
       }
       else {
           return false;
       }
   }
}

class Dog extends  Animal {
      int decibel;
      Dog(int decibel) {
          super();
          this.decibel = decibel ;
      }
      public void makeSound() {
          super.makeSound();
          System.out.println("Dog says : Bark!");
          boolean checkIfNoisy = super.isNoisy(decibel);
          if (checkIfNoisy) {
              System.out.println("The barking of the dog is noisy .");
          }
          else {
              System.out.println("The barking of the dog is not noisy .");
          }
      }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of decibels: ");
        int decibel = sc.nextInt();
        Dog d1 = new Dog(decibel);
        d1.makeSound();
    }
}
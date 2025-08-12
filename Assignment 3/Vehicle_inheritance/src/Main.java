import java.util.Scanner;

class Vehicle {
    String brand ;
    int year;
    Vehicle( String brand , int year) {
        this.brand = brand ;
        this.year = year;
    }
}

class Car extends Vehicle{
    String fuelType ;
    Car( String brand , int year , String fuelType) {
        super(brand , year);
        this.fuelType = fuelType;
    }
    public void displayCarInfo(){
        System.out.println("Brand of car is :" +brand);
        System.out.println("Year of car is :" +year);
        System.out.println("Fuel type of car is :" +fuelType);;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the brand :");
        String brand = sc.nextLine();
        System.out.println("Enter the year of car :");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the fuel type of car :");
        String fuelType = sc.nextLine();
        Car c1 = new Car( brand, year , fuelType);
        c1.displayCarInfo();;
    }
}
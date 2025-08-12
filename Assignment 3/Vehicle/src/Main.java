//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class Vehicle {
    String brand ;
    String model;
    int year;
    Vehicle(String brand , String model , int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public void display() {
        System.out.println("Brand of car is :" +this.brand);
        System.out.println("Brand of model is : "  +this.model);
        System.out.println("Year of car is " +this.year);
    }
}

class Car extends Vehicle{
    int SeatCapasity;
    String fuelType;
    Car(String brand , String model , int year , int seatCapasity, String fuelType){
        super(brand , model, year);
        this.SeatCapasity = seatCapasity;
        this.fuelType = fuelType;
    }
    public void CarDisplay() {
        display();
        System.out.println("Seat capasity is : " +this.SeatCapasity);
        System.out.println("Fuel type is :" +this.fuelType);
    }
}

class Bike extends  Vehicle{
    int engineCapacity;
    boolean isElectric;

    Bike(String brand , String model , int year , int engineCapacity, boolean isElectric){
        super(brand , model , year);
        this.engineCapacity = engineCapacity;
        this.isElectric=isElectric;
    }

    public void BikeDisplay(){
        display();
        System.out.println("Engine capacity is : " +this.engineCapacity);
        System.out.println("Is electric: " +this.isElectric);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  brand name :");
        String brand = sc.next();
        System.out.println("Enter the model name :");
        String model = sc.next();
        System.out.println("Enter the year :");
        int year = sc.nextInt();
        System.out.println("Enter the seat capasity :");
        int seatCapasity = sc.nextInt();
        System.out.println("Enter the fuel type :");
        String fuelType = sc.next();
        Car c1 = new Car(brand , model , year , seatCapasity, fuelType);
        System.out.println("CAR DETAILS :");
        c1.CarDisplay();
        System.out.println("Enter the fuelEngiene :");
        int fuelEngiene = sc.nextInt();
        System.out.println("Enter the bike EV/NORMAL :");
        boolean isElectric = sc.nextBoolean();
        Bike b1 = new Bike(brand,model,year , fuelEngiene, isElectric);
        b1.BikeDisplay();
    }
}
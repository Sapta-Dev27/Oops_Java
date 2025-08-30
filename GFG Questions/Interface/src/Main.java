import java.util.*;


/*Interfaces are built over abstract classes which provides us the features of MULTIPLE INTERFACES , static constants,
* static and default methods were introduced after Java 8 . Before we had abstract methods .*/

/*creating an interface Vehicle*/
interface Vehicle {

    /*creating abstract classes . They have no-body*/
    public abstract void displayVehicle();
    public abstract void displayVehicleCompany();

    /*In INTERFACES : we can have STATIC CONSTANTS
    * we can use static , final keywords ...but even if we don't use it that doesnt count cause all these are already in
    * built PACKAGES*/
    public static final int MAX_SPEED = 150;


    /*using STATIC METHODS*/
    /* is implemented for the interface and cannot be inherited /overridden by the implemented classes*/
    public static void  displayInfo(){
        System.out.println("This is the info about the vehicle");
    }

    /*using  DEFAULT METHODS*/
    /*can be inherited as well as overridden by the implemented classes*/
    public default void displayCapasity(){
        /*if it doesn't have a body.....it will work too*/
        System.out.println("This is the capasity about the vehicle");
    }
}


/*creating a class "CAR" that implements the Vehicle interface*/
class Car implements Vehicle{


    /*overriding the methods from the interface*/
    @Override
    public void displayVehicle(){
        System.out.println("This is a car");
        /*can use the static keyword in the classes too*/
        System.out.println("MAX SPEED IS :" + MAX_SPEED);

    }
    @Override
    public void displayVehicleCompany(){
        System.out.println("This is a CAR company : TATA");
    }

    @Override
    public  void displayCapasity(){
        System.out.println("4 people is the capasity");
    }

}

/*creating a class "BUS" that implements the Vehicle interface*/

class Bus implements Vehicle{

    @Override
    public void displayVehicle(){
        System.out.println("This is a bus");
        /*can use the static keyword in the classes too*/
        System.out.println("MAX SPEED IS :" + MAX_SPEED);
    }
    @Override
    public void displayVehicleCompany(){
        System.out.println("This is a bus company : VOLVO");
    }

    @Override
    public void displayCapasity(){
        System.out.println("400 kg weights is the capasity");
    }
}

/*creating  MusicPlayer , PhonePLayer and a CallDialer interfaces*/
        interface musicPlayer {
            public abstract  void playMusic();
            public abstract void stopMusic();
        }
        interface phonePlayer {
            public abstract void playPhone();
            public abstract void stopPhone();
        }
        interface callDialer {
            public abstract  void makeCall();
            public abstract void stopCall();
        }


        /*creating a class Phone that implements the 3 above interfaces , thus enabling MULTIPLE INHERITANCE*/
        class phone implements musicPlayer , phonePlayer , callDialer {

            @Override
            public void makeCall() {
                System.out.println("Make a call");
            }

            @Override
            public void stopCall() {
                System.out.println("Stop a call");
            }

            @Override
            public void playMusic() {
                System.out.println("Play a music");
            }

            @Override
            public void stopMusic() {
                System.out.println("Stop a music");
            }

            @Override
            public void playPhone() {
                System.out.println("Play a phone");
            }

            @Override
            public void stopPhone() {
                System.out.println("Stop a phone");
            }
        }

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*we can never create an object instance of interface*/
        Car c1 = new Car();
        Bus b1 = new Bus();
        c1.displayVehicle();
        c1.displayVehicleCompany();
        c1.displayCapasity();
        b1.displayVehicle();
        b1.displayVehicleCompany();
        b1.displayCapasity();
        System.out.println("MAX SPEED OF VEHICLE IS :" + Vehicle.MAX_SPEED);
        Vehicle.displayInfo();

        phone p1 = new phone();
        p1.makeCall();
        p1.stopCall();
        p1.playPhone();
        p1.stopPhone();
        p1.makeCall();
        p1.stopCall();
    }
}



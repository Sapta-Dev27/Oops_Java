import java.util.*;

interface ElectricBill {
    public abstract double calculateBill();
    public void displayConsumerType();
}

class Residence implements ElectricBill {
     String ConsumerId;
     String ConsumerName;
     int ConsumeQuantity;

     Residence(){
         this.ConsumerId="";
         this.ConsumerName="";
         this.ConsumeQuantity=0;
     }

     Residence(String id, String name , int quantity){
         this.ConsumerId=id;
         this.ConsumeQuantity=quantity;
         this.ConsumerName=name;
     }

     @Override
    public double calculateBill(){
         if(ConsumeQuantity <=100){
             return ConsumeQuantity*5;
         }
         else if( ConsumeQuantity > 100 && ConsumeQuantity <= 300){
             return (100*5)+ (ConsumeQuantity-100)*7;
         }
         else {
             return (100*5)+(200*7)+(ConsumeQuantity-300)*10;
         }
     }

     public void displayInfo() {
         System.out.println("Consumer Id: "+this.ConsumerId);
         System.out.println("Consumer Name: "+this.ConsumerName);
         System.out.println("Consume Quantity: "+this.ConsumeQuantity);
         System.out.println("Total Bill: " +calculateBill());
     }

    @Override
    public void displayConsumerType() {
        System.out.println("Residence Consumer Type");
    }
}

class Commercial implements ElectricBill {

    String ConsumerId;
    String ConsumerName;
    int ConsumedQuantity;

    Commercial(){
        this.ConsumerId="";
        this.ConsumerName="";
        this.ConsumedQuantity=0;
    }
    Commercial(String id, String name , int qt){
        this.ConsumerId=id;
        this.ConsumerName=name;
        this.ConsumedQuantity=qt;
    }

    @Override
    public double calculateBill(){
        return ConsumedQuantity*12;
    }
    @Override
    public void displayConsumerType(){
        System.out.println("Commercial Consumer Type");
    }
    public void displayInfo(){
        System.out.println("Consumer Id: "+this.ConsumerId);
        System.out.println("Consumer Name: "+this.ConsumerName);
        System.out.println("Consume Quantity: "+this.ConsumedQuantity);
        System.out.println("Total Bill: " +calculateBill());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter Consumer Id for residental: ");
        String id1 = sc.nextLine();
        System.out.println("Enter Consumer Name for residental: ");
        String name1 = sc.nextLine();
        System.out.println("Enter Consume Quantity for residental: ");
        int qt1 = sc.nextInt();
        sc.nextLine();
        Residence r1 = new Residence(id1,name1,qt1);
        r1.displayInfo();
        System.out.println("Enter Consumer Id for commercial: ");
        String id2 = sc.nextLine();
        System.out.println("Enter Consumer Name for commercial: ");
        String name2 = sc.nextLine();
        System.out.println("Enter Consume Quantity for commercial: ");
        int qt2 = sc.nextInt();
        Commercial c1 = new Commercial(id2,name2,qt2);
        c1.displayInfo();
    }
}
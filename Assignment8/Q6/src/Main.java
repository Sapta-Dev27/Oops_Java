import java.util.*;

class BankAcccount{
    double balance;
    BankAcccount(double balance){
        this.balance=balance;
    }
    public synchronized  double withdraw(double amount,String name){
        if(amount < balance){
            balance=balance-amount;
            return balance;
        }
        else {
            return -1;
        }
    }
}

class User extends  Thread{
    BankAcccount acc;
    String name;
    double withdraw;
   User(BankAcccount acc, String name , double withdraw){
        this.acc=acc;
        this.name=name;
        this.withdraw=withdraw;
    }
    @Override
    public void run(){
        for(int i=1 ; i<=10 ; i++){

            double result =  acc.withdraw(withdraw,name);
            try{
                sleep(200);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            if(result == -1){
                System.out.println("Sorry, you don't have enough money");
            }
            else{
                System.out.println(  " Net balance after withdraw from " + name + " is "  +result);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the balance of the account before any transactions : ");
        double balance = sc.nextDouble();
        BankAcccount acc = new BankAcccount(balance);
        System.out.println("Enter the name of the user 1: ");
        String name1= sc.next();
        System.out.println("Enter the name of the user 2: ");
        String name2= sc.next();
        System.out.println("Enter the amount to withdraw: ");
        double withdraw = sc.nextDouble();
        User u1 = new User(acc,name1,withdraw);
        User u2 = new User(acc,name2,withdraw);
        u1.start();
        u2.start();
    }
}
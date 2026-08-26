import java.util.Scanner;
class bankBalance{
    long accountNumber ;
    String accountName ;
    double balance ;

    bankBalance() {
        this.balance = 0.0 ;
    }
    bankBalance(long  accountNumber , String accountName , double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    void withDraw(double amount) {
        if( balance > 0 && amount < balance) {
            balance = balance - amount ;
            System.out.println("Net balance after withdrawl is :" + balance);
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
    void deposit(double amount) {
        if ( amount > 0) {
            balance = balance + amount;
            System.out.println("Net balance  after deposit is :" + balance);
        }
        else {
            System.out.println("Add more amount to deposit");
        }
    }
    void displayResults() {
        System.out.println("Account Number is :" + accountNumber);
        System.out.println("Account Name is :" + accountName);
        System.out.println("Account Balance is :" + balance);
    }
    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number :");
        long accountNumber = sc.nextLong();
        System.out.println("Enter the account name :");
        String accountName = sc.next();
        System.out.println("Enter the account balance :");
        double balance = sc.nextDouble();
        System.out.println("Enter the deposit amount: ");
        double deposit = sc.nextDouble();
        System.out.println("Enter the withdraw amount: ");
        double withdraw = sc.nextDouble();
        bankBalance acc1 = new bankBalance(accountNumber , accountName , balance);
        acc1.displayResults();
        acc1.deposit(deposit);
        acc1.withDraw(withdraw);
        acc1.displayResults();

    }
}
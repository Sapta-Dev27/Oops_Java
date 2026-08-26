import java.util.Scanner;
class Employee {
    long EmployeeId ;
    String Name ;
    String Gender ;
    String designation;
    double basicSalary;
    Employee( long EmployeeId , String Name , String Gender , String designation) {
        this.EmployeeId = EmployeeId;
        this.Name = Name;
        this.Gender = Gender;
        this.designation = designation;
        if( designation.equalsIgnoreCase("manager")){
            this.basicSalary = 50000.00;
        }
        else if( designation.equalsIgnoreCase("developer")){
            this.basicSalary = 35000.00;
        }
        else if(designation.equalsIgnoreCase("clerk")){
            this.basicSalary= 25000.00;
        }
        else {
            this.basicSalary= 0.0;
        }
    }
    Employee(long EmployeeId , String Name , String Gender , String designation , double basicSalary ){
        this.EmployeeId = EmployeeId;
        this.Name = Name;
        this.Gender = Gender;
        this.designation = designation ;
        this.basicSalary = basicSalary;
    }

    double netSalary() {
        double amountOfDA = (0.20 * basicSalary);
        double amountOfHRA = (0.15 * basicSalary);
        double  amountOfMedicalAllowance , tax , netSalary ;
        if ( designation.equalsIgnoreCase("manager")){
            amountOfMedicalAllowance = 5000.00;
        }
        else if( designation.equalsIgnoreCase("developer")){
            amountOfMedicalAllowance = 3000.00;
        }
        else if(designation.equalsIgnoreCase("clerk")){
            amountOfMedicalAllowance = 2000.00;
        }
        else {
            amountOfMedicalAllowance = 0.0;
        }
        double totalSalary = amountOfHRA + amountOfDA + amountOfMedicalAllowance + basicSalary;
        if( totalSalary > 60000) {
            tax = 0.1 * totalSalary;
            netSalary = totalSalary - tax;
        }
        else {
            tax = 0.0;
            netSalary = totalSalary - tax;
        }
        return netSalary;
    }
    void displayEmployeeDetails() {
        System.out.println("Employee Id: " + EmployeeId);
        System.out.println("Employee Name: " + Name);
        System.out.println("Employee Gender: " + Gender);
        System.out.println("Employee Designation: " + designation);
        System.out.println("Employee basicSalary: " + basicSalary);
        System.out.println("Net Salary of employee is : " + netSalary());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Employee Details : ");
        System.out.println("Enter Employee ID : ");
        long EmployeeId = sc.nextLong();
        System.out.println("Enter Employee Name : ");
        String EmployeeName = sc.next();
        System.out.println("Enter Employee Gender : ");
        String EmployeeGender = sc.next();
        System.out.println("Enter Employee designation : ");
        String EmployeeDesignation = sc.next();
        System.out.println("Enter Employee salary : ");
        double EmployeeSalary = sc.nextDouble();
        Employee emp1 = new Employee(EmployeeId , EmployeeName , EmployeeGender , EmployeeDesignation );
        emp1.displayEmployeeDetails();
        Employee emp2 = new Employee(EmployeeId ,EmployeeName , EmployeeGender , EmployeeDesignation , EmployeeSalary);
        emp2.displayEmployeeDetails();
    }
}
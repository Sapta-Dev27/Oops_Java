package university.administration;

public class SalaryManager{

    /*creating the dataMembers*/
    String role;
    double baseSalary;

    /*default constructor*/
    public SalaryManager(){
        this.role="";
        this.baseSalary=0.0;
    }
    /*parameterized constructor*/
    public  SalaryManager(String role , double baseSalary){
        this.role= role;
        this.baseSalary= baseSalary;
    }

    /*Member Methods :*/
    public double calculateTotalSalary(){
        double totalSalary ;
      if(role.equalsIgnoreCase("Teacher Assitant")){
         totalSalary= baseSalary + 2000;
      }
      else if(role.equalsIgnoreCase("Lecturer")){
          totalSalary= baseSalary + 5000;
      }
      else {
          totalSalary= baseSalary + 10000;
      }
      return totalSalary;
    }


}
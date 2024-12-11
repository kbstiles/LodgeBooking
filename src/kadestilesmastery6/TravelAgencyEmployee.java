/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class TravelAgencyEmployee extends Person{
    //variables
    String
        hireDate;        
            
    int
        employeeId;
    
    double
        salary;
    
    //default constructor
    public TravelAgencyEmployee(){
        hireDate = "03/16/2004";
        employeeId = 1;
        salary = 5.00; 
    }

    //main constructor
    public TravelAgencyEmployee(String loginName, String password, String hireDate, int employeeId, double salary, String name, String phoneNumber) {
        super(name, loginName, password, phoneNumber);
        this.hireDate = hireDate;
        this.employeeId = employeeId;
        this.salary = salary;
    }
    
    //display method
    @Override
    public String toString(){
        return 
                "\n" + super.toString() + 
                "\nHire Date: " + hireDate + 
                "\nID Number: " + employeeId + 
                "\nSalary: " + String.format("$%.2f",salary);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class Customer extends Person{
    //variables
    int 
        roomNumber,
            customerId;
    
    double
        totalSpending;
    
    //default constructor
    public Customer(){
        roomNumber = 1;
        totalSpending = 0;
    }
    
    //main constructor
    public Customer(int customerId, String loginName, String password, int roomNumber, double totalSpending, String name,  String phoneNumber){
        super(name, loginName, password, phoneNumber);
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.totalSpending = totalSpending; 
    }
        
    //display method 
    @Override
    public String toString(){
        return 
                "\n" + super.toString() + 
                "\nRoom Number: " + roomNumber + 
                "\nTotal Spending: " + String.format("$%.2f",totalSpending);
    }
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;
/**
 *
 * @author KadeS
 */
public class Person{
    //variables
    String 
        name,
        loginName,
        password,
        phoneNumber;
    
    //default constructor
    public Person(){
        name = "Dude";
        loginName = "default";
        password = "ASDFASDF";
        phoneNumber = "(123) 456-7890";
    }
    
    //main constructor
    public Person(String name, String loginName, String password, String phoneNumber){
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    //display method
    @Override
    public String toString(){
        return 
                "\nName: " + this.name + 
                "\nUsername: " + this.loginName + 
                "\nPassword: " + this.password +
                "\nPhone Number: " + this.phoneNumber;
    }
    
}

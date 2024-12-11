/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.sql.*;
import static kadestilesmastery6.LoginState.encrypt;
import static kadestilesmastery6.State.con;

/**
 *
 * @author KadeS
 */
public class RegisterPerson implements Runnable{
    
    String name,
    username,
    password;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public void run(){
        try {
            String insertQuery3 = "INSERT INTO stilesksu23.Person (Name, LoginName, Password, PhoneNumber) VALUES ('" + name + "', '" + username + "', '" + encrypt(password) + "', '123-123-1234')";
            PreparedStatement ps3 = con.prepareStatement(insertQuery3);
            ps3.executeUpdate();

            String insertQuery4 = "INSERT INTO stilesksu23.Customer (PersonID, RoomNumber, TotalSpending) VALUES ((SELECT PersonID FROM stilesksu23.Person ORDER BY PersonID DESC LIMIT 1), 0, 0)";
            PreparedStatement ps4 = con.prepareStatement(insertQuery4);
            ps4.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

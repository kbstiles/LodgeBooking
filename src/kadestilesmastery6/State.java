/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author KadeS
 */
abstract class State {

    //variables
    static State login,
            customerView,
            employeeView,
            managerView,
            current;
    static JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    static String mySQLURL = "jdbc:mysql://13.58.236.216:3306/stilesksu23",
            mySQLUsername = "stilesksu23",
            mySQLPassword = "Sk1961897$";
    static Connection con = null;
    
    void load() {
    }

    void save() {
    }
    
}

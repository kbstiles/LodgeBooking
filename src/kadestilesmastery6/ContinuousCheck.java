/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Color;
import java.sql.DriverManager;
import static kadestilesmastery6.LoginState.check;
import static kadestilesmastery6.LoginState.connectionStatusActual;
import static kadestilesmastery6.LoginState.x;
import static kadestilesmastery6.State.con;
import static kadestilesmastery6.State.mySQLPassword;
import static kadestilesmastery6.State.mySQLURL;
import static kadestilesmastery6.State.mySQLUsername;

/**
 *
 * @author KadeS
 */
public class ContinuousCheck implements Runnable{
     @Override
    public void run(){
        try {
            
            if (con.isClosed() || !con.isValid(0)){
                con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);               
            } else {
                connectionStatusActual.setText(check);
                connectionStatusActual.setForeground(Color.green);
            }       
        }
        catch(Exception ex)
        {
            connectionStatusActual.setText(x);
            connectionStatusActual.setForeground(Color.red);
        }  
    }
}

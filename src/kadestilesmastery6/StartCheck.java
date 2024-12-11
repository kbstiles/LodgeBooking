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
public class StartCheck implements Runnable{
    @Override
    public void run(){
            try {
                if (con.isValid(0)){
                    connectionStatusActual.setText(check);
                    connectionStatusActual.setForeground(Color.green);
                    
                    LoginState.startTimer.stop();
                }       
            }
            catch(Exception ex)
            {
                connectionStatusActual.setText(x);
                connectionStatusActual.setForeground(Color.red);
                try {
                    con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);

                    PersonData loadPeople = new PersonData();
                    Thread peopleDataThread = new Thread(loadPeople);
                    peopleDataThread.start();

                    LodgeData loadData = new LodgeData();
                    Thread lodgeThread = new Thread(loadData);
                    lodgeThread.start();
                }
                catch (Exception ex2){
                    connectionStatusActual.setText(x);
                    connectionStatusActual.setForeground(Color.red);
                } 
            }  
    }
}

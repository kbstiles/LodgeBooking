/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.sql.PreparedStatement;
import static kadestilesmastery6.State.con;

/**
 *
 * @author KadeS
 */
public class OrderConfirm implements Runnable{
    Order orderDetails;

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    @Override
    public void run(){
        try {
            String insertQuery2 = "INSERT INTO stilesksu23.Orders (PersonID, LodgeID, NightsStaying, TotalSpending, StartDate) VALUES (" + orderDetails.getCustomerID() + ", " + orderDetails.getLodgeID() + ", " + orderDetails.getNights() + ", " + orderDetails.getTotal() + ", '" + orderDetails.getStartDate() + "')";
            PreparedStatement ps2 = con.prepareStatement(insertQuery2);
            ps2.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

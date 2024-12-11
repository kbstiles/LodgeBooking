/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Desktop;
import java.io.File;
import java.sql.*;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
public class SearchOrders implements Runnable{
    FileReport report;   
    
    @Override
    public void run(){
        if (CustomerView.orderHistoryPanel.isVisible()){
            try {
                String query = "SELECT LodgeName, NightsStaying, TotalSpending, DATE_FORMAT(StartDate, '%m/%d/%y') FROM stilesksu23.Orders JOIN stilesksu23.Lodging ON Orders.LodgeID = Lodging.LodgeID WHERE PersonID = " + LoginState.cusID + " AND StartDate BETWEEN '" + CustomerView.dateSet3.toNumbers() + "' AND '" + CustomerView.dateSet4.toNumbers() + "'";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                report = new FileReport("Your Order History", rs, "c");
                File reportFile = new File(report.getFilePath());
                Desktop.getDesktop().browse(reportFile.toURI());
            } catch (Exception ex) {
                ex.printStackTrace();
            }    
        } else if (EmployeeView.orderHistoryPanel.isVisible()){
            try {
                String query = "SELECT PersonID, NightsStaying, TotalSpending, DATE_FORMAT(StartDate, '%m/%d/%y') FROM stilesksu23.Orders WHERE StartDate BETWEEN '" + EmployeeView.dateSet3.toNumbers() + "' AND '" + EmployeeView.dateSet4.toNumbers() + "'";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                report = new FileReport("Customer Order History", rs, "e");
                File reportFile = new File(report.getFilePath());
                Desktop.getDesktop().browse(reportFile.toURI());
            } catch (Exception ex) {
                ex.printStackTrace();
            }    
        }
    }
}

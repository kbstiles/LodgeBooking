/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.sql.*;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
public class OrderData implements Runnable{
    @Override
    public void run(){
        try {
            String s = "";
            CustomerView.ordersList.clear();
            String query = "SELECT PersonID, LodgeID, NightsStaying, TotalSpending, DATE_FORMAT(StartDate, '%m/%d/%y') FROM stilesksu23.Orders";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                String[] obd = {"", "", "", "", ""};
                for (int i = 1; i < md.getColumnCount() + 1; i++) {
                    s = rs.getString(i);
                    obd[i - 1] = s;
                }
                CustomerView.ordersList.add(new Order(Integer.parseInt(obd[0]), Integer.parseInt(obd[1]), Integer.parseInt(obd[2]), Double.parseDouble(obd[3]), obd[4]));
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}

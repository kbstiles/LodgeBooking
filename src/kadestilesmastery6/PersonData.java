/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.io.*;
import java.sql.*;
import java.util.logging.*;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
public class PersonData implements Runnable{
    @Override
    public void run(){
        try {
            String s = "";
            LoginState.customerList.clear();
            LoginState.employeeList.clear();
            String query = "SELECT Customer.PersonID, LoginName, Password, RoomNumber, TotalSpending, Name, PhoneNumber FROM stilesksu23.Person JOIN stilesksu23.Customer ON Person.PersonID = Customer.PersonID";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                String[] cbd = {"", "", "", "", "", "", ""};
                for (int i = 1; i < md.getColumnCount() + 1; i++) {
                    s = rs.getString(i);
                    cbd[i - 1] = s;
                }
                LoginState.customerList.add(new Customer(Integer.parseInt(cbd[0]), cbd[1], LoginState.decrypt(cbd[2]), Integer.parseInt(cbd[3]), Double.parseDouble(cbd[4]), cbd[5], cbd[6]));
            }

            query = "SELECT LoginName, Password, DATE_FORMAT(HireDate, '%m/%d/%y'), TravelAgencyEmployee.PersonID, Salary, Name, PhoneNumber FROM stilesksu23.Person JOIN stilesksu23.TravelAgencyEmployee ON Person.PersonID = TravelAgencyEmployee.PersonID";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            md = rs.getMetaData();
            while (rs.next()) {
                String[] edb = {"", "", "", "", "", "", ""};
                for (int i = 1; i < md.getColumnCount() + 1; i++) {
                    s = rs.getString(i);
                    edb[i - 1] = s;
                }
                LoginState.employeeList.add(new TravelAgencyEmployee(edb[0], LoginState.decrypt(edb[1]), edb[2], Integer.parseInt(edb[3]), Double.parseDouble(edb[4]), edb[5], edb[6]));
            }
        } catch (Exception x) {
            x.printStackTrace();
            try {
                //variables
                String s = "";
                BufferedReader brc = new BufferedReader(new FileReader("Customers.txt"));
                BufferedReader bre = new BufferedReader(new FileReader("Employees.txt"));
                LoginState.customerList.clear();
                LoginState.employeeList.clear();
                while ((s = brc.readLine()) != null) {
                    String[] c = s.split("~");
                    LoginState.customerList.add(new Customer(Integer.parseInt(c[0]), c[1], LoginState.decrypt(c[2]), Integer.parseInt(c[3]), Double.parseDouble(c[4]), c[5], c[6]));
                }
                while ((s = bre.readLine()) != null) {
                    String[] e = s.split("~");
                    LoginState.employeeList.add(new TravelAgencyEmployee(e[0], LoginState.decrypt(e[1]), e[2], Integer.parseInt(e[3]), Double.parseDouble(e[4]), e[5], e[6]));
                }

            } catch (Exception ex) {
                Logger.getLogger(LoginState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

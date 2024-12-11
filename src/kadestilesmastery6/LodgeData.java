/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.io.*;
import java.util.logging.*;
import java.sql.*;
import javax.swing.DefaultListModel;
import static kadestilesmastery6.State.*;


/**
 *
 * @author KadeS
 */
public class LodgeData implements Runnable{     
    @Override
    public void run(){
        if (LoginState.cusBool){
            CustomerView.cvLodges.setVisible(false);              
        } else {                
            EmployeeView.evLodges.setVisible(false);
        }  
        
        try {
            EmployeeView.lodgesList.clear();
            
            String s2 = "";
            String query2 = "SELECT ValetParking, FreeBreakfast, FireExit, Elevators, Pool, Lodging.LodgeID, LodgeName, LodgeAddress, LodgeDescription, LodgeParkingFee, LodgeMaxOccupants, LodgeVacancies, LodgePricePerNight FROM stilesksu23.Lodging JOIN stilesksu23.Hotel ON Lodging.LodgeID = Hotel.LodgeID";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ResultSet rs2 = ps2.executeQuery();
            ResultSetMetaData md2 = rs2.getMetaData();

            String s3 = "";
            String query3 = "SELECT BedNum, BedroomNum, BathroomNum, StoryNum, Lodging.LodgeID, LodgeName, LodgeAddress, LodgeDescription, LodgeParkingFee, LodgeMaxOccupants, LodgeVacancies, LodgePricePerNight FROM stilesksu23.Lodging JOIN stilesksu23.House ON Lodging.LodgeID = House.LodgeID";
            PreparedStatement ps3 = con.prepareStatement(query3);
            ResultSet rs3 = ps3.executeQuery();
            ResultSetMetaData md3 = rs3.getMetaData();

            while (rs2.next()) {
                String[] ldb = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
                for (int i = 1; i < md2.getColumnCount() + 1; i++) {
                    s2 = rs2.getString(i);
                    ldb[i - 1] = s2;
                }
                EmployeeView.lodgesList.add(new Hotel(Boolean.valueOf(ldb[0]), Boolean.valueOf(ldb[1]), Boolean.valueOf(ldb[2]), Boolean.valueOf(ldb[3]), Boolean.valueOf(ldb[4]), Integer.parseInt(ldb[5]), ldb[6], ldb[7], ldb[8], Double.parseDouble(ldb[9]), Integer.parseInt(ldb[10]), Integer.parseInt(ldb[11]), Double.parseDouble(ldb[12])));
            }

            while (rs3.next()) {
                String[] ldb = {"", "", "", "", "", "", "", "", "", "", "", ""};
                for (int i = 1; i < md3.getColumnCount() + 1; i++) {
                    s3 = rs3.getString(i);
                    ldb[i - 1] = s3;
                }
                EmployeeView.lodgesList.add(new House(Integer.parseInt(ldb[0]), Integer.parseInt(ldb[1]), Integer.parseInt(ldb[2]), Integer.parseInt(ldb[3]), Integer.parseInt(ldb[4]), ldb[5], ldb[6], ldb[7], Double.parseDouble(ldb[8]), Integer.parseInt(ldb[9]), Integer.parseInt(ldb[10]), Double.parseDouble(ldb[11])));
            }
        } catch (Exception x) {
            System.out.println(x);
            try {
                //variables
                String s = "";
                BufferedReader brl = new BufferedReader(new FileReader("Lodges.txt"));
                EmployeeView.lodgesList.clear();
                while ((s = brl.readLine()) != null) {
                    String[] e = s.split("~");
                    if (e.length == 12) {
                        EmployeeView.lodgesList.add(new Hotel(Boolean.valueOf(e[0]), Boolean.valueOf(e[1]), Boolean.valueOf(e[2]), Boolean.valueOf(e[3]), Boolean.valueOf(e[4]), Integer.parseInt(e[5]), e[6], e[7], e[8], Double.parseDouble(e[9]), Integer.parseInt(e[10]), Integer.parseInt(e[11]), Double.parseDouble(e[12])));
                    } else {
                        EmployeeView.lodgesList.add(new House(Integer.parseInt(e[0]), Integer.parseInt(e[1]), Integer.parseInt(e[2]), Integer.parseInt(e[3]), Integer.parseInt(e[4]), e[5], e[6], e[7], Double.parseDouble(e[8]), Integer.parseInt(e[9]), Integer.parseInt(e[10]), Double.parseDouble(e[11])));
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
//                Logger.getLogger(LoginState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        DefaultListModel listModel = new DefaultListModel();
        String[] names = new String[EmployeeView.lodgesList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = EmployeeView.lodgesList.get(i).name;
            listModel.addElement(names[i]);
            if (LoginState.cusBool){
                CustomerView.cvLodges.setModel(listModel);
            } 
            if (LoginState.employBool){
                EmployeeView.evLodges.setModel(listModel); 
            }
        }
        
        if (LoginState.cusBool){
            CustomerView.cvLodges.setVisible(true);
        } 
        if (LoginState.employBool){
            EmployeeView.evLodges.setVisible(true);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.sql.PreparedStatement;
import static kadestilesmastery6.EmployeeView.evLodges;
import static kadestilesmastery6.EmployeeView.lodgesList;
import static kadestilesmastery6.State.con;

/**
 *
 * @author KadeS
 */
public class LodgeRemoval implements Runnable{
    String selectedLodge;
    
    int lodgeIndex;

    public void setSelectedLodge(String selectedLodge) {
        this.selectedLodge = selectedLodge;
    }

    public void setLodgeIndex(int lodgeIndex) {
        this.lodgeIndex = lodgeIndex;
    }
    
    @Override
    public void run(){
        try {
            int id = 0;
            
            for (int i = 0; i < lodgesList.size(); i++){
                if (selectedLodge.equals(lodgesList.get(i).name)){
                    id = lodgesList.get(i).lodgeId;
                    break;
                }
            }
            if (lodgesList.get(lodgeIndex) instanceof Hotel) {
                String deleteQuery = "DELETE FROM stilesksu23.Hotel WHERE LodgeID = " + id;
                PreparedStatement ps = con.prepareStatement(deleteQuery);
                ps.executeUpdate();

                String deleteQuery2 = "DELETE FROM stilesksu23.Images WHERE LodgeID = " + id;
                PreparedStatement ps2 = con.prepareStatement(deleteQuery2);
                ps2.executeUpdate();
            } else {
                String deleteQuery = "DELETE FROM stilesksu23.House WHERE LodgeID = " + id;
                PreparedStatement ps = con.prepareStatement(deleteQuery);
                ps.executeUpdate();

                String deleteQuery2 = "DELETE FROM stilesksu23.Images WHERE LodgeID = " + id;
                PreparedStatement ps2 = con.prepareStatement(deleteQuery2);
                ps2.executeUpdate();
            }

            String deleteQuery3 = "DELETE FROM stilesksu23.Lodging WHERE LodgeID = " + id;
            PreparedStatement ps3 = con.prepareStatement(deleteQuery3);
            ps3.executeUpdate();
            
            lodgesList.remove(lodgeIndex);  
            evLodges.clearSelection();
        } catch (Exception x) {
            System.out.println(x);
        }
        
        evLodges.setEnabled(false);
    }
}

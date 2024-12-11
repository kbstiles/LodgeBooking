/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.sql.*;
import static kadestilesmastery6.EmployeeView.evLodges;
import static kadestilesmastery6.EmployeeView.imageChooserButton;
import static kadestilesmastery6.EmployeeView.imageProgressActual;
import static kadestilesmastery6.EmployeeView.imageProgressLabel;
import static kadestilesmastery6.EmployeeView.newLodgeButton;
import static kadestilesmastery6.EmployeeView.timer;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
public class LodgeEdit implements Runnable{
    String name,
            selectedLodge;
    
    int lodgeIndex,
            totalImageNum,
            imageNum = 0;
    
    double pricePerNight;
    
    boolean editNameBool,
            editPriceBool,
            addImageBool;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSelectedLodge(String selectedLodge) {
        this.selectedLodge = selectedLodge;
    }
    
    
    public void setLodgeIndex(int lodgeIndex) {
        this.lodgeIndex = lodgeIndex;
    }   

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setEditNameBool(boolean editNameBool) {
        this.editNameBool = editNameBool;
    }

    public void setEditPriceBool(boolean editPriceBool) {
        this.editPriceBool = editPriceBool;
    }

    public void setAddImageBool(boolean addImageBool) {
        this.addImageBool = addImageBool;
    }
    
    
    public void run(){
        if (editNameBool == true) {
            try {
                int id = 0;
                for (Lodging lod : EmployeeView.lodgesList){
                    if (selectedLodge.equals(lod.name)){
                        id = lod.lodgeId;
                        break;
                    }
                }
                String updateQuery = "UPDATE stilesksu23.Lodging SET LodgeName = '" + name + "' WHERE LodgeID = " + id;
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.executeUpdate(updateQuery);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            evLodges.setEnabled(false);
        }
        if (editPriceBool == true) {
            try {
                int id = 0;
                for (Lodging lod : EmployeeView.lodgesList){
                    if (selectedLodge.equals(lod.name)){
                        id = lod.lodgeId;
                        break;
                    }
                }
                String updateQuery = "UPDATE stilesksu23.Lodging SET LodgePricePerNight = '" + pricePerNight + "' WHERE LodgeID = " + id;
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.executeUpdate(updateQuery);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            evLodges.setEnabled(false);
        }
        if (addImageBool == true) {
            try {
                newLodgeButton.setEnabled(false);
                imageChooserButton.setEnabled(false);
                
                imageProgressLabel.setText("Progress:");
                
                File [] fa = EmployeeView.imageChooser.getSelectedFiles();
                totalImageNum = fa.length;
                int id = 0;
                for (int i = 0; i < fa.length; i++) {
                    byte[] b = Files.readAllBytes(fa[i].toPath());
                    for (Lodging lod : EmployeeView.lodgesList){
                        if (selectedLodge.equals(lod.name)){
                            id = lod.lodgeId;
                            break;
                        }
                    }
                    String insertQuery3 = "INSERT INTO stilesksu23.Images (LodgeID, FileName, ActualImage) VALUES(" + id + ",?,?)";
                    PreparedStatement ps3 = con.prepareStatement(insertQuery3);
                    ps3.setString(1, fa[i].getName());
                    ps3.setBinaryStream(2, new ByteArrayInputStream(b, 0, b.length));
                    ps3.executeUpdate();
                    imageNum++;
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            timer.stop();
            
            newLodgeButton.setEnabled(true);
            imageChooserButton.setEnabled(true);
            
            imageProgressActual.setText("Images Done");
            
            System.out.println("Images done");
        } 
    }
}

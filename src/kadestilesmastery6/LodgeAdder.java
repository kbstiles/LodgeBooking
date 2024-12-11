/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import static kadestilesmastery6.EmployeeView.*;

/**
 *
 * @author KadeS
 */
public class LodgeAdder implements Runnable{    
    
    
    String lodgeType,
            name,
            address,
            description;
    
    int typeId,
            maxOccupants,
            vacancies,
            numberOfBeds,
            numberOfBedrooms,
            numberOfBathrooms,
            numberOfStories,
            totalImageNum,
            imageNum = 0;
    
    double parkingFee,
            pricePerNight;
    
    boolean valetParking,
            freeBreakfast,
            fireExit,
            elevators,
            pool,
            hotelImageBool,
            houseImageBool;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setNumberOfStories(int numberOfStories) {
        this.numberOfStories = numberOfStories;
    }
    
    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
    
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setValetParking(boolean valetParking) {
        this.valetParking = valetParking;
    }

    public void setFreeBreakfast(boolean freeBreakfast) {
        this.freeBreakfast = freeBreakfast;
    }

    public void setFireExit(boolean fireExit) {
        this.fireExit = fireExit;
    }

    public void setElevators(boolean elevators) {
        this.elevators = elevators;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setHotelImageBool(boolean hotelImageBool) {
        this.hotelImageBool = hotelImageBool;
    }

    public void setHouseImageBool(boolean houseImageBool) {
        this.houseImageBool = houseImageBool;
    }    
    
    LodgeAdder(String lodgeType){
        this.lodgeType = lodgeType;
    }
    
    
    @Override
    public void run(){
        
        if (lodgeType.equals("Hotel")){
            try {
                String insertQuery = "INSERT INTO stilesksu23.Lodging (TypeID, LodgeName, LodgeAddress, LodgeDescription, LodgeMaxOccupants, LodgeVacancies, LodgePricePerNight, LodgeParkingFee) VALUES (" + typeId + ", '" + name + "', '" + address + "', '" + description + "', " + maxOccupants + ", " + vacancies + ", " + pricePerNight + ", " + parkingFee + ")";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.executeUpdate();

                String insertQuery2 = "INSERT INTO stilesksu23.Hotel (LodgeID, ValetParking, FreeBreakfast, FireExit, Elevators, Pool) VALUES ((SELECT MAX(LodgeID) FROM stilesksu23.Lodging), " + valetParking + ", " + freeBreakfast + ", " + fireExit + ", " + elevators + ", " + pool + ")";
                PreparedStatement ps2 = con.prepareStatement(insertQuery2);
                ps2.executeUpdate();

                if (hotelImageBool){
                    
                    newLodgeButton.setEnabled(false);
                    imageChooserButton.setEnabled(false);

                    imageProgressLabel.setText("Progress:");
                    
                    File[] fa = EmployeeView.hotelImageChooser.getSelectedFiles();
                    totalImageNum = fa.length;

                    for (int i = 0; i < fa.length; i++) {
                        byte[] b = Files.readAllBytes(fa[i].toPath());

                        String insertQuery3 = "INSERT INTO stilesksu23.Images (LodgeID, FileName, ActualImage) VALUES((SELECT MAX(LodgeID) FROM stilesksu23.Lodging),?,?)";
                        PreparedStatement ps3 = con.prepareStatement(insertQuery3);
                        ps3.setString(1, fa[i].getName());
                        ps3.setBinaryStream(2, new ByteArrayInputStream(b, 0, b.length));
                        ps3.executeUpdate();
                        
                        imageNum++;
                    }   
                                       
                    hotelTimer.stop();
            
                    newLodgeButton.setEnabled(true);
                    imageChooserButton.setEnabled(true);
                    
                    imageProgressActual.setText("Images Done");
                    
                    System.out.println("Images done");
                    
                    hotelImageBool = false;
                }           
            } catch (Exception ex) {
                System.out.println(ex);
            }         
        }
        else if (lodgeType.equals("House")){
            try {
                String insertQuery = "INSERT INTO stilesksu23.Lodging (TypeID, LodgeName, LodgeAddress, LodgeDescription, LodgeMaxOccupants, LodgeVacancies, LodgePricePerNight, LodgeParkingFee) VALUES (" + typeId + ", '" + name + "', '" + address + "', '" + description + "', " + maxOccupants + ", " + vacancies + ", " + pricePerNight + ", " + parkingFee + ")";
                PreparedStatement ps = con.prepareStatement(insertQuery);
                ps.executeUpdate();

                String insertQuery2 = "INSERT INTO stilesksu23.House (LodgeID, BedNum, BedroomNum, BathroomNum, StoryNum) VALUES ((SELECT MAX(LodgeID) FROM stilesksu23.Lodging), " + numberOfBeds + ", " + numberOfBedrooms + ", " + numberOfBathrooms + ", " + numberOfStories + ")";
                PreparedStatement ps2 = con.prepareStatement(insertQuery2);
                ps2.executeUpdate();
                
                if (houseImageBool){
                    
                    newLodgeButton.setVisible(false);
                    imageChooserButton.setVisible(false);

                    imageProgressLabel.setText("Progress:");
                    
                    File[] fa = EmployeeView.houseImageChooser.getSelectedFiles();
                    totalImageNum = fa.length;
                    
                    for (int i = 0; i < fa.length; i++) {
                        byte[] b = Files.readAllBytes(fa[i].toPath());

                        String insertQuery3 = "INSERT INTO stilesksu23.Images (LodgeID, FileName, ActualImage) VALUES((SELECT MAX(LodgeID) FROM stilesksu23.Lodging),?,?)";
                        PreparedStatement ps3 = con.prepareStatement(insertQuery3);
                        ps3.setString(1, fa[i].getName());
                        ps3.setBinaryStream(2, new ByteArrayInputStream(b, 0, b.length));
                        ps3.executeUpdate();
                    }
                    
                    houseTimer.stop();
            
                    newLodgeButton.setEnabled(true);
                    imageChooserButton.setEnabled(true);
                    
                    imageProgressActual.setText("Images Done");
                    
                    System.out.println("Images done");
                    
                    houseImageBool = false;
                }                
            } catch (Exception ex) {
                System.out.println(ex);
            }      
        }
        evLodges.setEnabled(false);
    }
    
}

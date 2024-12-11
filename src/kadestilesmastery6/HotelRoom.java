/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class HotelRoom {
    //variables
    private String 
        description;
    
    private int
        numberOfBeds,
        roomNumber;

    //getter and setter methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    //display method
    @Override
    public String toString(){
        return
                "\nDescription: " + description + 
                "\nNumber of Beds" + numberOfBeds + 
                "\nRoom Number" + roomNumber;
    }
}

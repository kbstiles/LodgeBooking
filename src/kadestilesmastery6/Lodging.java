/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;


import java.util.ArrayList;

/**
 *
 * @author KadeS
 */
public class Lodging {
    //variables
    public ArrayList<MyImageIcon> imagesList = new ArrayList<>();
    
    String 
        name,
        address,
        description;
    
    int
        lodgeId,
        maxOccupants,
        vacancies;
    
    double
        pricePerNight,
        parkingFee;
  
    //default constructor
    public Lodging(){
        lodgeId = 100;
        name = "Lodgey Wodgey";
        address = "123 Sesame Street";
        description = "it's a lodge";
        parkingFee = 5.00;
        maxOccupants = 123;
        vacancies = 14;
        pricePerNight = 78.00;
    }

    //main constructor
    public Lodging(int lodgeId, String name, String address, String description, double parkingFee, int maxOccupants, int vacancies, double pricePerNight) {
        this.lodgeId = lodgeId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.parkingFee = parkingFee;
        this.maxOccupants = maxOccupants;
        this.vacancies = vacancies;
        this.pricePerNight = pricePerNight;
    }
    
    //display method
    @Override
    public String toString(){
        return
                "\nLodgeID: " + lodgeId +
                "\nName: " + name +
                "\nAddress: " + address + 
                "\nDescription: " + description + 
                "\nParking Fee: " + parkingFee + 
                "\nMax Occupants: " + maxOccupants + 
                "\nVacancies: " + vacancies + 
                "\nPrice Per Night: " + String.format("$%.2f",pricePerNight);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class House extends Lodging{
    //variables         
    int
        numberOfBeds,
        numberOfBedrooms,
        numberOfBathrooms,
        numberOfStories;
    
    //default constructor
    public House() {
        numberOfBeds = 4;
        numberOfBedrooms = 3;
        numberOfBathrooms = 3;
        numberOfStories = 2;
    }
    
    //main constructor
    public House(
            int numberOfBeds, 
            int numberOfBedrooms, 
            int numberOfBathrooms, 
            int numberOfStories, 
            int lodgeId,
            String name, 
            String address, 
            String description, 
            double parkingFee, 
            int maxOccupants, 
            int vacancies, 
            double pricePerNight) {
        super(lodgeId, name, address, description, parkingFee, maxOccupants, vacancies, pricePerNight);
        this.numberOfBeds = numberOfBeds;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfStories = numberOfStories;
    }
    
    //display method
    @Override
    public String toString(){
        return
                "\n" + super.toString() +
                "\nNumber of Beds: " + numberOfBeds + 
                "\nNumber of Bedrooms: " + numberOfBedrooms + 
                "\nNumber of Bathrooms: " + numberOfBathrooms + 
                "\nNumber of Stories: " + numberOfStories;
    }
}

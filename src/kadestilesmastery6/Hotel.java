/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class Hotel extends Lodging{
    //variables
    Boolean
        valetParking,
        freeBreakfast,
        fireExit,
        elevators,
        pool;
    
    //default constructor
    public Hotel() {
        valetParking = true;
        freeBreakfast = false;
        fireExit = true;
        elevators = false;
        pool = false;
    }
    
    //main constructor

    public Hotel(
            Boolean valetParking,
            Boolean freeBreakfast, 
            Boolean fireExit, 
            Boolean elevators, 
            Boolean pool, 
            int lodgeId,
            String name, 
            String address, 
            String description, 
            double parkingFee, 
            int maxOccupants, 
            int vacancies, 
            double pricePerNight) {
        super(lodgeId, name, address, description, parkingFee, maxOccupants, vacancies, pricePerNight);
        this.valetParking = valetParking;
        this.freeBreakfast = freeBreakfast;
        this.fireExit = fireExit;
        this.elevators = elevators;
        this.pool = pool;
    }
    
    //display method
    @Override
    public String toString(){
        return
                "\n" + super.toString() + 
                "\nValet Parking: " + valetParking + 
                "\nFree Breakfast: " + freeBreakfast + 
                "\nFire Exit: " + fireExit + 
                "\nElevators: " + elevators + 
                "\nPool: " + pool;
    }
}

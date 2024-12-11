/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.util.*;

/**
 *
 * @author KadeS
 */
public class Order {
    //variables
    private String startDate;
    private int lodgeId,
                personId,
                nightsStaying;
    private double total;

    //sets startDate
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    //gets startDate
    public String getStartDate() {
        return startDate;
    }
    
    //sets personId
    public void setCustomerID(int personId) {
        this.personId = personId;
    }

    //gets personId
    public int getCustomerID() {
        return personId;
    }
    
    //sets lodgeId
    public void setLodgeID(int lodgeId) {
        this.lodgeId = lodgeId;
    }

    //gets lodgeId
    public int getLodgeID() {
        return lodgeId;
    }

    //sets nightsStaying
    public void setNights(int nightsStaying) {
        this.nightsStaying = nightsStaying;
    }

    //gets nightsStaying
    public int getNights() {
        return nightsStaying;
    }

    //sets total
    public void setTotal(double total) {
        this.total = total;
    }

    //gets price per night
    public double getTotal() {
        return total;
    }

    //default constructor
    public Order(){
    }
    
    //main constructor
    public Order(int personId, int lodgeId, int nightsStaying, double total, String placementDate){
        this.personId = personId;
        this.lodgeId = lodgeId;
        this.nightsStaying = nightsStaying;
        this.total = total;
        this.startDate = placementDate;
    }
}

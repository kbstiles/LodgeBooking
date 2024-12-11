/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
public class LodgingReview {
    //variables
    private String
        name,
        date,
        comments;
    
    private int
        rating;

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }    

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //display method
    @Override
    public String toString(){
        return
                "\nName: " + name +
                "\nDate: " + date +
                "\nComments: " + comments + 
                "\nRating: " + rating;
                
    }
}

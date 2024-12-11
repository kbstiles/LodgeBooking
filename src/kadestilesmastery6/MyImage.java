/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.sql.*;

/**
 *
 * @author KadeS
 */
public class MyImage {
    String imageFile;
    
    int lodgeId;
    
    Blob imageBlob;
    
    byte[] b;
    
    public MyImage(){
        
    }
    
    public MyImage(int lodgeId, String imageFile, Blob imageBlob, byte[] b){
        this.lodgeId = lodgeId;
        this.imageFile = imageFile;
        this.imageBlob = imageBlob;
        this.b = b;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author KadeS
 */
public class MyImageIcon extends ImageIcon{    
    Image myImage;
    
    public MyImageIcon(){
        super();
    }
    
    public MyImageIcon(byte[] b){
        super(b);
    }
    
    public MyImageIcon(Image img){
        super(img);
        
        this.myImage = img;
    }
}

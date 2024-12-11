/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Component;
import javax.swing.JScrollPane;

/**
 *
 * @author KadeS
 */
public class ScrollPane extends JScrollPane{
    ScrollPane(){
        
    }
    
    ScrollPane(int width, int height){
        setBounds(0,0,width,height);
    }
    
    ScrollPane(int vsbPolicy, int hsbPolicy, int width, int height){
        super(vsbPolicy,hsbPolicy);
        setBounds(0,0,width,height);
        
    }
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
}

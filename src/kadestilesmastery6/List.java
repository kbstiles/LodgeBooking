/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author KadeS
 */
public class List extends JList{
    List(){
        
    }
    
    List(ListModel model, int width, int height){
        super(model); 
        
        setBounds(0,0, width, height);
        
        setFont(new Font("Arial.ttf",Font.PLAIN, 12));
        
        setBackground(Color.decode("#f3f8f2"));
        setForeground(Color.decode("#3581b8"));
    }
    
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
}

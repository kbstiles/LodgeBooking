/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author KadeS
 */
public class Label extends JLabel{
    Label(){
        
    }
    
    Label(String text){
        super(text); 
        
        setFont(new Font("Arial.ttf",Font.PLAIN, 20));
        setBounds(0,0,text.length() * 20, 30);
    }
    
    Label(String text, Color color){
        super(text); 
        
        setFont(new Font("Arial.ttf",Font.PLAIN, 20));
        setForeground(Color.red);
        setBounds(0,0,text.length() * 20, 30);
    }
    
    Label(String text, int width){
        super(text); 
        
        setBounds(0,0,width, 35);
    }
    
    Label(String text, int width, int height){
        super(text); 
        
        setBounds(0,0,width, height);
    }
    
    Label(ImageIcon img, int width, int height){
        super(img);
        
        setBounds(0,0,width,height);
    }
    
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
}

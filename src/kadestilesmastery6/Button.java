/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;


/**
 *
 * @author KadeS
 */
public class Button extends JButton{
        Button(){
            setBackground(Color.decode("#3581b8"));
            setForeground(Color.decode("#fcb07e"));
            
        }
        
        Button(String text){
            super(text);
            
            setBounds(0,0,text.length() * 15, 30);
            setBackground(Color.decode("#3581b8"));
            setForeground(Color.decode("#fcb07e"));
            
            
        }
        
        Button(String text, int width){
            super(text);
            
            setBounds(0,0,width, 30);
            setBackground(Color.decode("#3581b8"));
            setForeground(Color.decode("#fcb07e"));
            
            
        }
        
        Button(String text, int width, int height, int font){
            super(text);
            
            setFont(new Font("Arial.ttf",Font.PLAIN, font));
            setBounds(0,0,width, height);
            setBackground(Color.decode("#3581b8"));
            setForeground(Color.decode("#fcb07e"));
        }
        
        void setPosition(int x, int y){
            setBounds(x, y, this.getWidth(), this.getHeight());
        }
}

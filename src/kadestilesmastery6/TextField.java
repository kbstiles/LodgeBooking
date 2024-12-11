/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author KadeS
 */
public class TextField extends JTextField{
    TextField(){
        
    }
    
    TextField(int col){
        super(col);
        
        setBounds(0,0,col, 30);
        
        setFont(new Font("Arial.ttf",Font.PLAIN, 20));
        
        setBackground(Color.decode("#3581b8"));
        setForeground(Color.decode("#fcb07e"));
    }
    
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
    
    void clearTextField(TextField text){
        text.setText("");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import javax.swing.JRadioButton;

/**
 *
 * @author KadeS
 */
public class RadioButton extends JRadioButton{
    RadioButton(){
        
    }
      
    RadioButton(String text){
        super(text);
    }
    
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
}

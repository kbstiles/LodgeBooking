/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import javax.swing.JTabbedPane;

/**
 *
 * @author KadeS
 */
public class TabbedPane extends JTabbedPane{
    TabbedPane(){
        
    }
    
    TabbedPane(int width, int height){
        setBounds(0, 0, width, height);
    }
    
    void setPosition(int x, int y){
        setBounds(x, y, this.getWidth(), this.getHeight());
    }
}

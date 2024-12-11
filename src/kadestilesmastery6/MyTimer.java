/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author KadeS
 */
public class MyTimer extends Timer{    
    MyTimer(int delay, ActionListener listener){
        super(delay, listener);
    }
    private long startTime = 0;

    public void start()
    {
        startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() 
    {
        return (System.currentTimeMillis() - startTime) / 1000; //returns in seconds
    }
}

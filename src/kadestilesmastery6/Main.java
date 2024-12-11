/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kadestilesmastery6;

import javax.swing.*;

/**
 *
 * @author KadeS Module 4 Mastery Assessment
 * color link https://coolors.co/ebe9e9-f3f8f2-3581b8-fcb07e-dee2d6 
 */
public class Main {

    public static void main(String[] args) {
        //new objects
        State.login = new LoginState();
        State.customerView = new CustomerView();
        State.employeeView = new EmployeeView();
//        State.managerView = new ManagerView();
        State.current = State.login;

        State.frame.setBounds(0, 0, 800, 600);
        State.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        State.frame.setLayout(null);
        State.frame.setVisible(true);
        
        
        
//        while (true) {
//            State.current.enter();
//            State.current.update();
//        }
    }
}

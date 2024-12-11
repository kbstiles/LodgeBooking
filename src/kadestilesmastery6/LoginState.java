/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.Timer;
import static kadestilesmastery6.CustomerView.cvLodges;
import static kadestilesmastery6.EmployeeView.evLodges;

/**
 *
 * @author KadeS
 */
class LoginState extends State {

    //variables
    public static ArrayList<Customer> customerList = new ArrayList<>();
    public static ArrayList<TravelAgencyEmployee> employeeList = new ArrayList<>();
    static int cusID;
    static Boolean guestBool,
            cusBool = false,
            employBool = false;
    String username,
            password,
            name;
    static String check = "✅",
            x = "❎";
    Boolean hasCapital = false,
            hasSpecial = false;    
    char ch;

    Button returnButton = new Button("Return", 75);

    Label usernameLabel = new Label("Username: ", 70);
    TextField usernameTf = new TextField(150);
    Label passwordLabel = new Label("Password: ", 70);
    PasswordField passwordPf = new PasswordField(150);
    Button loginButton = new Button("Login", 70);
    Button registerButton = new Button("Register", 85);
    Button guestButton = new Button("Continue As Guest", 145);
    Button exitButton = new Button("Exit", 60);

    JPanel registerPanel = new JPanel(null);
    Label registerCustomerNameLabel = new Label("Name: ", 50);
    TextField registerCustomerNameTf = new TextField(150);
    Label registerCustomerUsernameLabel = new Label("Username: ", 70);
    TextField registerCustomerUsernameTf = new TextField(150);
    Label registerCustomerPasswordLabel = new Label("Password: ", 70);
    PasswordField registerCustomerPasswordPf = new PasswordField(150);
    Label lenLabel = new Label("Length:", 75);
    Label lenMark = new Label(x);
    Label capLabel = new Label("Has Capital:", 75);
    Label capMark = new Label(x);
    Label specLabel = new Label("Has Special:", 75);
    Label specMark = new Label(x);
    Button registerCustomerSubmit = new Button("Submit", 75);
    
    static Timer startTimer;
    
    JPanel connectionStatusCover = new JPanel(null);
    static Label connectionStatusLabel = new Label("Connection Status:", 115);
    static Label connectionStatusActual = new Label(x, Color.red);
        
    public LoginState() {
        try{
            con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
            connectionStatusActual.setText(check);
            connectionStatusActual.setForeground(Color.green);
            
            PersonData loadPeople = new PersonData();
            Thread peopleDataThread = new Thread(loadPeople);
            peopleDataThread.start();
            
            peopleDataThread.join();
        }
        catch (Exception ex)
        {
            StartCheck checker = new StartCheck();
            Thread startCheckerThread = new Thread(checker);
            
            startTimer = new Timer(0, e -> startCheckerThread.run());
            startTimer.start();
        }
        
        ContinuousCheck checker = new ContinuousCheck();
        Thread continuousCheckerThread = new Thread(checker);
            
        Timer timer = new Timer(4000, e -> continuousCheckerThread.run());
                
        timer.start();
            
        frame.setTitle("Login");

        panel.setBounds(0, 0, 800, 600);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#dee2d6"));

        registerPanel.setBounds(0, 0, 800, 600);
        registerPanel.setBackground(Color.decode("#dee2d6"));
        
        connectionStatusLabel.setForeground(Color.LIGHT_GRAY);
        connectionStatusLabel.setPosition(10, 10);
        frame.add(connectionStatusLabel);
        
        connectionStatusActual.setPosition(125, 10);
        frame.add(connectionStatusActual);
        
        connectionStatusCover.setBounds(5, 11, 145, 30);
        connectionStatusCover.setBackground(Color.BLACK);
        frame.add(connectionStatusCover);
        
        usernameLabel.setPosition((panel.getWidth() / 2 - usernameLabel.getWidth() / 2) - 75, 100);
        panel.add(usernameLabel);

        usernameTf.setPosition(usernameLabel.getX() + usernameLabel.getWidth(), usernameLabel.getY());
        panel.add(usernameTf);

        passwordLabel.setPosition((panel.getWidth() / 2 - passwordLabel.getWidth() / 2) - 75, 175);
        panel.add(passwordLabel);

        passwordPf.setPosition(passwordLabel.getX() + passwordLabel.getWidth(), passwordLabel.getY());
        panel.add(passwordPf);

        loginButton.setPosition(panel.getWidth() / 2 - loginButton.getWidth() / 2, 250);
        loginButton.addActionListener((ActionEvent e) -> {
            username = usernameTf.getText();
            password = String.valueOf(passwordPf.getPassword());
            for (Customer customerUser : customerList) {
                if (username.equals(customerUser.loginName) && password.equals(customerUser.password)) {
                    cusBool = true;
                    LodgeData initialLoadData = new LodgeData();
                    Thread initialLodgeThread = new Thread(initialLoadData);
                    initialLodgeThread.start();
                    
                    cusID = customerUser.customerId;
                    panel.setVisible(false);
                    frame.remove(panel);
                    frame.add(customerView.panel);
                    customerView.panel.setVisible(true);                    
                    guestBool = false;
                    frame.setTitle("Customer");
                    
                }
            }

            for (TravelAgencyEmployee employeeUser : employeeList) {
                if (username.equals(employeeUser.loginName) && password.equals(employeeUser.password)) {
                    EmployeeView.evLodges.setVisible(false);
                    employBool = true;
                    LodgeData initialLoadData = new LodgeData();
                    Thread initialLodgeThread = new Thread(initialLoadData);
                    initialLodgeThread.start();
                    
                    ((EmployeeView) employeeView).logoutButton.setEnabled(true);
                    panel.setVisible(false);
                    frame.remove(panel);
                    frame.add(employeeView.panel);
                    employeeView.panel.setVisible(true);
                    
                    frame.setTitle("Employee");
                    
                }
            }

            usernameTf.clearTextField(usernameTf);
            passwordPf.clearPasswordField(passwordPf);
        });
        panel.add(loginButton);

        returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 525);
        returnButton.addActionListener((ActionEvent b) -> {
            lenMark.setText(x);
            hasCapital = false;
            capMark.setText(x);
            hasSpecial = false;
            specMark.setText(x);
            registerPanel.setVisible(false);
            registerCustomerNameTf.clearTextField(registerCustomerNameTf);
            registerCustomerUsernameTf.clearTextField(registerCustomerUsernameTf);
            registerCustomerPasswordPf.clearPasswordField(registerCustomerPasswordPf);
            frame.remove(registerPanel);
            frame.add(panel);
            panel.setVisible(true);
        });

        registerCustomerSubmit.setPosition(registerPanel.getWidth() / 2 - registerCustomerSubmit.getWidth() / 2, 400);
        registerCustomerSubmit.addActionListener((ActionEvent s) -> {
            name = registerCustomerNameTf.getText();
            username = registerCustomerUsernameTf.getText();
            customerList.add(new Customer(cusID, username, password, 0, 0, name, "123-123-1234"));
            RegisterPerson regi = new RegisterPerson();
            regi.setName(name);
            regi.setUsername(username);
            regi.setPassword(password);
            Thread registerThread = new Thread(regi);
            registerThread.start();
            save();
            lenMark.setText(x);
            hasCapital = false;
            capMark.setText(x);
            hasSpecial = false;
            specMark.setText(x);
            registerPanel.setVisible(false);
            registerCustomerNameTf.clearTextField(registerCustomerNameTf);
            registerCustomerUsernameTf.clearTextField(registerCustomerUsernameTf);
            registerCustomerPasswordPf.clearPasswordField(registerCustomerPasswordPf);
            frame.remove(registerPanel);
            frame.add(panel);
            panel.setVisible(true);
        });

        registerCustomerPasswordPf.addKeyListener((new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                password = String.valueOf(registerCustomerPasswordPf.getPassword());
                if (password.length() >= 10) {
                    lenMark.setText(check);
                } else {
                    lenMark.setText(x);
                }
                hasCapital = false;
                hasSpecial = false;
                registerCustomerSubmit.setEnabled(false);
                for (int i = 0; i < password.length(); i++) {
                    ch = password.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        hasCapital = true;
                    }
                    if (!Character.isDigit(password.charAt(i))
                            && !Character.isLetter(password.charAt(i))
                            && !Character.isWhitespace(password.charAt(i))) {
                        hasSpecial = true;
                    }
                }
                if (hasCapital == true) {
                    capMark.setText(check);
                } else {
                    capMark.setText(x);
                }
                if (hasSpecial == true) {
                    specMark.setText(check);
                } else {
                    specMark.setText(x);
                }
                if (hasCapital == true && hasSpecial == true && password.length() >= 10) {
                    registerCustomerSubmit.setEnabled(true);
                }
            }
        }));

        registerButton.setPosition(panel.getWidth() / 2 - registerButton.getWidth() / 2, 325);
        registerButton.addActionListener((ActionEvent e) -> {
            panel.setVisible(false);
            frame.remove(panel);
            frame.add(registerPanel);
            registerPanel.setVisible(true);           
            

            registerCustomerNameLabel.setPosition((registerPanel.getWidth() / 2 - registerCustomerNameLabel.getWidth() / 2) - 65, 100);
            registerPanel.add(registerCustomerNameLabel);

            registerCustomerNameTf.setPosition(registerCustomerNameLabel.getX() + registerCustomerNameLabel.getWidth(), registerCustomerNameLabel.getY());
            registerPanel.add(registerCustomerNameTf);

            registerCustomerUsernameLabel.setPosition((registerPanel.getWidth() / 2 - registerCustomerUsernameLabel.getWidth() / 2) - 75, 175);
            registerPanel.add(registerCustomerUsernameLabel);

            registerCustomerUsernameTf.setPosition(registerCustomerUsernameLabel.getX() + registerCustomerUsernameLabel.getWidth(), registerCustomerUsernameLabel.getY());
            registerPanel.add(registerCustomerUsernameTf);

            registerCustomerPasswordLabel.setPosition((registerPanel.getWidth() / 2 - registerCustomerPasswordLabel.getWidth() / 2) - 75, 250);
            registerPanel.add(registerCustomerPasswordLabel);

            registerCustomerPasswordPf.setPosition(registerCustomerPasswordLabel.getX() + registerCustomerPasswordLabel.getWidth(), registerCustomerPasswordLabel.getY());
            registerPanel.add(registerCustomerPasswordPf);

            lenLabel.setPosition(registerCustomerPasswordPf.getX(), 285);
            registerPanel.add(lenLabel);

            lenMark.setPosition(lenLabel.getX() + lenLabel.getWidth(), lenLabel.getY());
            registerPanel.add(lenMark);

            capLabel.setPosition(registerCustomerPasswordPf.getX(), 320);
            registerPanel.add(capLabel);

            capMark.setPosition(capLabel.getX() + capLabel.getWidth(), capLabel.getY());
            registerPanel.add(capMark);

            specLabel.setPosition(registerCustomerPasswordPf.getX(), 355);
            registerPanel.add(specLabel);

            specMark.setPosition(specLabel.getX() + specLabel.getWidth(), specLabel.getY());
            registerPanel.add(specMark);

            registerPanel.add(registerCustomerSubmit);

            registerCustomerSubmit.setEnabled(false);

            returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 475);
            registerPanel.add(returnButton);
        });
        panel.add(registerButton);

        guestButton.setPosition(panel.getWidth() / 2 - guestButton.getWidth() / 2, 400);
        guestButton.addActionListener((ActionEvent e) -> {
            LodgeData initialLoadData = new LodgeData();
            Thread initialLodgeThread = new Thread(initialLoadData);
            initialLodgeThread.start();
            
            panel.setVisible(false);
            frame.remove(panel);
            frame.add(customerView.panel);
            customerView.panel.setVisible(true);
            guestBool = true;
            cusBool = true;
            
        });
        panel.add(guestButton);

        exitButton.setPosition(panel.getWidth() / 2 - exitButton.getWidth() / 2, 475);
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        panel.add(exitButton);

        frame.add(panel);
    }

    @Override
    void save() {
        try {
            BufferedWriter bwc = new BufferedWriter(new FileWriter("Customers.txt"));
            for (Customer customerUser : customerList) {
                
                bwc.append(customerUser.customerId + "~" + customerUser.loginName + "~" + encrypt(customerUser.password) + "~" + customerUser.roomNumber + "~" + customerUser.totalSpending + "~" + customerUser.name + "~" + customerUser.phoneNumber + "\n");
            }

            bwc.close();
        } catch (Exception ex2) {
            System.out.println(ex2);
        }
    }

    static String encrypt(String s) {
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            ss += (char) (s.charAt(i) + 1);
        }
        return ss;
    }

    static String decrypt(String s) {
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            ss += (char) (s.charAt(i) - 1);
        }
        return ss;
    }    
}

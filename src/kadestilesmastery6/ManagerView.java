package kadestilesmastery6;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package kadestilesmastery5;
//
///**
// *
// * @author KadeS
// */
//import com.mysql.cj.jdbc.result.ResultSetMetaData;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
//import java.sql.*;
//import javax.swing.*;
//import static kadestilesmastery5.LoginState.decrypt;
//import static kadestilesmastery5.LoginState.employeeList;
//import static kadestilesmastery5.State.mySQLPassword;
//import static kadestilesmastery5.State.mySQLURL;
//import static kadestilesmastery5.State.mySQLUsername;
//
///**
// *
// * @author KadeS
// */
//class ManagerView extends State {
//
//    //variables
//    String name,
//            username,
//            password;
//    double salary;
//    static List mvEmployees = new List(new DefaultListModel(), 100, 400);
//    TabbedPane tp = new TabbedPane(800, 600);
//    int index;
//    Boolean editNameBool = false,
//            editUsernameBool = false,
//            editPasswordBool = false;
//
//    Label stateLabel = new Label("Manager View", 100);
//    Button returnButton = new Button("Return", 75);
//
//    Button b1 = new Button("Add Employee", 120);
//
//    JPanel employeeInfoPanel = new JPanel(null);
//    Label infoUsernameLabel = new Label("Username: ", 150, 25);
//    Label infoUsernameActual = new Label("", 150, 25);
//    Label infoPasswordLabel = new Label("Password: ", 150, 25);
//    Label infoPasswordActual = new Label("", 150, 25);
//    Label infoHireDateLabel = new Label("Hire Date: ", 150, 25);
//    Label infoHireDateActual = new Label("", 150, 25);
//    Label infoIsManagerLabel = new Label("Is Manager: ", 150, 25);
//    Label infoIsManagerActual = new Label("", 150, 25);
//    Label infoEmployeeIDLabel = new Label("ID Number: ", 150, 25);
//    Label infoEmployeeIDActual = new Label("", 150, 25);
//    Label infoSalaryLabel = new Label("Salary: ", 150, 25);
//    Label infoSalaryActual = new Label("", 150, 25);
//    Label infoNameLabel = new Label("Name: ", 150, 25);
//    Label infoNameActual = new Label("", 150, 25);
//    Label infoPhoneLabel = new Label("Phone Number: ", 150, 25);
//    Label infoPhoneActual = new Label("", 150, 25);
//    Button b2 = new Button("Edit Employee", 120);
//    Button b3 = new Button("Remove Employee", 150);
//    Button b4 = new Button("Make Employee A Manager", 195);
//
//    JPanel registerPanel = new JPanel(null);
//    Label registerEmployeeNameLabel = new Label("Name: ", 45, 25);
//    TextField registerEmployeeNameTf = new TextField(150);
//    Label registerEmployeeUsernameLabel = new Label("Username: ", 70);
//    TextField registerEmployeeUsernameTf = new TextField(150);
//    Label registerEmployeePasswordLabel = new Label("Password: ", 70);
//    PasswordField registerEmployeePasswordPf = new PasswordField(150);
//    Label registerEmployeeSalaryLabel = new Label("Salary: ", 70);
//    TextField registerEmployeeSalaryTf = new TextField(150);
//    Button registerEmployeeSubmit = new Button("Submit", 75);
//
//    JPanel editEmployeePanel = new JPanel(null);
//    Label editNameLabel = new Label("Name: ", 45, 25);
//    TextField editNameTf = new TextField(150);
//    Label editUsernameLabel = new Label("Username: ", 150, 25);
//    TextField editUsernameTf = new TextField(50);
//    Label editPasswordLabel = new Label("Password: ", 150, 25);
//    PasswordField editPasswordPf = new PasswordField(50);
//    Button finishEdit = new Button("Finish", 75);
//
//    Button b6 = new Button("Logout", 75);
//
//    public ManagerView() {
//        load();
//
//        tp.setPosition(0, 0);
//
//        panel.setBounds(0, 0, 800, 600);
//        panel.setLayout(null);
//        panel.setBackground(Color.decode("#dee2d6"));
//
//        registerPanel.setBounds(0, 0, 800, 600);
//        registerPanel.setBackground(Color.decode("#dee2d6"));
//
//        employeeInfoPanel.setBounds(0, 0, 800, 600);
//        employeeInfoPanel.setBackground(Color.decode("#dee2d6"));
//
//        editEmployeePanel.setBounds(0, 0, 800, 600);
//        editEmployeePanel.setBackground(Color.decode("#dee2d6"));
//
//        stateLabel.setPosition(10, 0);
//        panel.add(stateLabel);
//
//        mvEmployees.setPosition(panel.getWidth() / 6 - mvEmployees.getWidth() / 6, 100);
//        mvEmployees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        mvEmployees.setLayoutOrientation(List.VERTICAL);
//
//        panel.add(mvEmployees);
//
//        ScrollPane managerSp = new ScrollPane(mvEmployees.getWidth(), mvEmployees.getHeight());
//        managerSp.setViewportView(mvEmployees);
//        managerSp.setPosition(mvEmployees.getX(), mvEmployees.getY());
//
//        panel.add(managerSp);
//
//        registerEmployeeSubmit.setPosition(registerPanel.getWidth() / 2 - registerEmployeeSubmit.getWidth() / 2, 475);
//        registerEmployeeSubmit.addActionListener((ActionEvent s) -> {
//            name = registerEmployeeNameTf.getText();
//            username = registerEmployeeUsernameTf.getText();
//            password = String.valueOf(registerEmployeePasswordPf.getPassword());
//            salary = Double.parseDouble(registerEmployeeSalaryTf.getText());
//            LoginState.employeeList.add(new TravelAgencyEmployee(username, password, java.time.LocalDate.now().toString(), false, 0, salary, name, "123-123-1234"));
//            try {
//                con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//                String insertQuery3 = "INSERT INTO stilesksu23.Person (Name, LoginName, Password, PhoneNumber) VALUES ('" + name + "', '" + username + "', '" + LoginState.encrypt(password) + "', '123-123-1234')";
//                PreparedStatement ps3 = con.prepareStatement(insertQuery3);
//                ps3.executeUpdate(insertQuery3);
//
//                String insertQuery4 = "INSERT INTO stilesksu23.TravelAgencyEmployee (PersonID, HireDate, IsManager, Salary) VALUES ((SELECT PersonID FROM stilesksu23.Person ORDER BY PersonID DESC LIMIT 1), " + java.time.LocalDate.now().toString() + ", " + false + ", " + salary + ")";
//                PreparedStatement ps4 = con.prepareStatement(insertQuery4);
//                ps4.executeUpdate(insertQuery4);
//                con.close();
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            save();
//            updateList();
//            registerPanel.setVisible(false);
//            registerEmployeeNameTf.clearTextField(registerEmployeeNameTf);
//            registerEmployeeUsernameTf.clearTextField(registerEmployeeUsernameTf);
//            registerEmployeePasswordPf.clearPasswordField(registerEmployeePasswordPf);
//            registerEmployeeSalaryTf.clearTextField(registerEmployeeSalaryTf);
//            frame.remove(registerPanel);
//            frame.add(tp);
//            tp.setVisible(true);
//        });
//
//        registerEmployeePasswordPf.addKeyListener((new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                username = registerEmployeeUsernameTf.getText();
//                password = String.valueOf(registerEmployeePasswordPf.getPassword());
//                if (!username.equals("") && !username.equals(" ")) {
//                    if (!password.equals("") && !password.equals(" ")) {
//                        registerEmployeeSubmit.setVisible(true);
//                    }
//                }
//            }
//        }));
//
//        b1.setPosition(panel.getWidth() / 2 - b1.getWidth() / 2, 100);
//        b1.addActionListener((ActionEvent b) -> {
//            tp.setVisible(false);
//            frame.remove(tp);
//            frame.add(registerPanel);
//            registerPanel.setVisible(true);
//
//            registerEmployeeNameLabel.setPosition(registerPanel.getWidth() / 6 - registerEmployeeNameLabel.getWidth() / 6, 175);
//            registerPanel.add(registerEmployeeNameLabel);
//
//            registerEmployeeNameTf.setPosition(registerEmployeeNameLabel.getX() + 50, registerEmployeeNameLabel.getY());
//            registerPanel.add(registerEmployeeNameTf);
//
//            registerEmployeeUsernameLabel.setPosition(registerEmployeeNameLabel.getX(), 250);
//            registerPanel.add(registerEmployeeUsernameLabel);
//
//            registerEmployeeUsernameTf.setPosition(registerEmployeeUsernameLabel.getX() + 75, registerEmployeeUsernameLabel.getY());
//            registerPanel.add(registerEmployeeUsernameTf);
//
//            registerEmployeePasswordLabel.setPosition(registerEmployeeNameLabel.getX(), 325);
//            registerPanel.add(registerEmployeePasswordLabel);
//
//            registerEmployeePasswordPf.setPosition(registerEmployeePasswordLabel.getX() + 75, registerEmployeePasswordLabel.getY());
//            registerPanel.add(registerEmployeePasswordPf);
//
//            registerEmployeeSalaryLabel.setPosition(registerEmployeeNameLabel.getX(), 400);
//            registerPanel.add(registerEmployeeSalaryLabel);
//
//            registerEmployeeSalaryTf.setPosition(registerEmployeeSalaryLabel.getX() + 75, registerEmployeeSalaryLabel.getY());
//            registerPanel.add(registerEmployeeSalaryTf);
//
//            registerPanel.add(registerEmployeeSubmit);
//
//            registerEmployeeSubmit.setVisible(false);
//        });
//        panel.add(b1);
//
//        editNameTf.addKeyListener((new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                name = editNameTf.getText();
//                if (!name.equals("") && !name.equals(" ")) {
//                    editNameBool = true;
//                }
//            }
//        }));
//
//        editUsernameTf.addKeyListener((new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                username = editUsernameTf.getText();
//                if (!username.equals("") && !username.equals(" ")) {
//                    editUsernameBool = true;
//                }
//            }
//        }));
//
//        editPasswordPf.addKeyListener((new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                password = String.valueOf(editPasswordPf.getPassword());
//                if (!username.equals("") && !username.equals(" ")) {
//                    editPasswordBool = true;
//                }
//            }
//        }));
//
//        finishEdit.setPosition(editEmployeePanel.getWidth() / 2 - finishEdit.getWidth() / 2, 400);
//        finishEdit.addActionListener((ActionEvent a) -> {
//            if (editNameBool == true) {
//                LoginState.employeeList.get(index).name = name;
//                try {
//                    con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//                    String updateQuery = "UPDATE stilesksu23.Person SET Name = '" + name + "' WHERE PersonID = " + (index + 1) + ")";
//                    PreparedStatement ps = con.prepareStatement(updateQuery);
//                    ps.executeUpdate(updateQuery);
//                    con.close();
//                } catch (Exception ex) {
//                    System.out.println(ex);
//                }
//            }
//            if (editUsernameBool == true) {
//                LoginState.employeeList.get(index).loginName = username;
//                try {
//                    con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//                    String updateQuery = "UPDATE stilesksu23.Person SET LoginName = '" + username + "' WHERE PersonID = " + (index + 1) + ")";
//                    PreparedStatement ps = con.prepareStatement(updateQuery);
//                    ps.executeUpdate(updateQuery);
//                    con.close();
//                } catch (Exception ex) {
//                    System.out.println(ex);
//                }
//            }
//            if (editPasswordBool == true) {
//                LoginState.employeeList.get(index).password = password;
//                try {
//                    con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//                    String updateQuery = "UPDATE stilesksu23.Person SET Password = '" + password + "' WHERE PersonID = " + (index + 1) + ")";
//                    PreparedStatement ps = con.prepareStatement(updateQuery);
//                    ps.executeUpdate(updateQuery);
//                    con.close();
//                } catch (Exception ex) {
//                    System.out.println(ex);
//                }
//            }
//            save();
//            updateList();
//            editEmployeePanel.setVisible(false);
//            editNameTf.clearTextField(editNameTf);
//            editNameBool = false;
//            editUsernameTf.clearTextField(editUsernameTf);
//            editUsernameBool = false;
//            editPasswordPf.clearPasswordField(editPasswordPf);
//            editPasswordBool = false;
//            mvEmployees.clearSelection();
//            frame.remove(editEmployeePanel);
//            frame.add(tp);
//            tp.setVisible(true);
//        });
//
//        b2.setPosition(panel.getWidth() / 2 - b2.getWidth() / 2, 125);
//        b2.addActionListener((ActionEvent b) -> {
//            employeeInfoPanel.setVisible(false);
//            frame.remove(employeeInfoPanel);
//            frame.add(editEmployeePanel);
//            editEmployeePanel.setVisible(true);
//
//            editNameLabel.setPosition(editEmployeePanel.getWidth() / 6 - editNameLabel.getWidth() / 6, 50);
//            editEmployeePanel.add(editNameLabel);
//
//            editNameTf.setPosition((editNameLabel.getX() + 50), editNameLabel.getY());
//            editEmployeePanel.add(editNameTf);
//
//            editUsernameLabel.setPosition(editNameLabel.getX(), 100);
//            editEmployeePanel.add(editUsernameLabel);
//
//            editUsernameTf.setPosition((editUsernameLabel.getX() + 100), editUsernameLabel.getY());
//            editEmployeePanel.add(editUsernameTf);
//
//            editPasswordLabel.setPosition(editNameLabel.getX(), 150);
//            editEmployeePanel.add(editPasswordLabel);
//
//            editPasswordPf.setPosition((editPasswordLabel.getX() + 100), editPasswordLabel.getY());
//            editEmployeePanel.add(editPasswordPf);
//
//            editEmployeePanel.add(finishEdit);
//        });
//
//        b3.setPosition(panel.getWidth() / 2 - b3.getWidth() / 2, 200);
//        b3.addActionListener((ActionEvent b) -> {
//            LoginState.employeeList.remove(index);
//            try {
//                con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//                String deleteQuery = "DELETE FROM stilesksu23.TravelAgencyEmployee WHERE PersonID = " + (index + 1) + ")";
//                PreparedStatement ps = con.prepareStatement(deleteQuery);
//                ps.executeUpdate(deleteQuery);
//
//                deleteQuery = "DELETE FROM stilesksu23.Person WHERE PersonID = " + (index + 1) + ")";
//                ps = con.prepareStatement(deleteQuery);
//                ps.executeUpdate(deleteQuery);
//
//                con.close();
//            } catch (Exception x) {
//                x.printStackTrace();
//            }
//            mvEmployees.clearSelection();
//            save();
//            updateList();
//            employeeInfoPanel.setVisible(false);
//            frame.remove(employeeInfoPanel);
//            frame.add(tp);
//            tp.setVisible(true);
//        });
//
//        b4.setPosition(panel.getWidth() / 2 - b4.getWidth() / 2, 275);
//        b4.addActionListener((ActionEvent b) -> {
//            LoginState.employeeList.get(index).isManager = true;
//            mvEmployees.clearSelection();
//            save();
//            updateList();
//            employeeInfoPanel.setVisible(false);
//            frame.remove(employeeInfoPanel);
//            frame.add(tp);
//            tp.setVisible(true);
//        });
//
//        returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 400);
//        returnButton.addActionListener((ActionEvent b) -> {
//            mvEmployees.clearSelection();
//            employeeInfoPanel.setVisible(false);
//            frame.remove(employeeInfoPanel);
//            editEmployeePanel.setVisible(false);
//            frame.remove(editEmployeePanel);
//            frame.add(tp);
//            tp.setVisible(true);
//        });
//
//        mvEmployees.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                index = mvEmployees.getSelectedIndex();
//                tp.setVisible(false);
//                frame.remove(tp);
//                frame.add(employeeInfoPanel);
//                employeeInfoPanel.setVisible(true);
//
//                infoUsernameLabel.setPosition(employeeInfoPanel.getWidth() / 6 - infoUsernameLabel.getWidth() / 6, 150);
//                employeeInfoPanel.add(infoUsernameLabel);
//
//                infoUsernameActual.setText(LoginState.employeeList.get(index).loginName);
//                infoUsernameActual.setPosition((infoUsernameLabel.getX() + 75), infoUsernameLabel.getY());
//                employeeInfoPanel.add(infoUsernameActual);
//
//                infoPasswordLabel.setPosition(infoUsernameLabel.getX(), 175);
//                employeeInfoPanel.add(infoPasswordLabel);
//
//                infoPasswordActual.setText(LoginState.employeeList.get(index).password);
//                infoPasswordActual.setPosition((infoPasswordLabel.getX() + 70), infoPasswordLabel.getY());
//                employeeInfoPanel.add(infoPasswordActual);
//
//                infoHireDateLabel.setPosition(infoUsernameLabel.getX(), 200);
//                employeeInfoPanel.add(infoHireDateLabel);
//
//                infoHireDateActual.setText(LoginState.employeeList.get(index).hireDate);
//                infoHireDateActual.setPosition((infoHireDateLabel.getX() + 70), infoHireDateLabel.getY());
//                employeeInfoPanel.add(infoHireDateActual);
//
//                infoIsManagerLabel.setPosition(infoUsernameLabel.getX(), 225);
//                employeeInfoPanel.add(infoIsManagerLabel);
//
//                infoIsManagerActual.setText(String.valueOf(LoginState.employeeList.get(index).isManager));
//                infoIsManagerActual.setPosition((infoIsManagerLabel.getX() + 80), infoIsManagerLabel.getY());
//                employeeInfoPanel.add(infoIsManagerActual);
//
//                infoEmployeeIDLabel.setPosition(infoUsernameLabel.getX(), 250);
//                employeeInfoPanel.add(infoEmployeeIDLabel);
//
//                infoEmployeeIDActual.setText(String.valueOf(LoginState.employeeList.get(index).employeeId));
//                infoEmployeeIDActual.setPosition((infoEmployeeIDLabel.getX() + 80), infoEmployeeIDLabel.getY());
//                employeeInfoPanel.add(infoEmployeeIDActual);
//
//                infoSalaryLabel.setPosition(infoUsernameLabel.getX(), 275);
//                employeeInfoPanel.add(infoSalaryLabel);
//
//                infoSalaryActual.setText(String.format("$%.2f", LoginState.employeeList.get(index).salary));
//                infoSalaryActual.setPosition((infoSalaryLabel.getX() + 50), infoSalaryLabel.getY());
//                employeeInfoPanel.add(infoSalaryActual);
//
//                infoNameLabel.setPosition(infoUsernameLabel.getX(), 300);
//                employeeInfoPanel.add(infoNameLabel);
//
//                infoNameActual.setText(LoginState.employeeList.get(index).name);
//                infoNameActual.setPosition((infoNameLabel.getX() + 50), infoNameLabel.getY());
//                employeeInfoPanel.add(infoNameActual);
//
//                infoPhoneLabel.setPosition(infoUsernameLabel.getX(), 325);
//                employeeInfoPanel.add(infoPhoneLabel);
//
//                infoPhoneActual.setText(LoginState.employeeList.get(index).phoneNumber);
//                infoPhoneActual.setPosition((infoPhoneLabel.getX() + 100), infoPhoneLabel.getY());
//                employeeInfoPanel.add(infoPhoneActual);
//
//                employeeInfoPanel.add(b2);
//
//                employeeInfoPanel.add(b3);
//
//                employeeInfoPanel.add(b4);
//
//                employeeInfoPanel.add(returnButton);
//            }
//        });
//
//        b6.setPosition(panel.getWidth() / 2 - b6.getWidth() / 2, 400);
//        b6.addActionListener((ActionEvent e) -> {
//            tp.setVisible(false);
//            mvEmployees.clearSelection();
//            frame.remove(tp);
//            frame.add(login.panel);
//            login.panel.setVisible(true);
//        });
//        panel.add(b6);
//
//        tp.addTab("Manager", panel);
//
//    }
//
//    void enter() {
//        System.out.println("Manager State");
//    }
//
//    void update() {
//
//    }
//
//    @Override
//    void save() {
//        try {
//            BufferedWriter bwe = new BufferedWriter(new FileWriter("Employees.txt"));
//            for (TravelAgencyEmployee employeeUser : LoginState.employeeList) {
//                bwe.append(employeeUser.loginName + "~" + LoginState.encrypt(employeeUser.password) + "~" + employeeUser.hireDate + "~" + employeeUser.isManager + "~" + employeeUser.employeeId + "~" + employeeUser.salary + "~" + employeeUser.name + "~" + employeeUser.phoneNumber + "\n");
//            }
//            bwe.close();
//        } catch (Exception ex2) {
//            System.out.println(ex2);
//        }
//    }
//
//    @Override
//    void load() {
//        try {
//            String s = "";
//            employeeList.clear();
//            con = DriverManager.getConnection(mySQLURL, mySQLUsername, mySQLPassword);
//            String query = "SELECT LoginName, Password, DATE_FORMAT(HireDate, '%m/%d/%y'), IsManager, TravelAgencyEmployee.PersonID, Salary, Name, PhoneNumber FROM stilesksu23.Person JOIN stilesksu23.TravelAgencyEmployee ON Person.PersonID = TravelAgencyEmployee.PersonID";
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            java.sql.ResultSetMetaData md = rs.getMetaData();
//            while (rs.next()) {
//                String[] edb = {"", "", "", "", "", "", "", ""};
//                for (int i = 1; i < md.getColumnCount() + 1; i++) {
//                    s = rs.getString(i);
//                    edb[i - 1] = s;
//                }
//
//                if (edb[3].equals("0")) {
//                    edb[3] = "false";
//                } else {
//                    edb[3] = "true";
//                }
//
//                employeeList.add(new TravelAgencyEmployee(edb[0], decrypt(edb[1]), edb[2], Boolean.valueOf(edb[3]), Integer.parseInt(edb[4]), Double.parseDouble(edb[5]), edb[6], edb[7]));
//            }
//            con.close();
//        } catch (Exception x) {
//            x.printStackTrace();
//            try {
//                //variables
//                String s = "";
//                BufferedReader bre = new BufferedReader(new FileReader("Employees.txt"));
//                employeeList.clear();
//                while ((s = bre.readLine()) != null) {
//                    String[] e = s.split("~");
//                    employeeList.add(new TravelAgencyEmployee(e[0], decrypt(e[1]), e[2], Boolean.valueOf(e[3]), Integer.parseInt(e[4]), Double.parseDouble(e[5]), e[6], e[7]));
//                }
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//        }
//    }
//
//    void updateList() {
//        DefaultListModel listModel = new DefaultListModel();
//        String[] names = new String[LoginState.employeeList.size()];
//        for (int i = 0; i < names.length; i++) {
//            names[i] = LoginState.employeeList.get(i).name;
//            listModel.addElement(names[i]);
//        }
//        mvEmployees.setModel(listModel);
//    }
//}

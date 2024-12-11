/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import java.time.LocalDate;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
class CustomerView extends State {
    //variables
    Order order = null,
            orderDetails = null;
    int nightsStaying,
            numberOfBeds,
            numberOfBedrooms,
            numberOfBathrooms,
            numberOfStories,
            maxOccupants,
            vacancies,
            lodgeIndex,            
            imageIndex;    
    double pricePerNight,
            parkingFee,
            total;
    Boolean valetParking,
            freeBreakfast,
            fireExit,
            elevators,
            pool,
            orderBool = false;
    String name,
            address,
            description,
            selectedLodge = "";
    MyImageIcon 
            enlargedImageIcon;
    
    static MyImageIcon imageIcon,
            updatedImageIcon;
    
    public static ArrayList<Order> ordersList = new ArrayList<>();
    static List cvLodges = new List(new DefaultListModel(), 100, 300);
    static List cvImages = new List(new DefaultListModel(), 205, 400);


    JPanel lodgePanel = new JPanel(null);
    Label nameLabel = new Label("Name: ", 45);
    Label nameActual = new Label("", 150);
    Label addressLabel = new Label("Address: ", 60);
    Label addressActual = new Label("", 150);
    Label priceLabel = new Label("Price Per Night: ", 150);
    Label priceActual = new Label("", 150);
    Label descLabel = new Label("Description: ", 125);
    Label descActual = new Label("", 150);
    Label maxLabel = new Label("Max Occupants: ", 150);
    Label maxActual = new Label("", 150);
    Label vacLabel = new Label("Vacancies: ", 70);
    Label vacActual = new Label("", 150);
    Label parkFeeLabel = new Label("Parking Fee: ", 80);
    Label parkFeeActual = new Label("", 150);
    Label bedroomNumLabel = new Label("Number of Bedrooms: ", 135);
    Label bedroomNumActual = new Label("", 150);
    Label bedNumLabel = new Label("Number of Beds: ", 105);
    Label bedNumActual = new Label("", 150);
    Label bathroomNumLabel = new Label("Number of Bathrooms: ", 140);
    Label bathroomNumActual = new Label("", 150);
    Label storyNumLabel = new Label("Number of Stories: ", 115);
    Label storyNumActual = new Label("", 150);
    Label valetLabel = new Label("Valet Parking: ", 85);
    Label valetActual = new Label("", 150);
    Label freeBreakfastLabel = new Label("Free Breakfast: ", 100);
    Label freeBreakfastActual = new Label("", 150);
    Label fireExitLabel = new Label("Fire Exit: ", 60);
    Label fireExitActual = new Label("", 150);
    Label elevatorLabel = new Label("Elevators: ", 65);
    Label elevatorActual = new Label("", 150);
    Label poolLabel = new Label("Pool: ", 40);
    Label poolActual = new Label("", 150);
    static Button placeOrderButton = new Button("Place Order", 105);
    Button viewOrderButton = new Button("View Order", 100);
    Button orderHistoryButton = new Button("Order History", 115);
    
    Dates dateSet1 = new Dates();
    Dates dateSet2 = new Dates();

    JPanel viewOrderPanel = new JPanel(null);
    Label nightsStayingLabel = new Label("Nights Staying: ", 95);
    Label nightsStayingActual = new Label("", 150);
    Label totalLabel = new Label("Total: ", 55);
    Label totalActual = new Label("", 150);
    Button confirmButton = new Button("Confirm Order", 125);
    Button cancelButton = new Button("Cancel Order", 115);
    
    JFrame imageFrame = new JFrame();
    JPanel imagePanel = new JPanel(null);
    JLabel enlargedImageLabel = new JLabel();
    
    Button nextImageButton = new Button(">", 100, 100, 50);
    Button previousImageButton = new Button("<", 100, 100, 50);
    
    static JPanel orderHistoryPanel = new JPanel(null);
    static Dates dateSet3 = new Dates();
    static Dates dateSet4 = new Dates();
    Button searchButton = new Button("Search", 105);
    
    Button refreshButton = new Button("Refresh", 80);
    Button logoutButton = new Button("Logout", 75);
    
    static Button returnButton = new Button("Return", 105);
    
    public CustomerView() { 
        
        panel.setBounds(0, 0, 800, 600);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#dee2d6"));

        lodgePanel.setBounds(0, 0, 800, 600);
        lodgePanel.setBackground(Color.decode("#dee2d6"));

        viewOrderPanel.setBounds(0, 0, 800, 600);
        viewOrderPanel.setBackground(Color.decode("#dee2d6"));
        
        orderHistoryPanel.setBounds(0, 0, 800, 600);
        orderHistoryPanel.setBackground(Color.decode("#dee2d6"));
        
        cvLodges.setPosition(panel.getWidth() / 6 - cvLodges.getWidth() / 6, 125);
        cvLodges.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cvLodges.setLayoutOrientation(List.VERTICAL);
        cvLodges.setVisible(false);

        panel.add(cvLodges);

        ScrollPane customerLodgeSp = new ScrollPane(cvLodges.getWidth(), cvLodges.getHeight());
        customerLodgeSp.setViewportView(cvLodges);
        customerLodgeSp.setPosition(cvLodges.getX(), cvLodges.getY());

        panel.add(customerLodgeSp);
        
        cvImages.setPosition(550, 50);
        cvImages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cvImages.setLayoutOrientation(List.VERTICAL);
        
        ScrollPane customerImageSp = new ScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, cvImages.getWidth(), cvImages.getHeight());
        customerImageSp.setViewportView(cvImages);
        customerImageSp.setPosition(cvImages.getX(), cvImages.getY());
        
        imageFrame.setBounds(0,0,1281, 667);
        imageFrame.setLayout(null);
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        imagePanel.setBounds(0,0,1281, 667);
        imagePanel.setLayout(null);
        imagePanel.setBackground(Color.decode("#dee2d6"));    
                    
        refreshButton.setPosition(650, 10);
        refreshButton.addActionListener((ActionEvent a) -> {
            LodgeData loadData = new LodgeData();
            Thread lodgeThread = new Thread(loadData);
            lodgeThread.start();
        });
        panel.add(refreshButton);
        
        placeOrderButton.setPosition(lodgePanel.getWidth() / 2 - placeOrderButton.getWidth() / 2, 300);
        placeOrderButton.addActionListener((ActionEvent c) -> {
            orderBool = true;
            order = new Order();
            order.setCustomerID(LoginState.cusID);
            order.setLodgeID(lodgeIndex + 1);
            long diff = ChronoUnit.DAYS.between(dateSet1.toNumbers(), dateSet2.toNumbers());
            nightsStaying = (int) diff;
            order.setNights(nightsStaying);
            total = (nightsStaying * pricePerNight) + parkingFee;
            order.setTotal(total);
            LocalDate start = dateSet1.toNumbers();
            order.setStartDate(start.toString());
            orderDetails = new Order(order.getCustomerID(), order.getLodgeID(), order.getNights(), order.getTotal(), order.getStartDate());

            lodgePanel.setVisible(false);
            lodgePanel.remove(bedroomNumLabel);
            lodgePanel.remove(bedroomNumActual);
            lodgePanel.remove(bedNumLabel);
            lodgePanel.remove(bedNumActual);
            lodgePanel.remove(bathroomNumLabel);
            lodgePanel.remove(bathroomNumActual);
            lodgePanel.remove(storyNumLabel);
            lodgePanel.remove(storyNumActual);
            lodgePanel.remove(valetLabel);
            lodgePanel.remove(valetActual);
            lodgePanel.remove(freeBreakfastLabel);
            lodgePanel.remove(freeBreakfastActual);
            lodgePanel.remove(fireExitLabel);
            lodgePanel.remove(fireExitActual);
            lodgePanel.remove(elevatorLabel);
            lodgePanel.remove(elevatorActual);
            lodgePanel.remove(poolLabel);
            lodgePanel.remove(poolActual); 
            lodgePanel.remove(customerImageSp);
            cvLodges.setEnabled(false);
            cvLodges.clearSelection();
            cvImages.setEnabled(false);
            cvImages.clearSelection();
            frame.remove(lodgePanel);
            frame.add(panel);
            viewOrderButton.setVisible(true);
            viewOrderButton.setEnabled(true);
            logoutButton.setEnabled(false);
            panel.setVisible(true);
        });

        cvLodges.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try { 
                    lodgeIndex = cvLodges.getSelectedIndex();
                    selectedLodge = (String)cvLodges.getSelectedValue();

                    ImageData loadImages = new ImageData();
                    loadImages.setLodgeIndex(lodgeIndex);
                    loadImages.setSelectedLodge(selectedLodge);
                    Thread imageThread = new Thread(loadImages);
                    imageThread.start();               
                    
                    panel.setVisible(false);
                    frame.remove(panel);
                    frame.add(lodgePanel);
                    lodgePanel.setVisible(true);

                    name = EmployeeView.lodgesList.get(lodgeIndex).name;
                    address = EmployeeView.lodgesList.get(lodgeIndex).address;
                    pricePerNight = EmployeeView.lodgesList.get(lodgeIndex).pricePerNight;
                    description = EmployeeView.lodgesList.get(lodgeIndex).description;
                    maxOccupants = EmployeeView.lodgesList.get(lodgeIndex).maxOccupants;
                    vacancies = EmployeeView.lodgesList.get(lodgeIndex).vacancies;
                    parkingFee = EmployeeView.lodgesList.get(lodgeIndex).parkingFee;

                    nameLabel.setPosition(50, 50);
                    lodgePanel.add(nameLabel);

                    nameActual.setText(name);
                    nameActual.setPosition((nameLabel.getX() + 50), nameLabel.getY());
                    lodgePanel.add(nameActual);

                    addressLabel.setPosition(nameLabel.getX(), 75);
                    lodgePanel.add(addressLabel);

                    addressActual.setText(address);
                    addressActual.setPosition((addressLabel.getX() + 60), addressLabel.getY());
                    lodgePanel.add(addressActual);

                    priceLabel.setPosition(nameLabel.getX(), 100);
                    lodgePanel.add(priceLabel);

                    priceActual.setText(String.format("$%.2f", pricePerNight));
                    priceActual.setPosition((priceLabel.getX() + 100), priceLabel.getY());
                    lodgePanel.add(priceActual);

                    descLabel.setPosition(nameLabel.getX(), 125);
                    lodgePanel.add(descLabel);

                    descActual.setText(description);
                    descActual.setPosition((descLabel.getX() + 80), descLabel.getY());
                    lodgePanel.add(descActual);

                    maxLabel.setPosition(nameLabel.getX(), 150);
                    lodgePanel.add(maxLabel);

                    maxActual.setText(String.format("%d", maxOccupants));
                    maxActual.setPosition((maxLabel.getX() + 100), maxLabel.getY());
                    lodgePanel.add(maxActual);

                    vacLabel.setPosition(nameLabel.getX(), 175);
                    lodgePanel.add(vacLabel);

                    vacActual.setText(String.format("%d", vacancies));
                    vacActual.setPosition((vacLabel.getX() + 70), vacLabel.getY());
                    lodgePanel.add(vacActual);

                    parkFeeLabel.setPosition(nameLabel.getX(), 200);
                    lodgePanel.add(parkFeeLabel);

                    parkFeeActual.setText(String.format("$%.2f", parkingFee));
                    parkFeeActual.setPosition((parkFeeLabel.getX() + 80), parkFeeLabel.getY());
                    lodgePanel.add(parkFeeActual);

                    if (EmployeeView.lodgesList.get(lodgeIndex) instanceof House) {
                        House h = ((House) EmployeeView.lodgesList.get(lodgeIndex));
                        numberOfBedrooms = h.numberOfBedrooms;
                        numberOfBeds = h.numberOfBeds;
                        numberOfBathrooms = h.numberOfBathrooms;
                        numberOfStories = h.numberOfStories;

                        bedroomNumLabel.setPosition(nameLabel.getX(), 225);
                        lodgePanel.add(bedroomNumLabel);

                        bedroomNumActual.setText(String.format("%d", numberOfBedrooms));
                        bedroomNumActual.setPosition((bedroomNumLabel.getX() + 140), bedroomNumLabel.getY());
                        lodgePanel.add(bedroomNumActual);

                        bedNumLabel.setPosition(nameLabel.getX(), 250);
                        lodgePanel.add(bedNumLabel);

                        bedNumActual.setText(String.format("%d", numberOfBeds));
                        bedNumActual.setPosition((bedNumLabel.getX() + 110), bedNumLabel.getY());
                        lodgePanel.add(bedNumActual);

                        bathroomNumLabel.setPosition(nameLabel.getX(), 275);
                        lodgePanel.add(bathroomNumLabel);

                        bathroomNumActual.setText(String.format("%d", numberOfBathrooms));
                        bathroomNumActual.setPosition((bathroomNumLabel.getX() + 145), bathroomNumLabel.getY());
                        lodgePanel.add(bathroomNumActual);

                        storyNumActual.setText(String.format("%d", numberOfStories));
                        storyNumLabel.setPosition(nameLabel.getX(), 300);
                        lodgePanel.add(storyNumLabel);

                        storyNumActual.setPosition((storyNumLabel.getX() + 120), storyNumLabel.getY());
                        lodgePanel.add(storyNumActual);

                    } else {
                        Hotel h = ((Hotel) EmployeeView.lodgesList.get(lodgeIndex));
                        valetParking = h.valetParking;
                        freeBreakfast = h.freeBreakfast;
                        fireExit = h.fireExit;
                        elevators = h.elevators;
                        pool = h.pool;

                        valetLabel.setPosition(nameLabel.getX(), 225);
                        lodgePanel.add(valetLabel);

                        valetActual.setText(Boolean.toString(valetParking));
                        valetActual.setPosition((valetLabel.getX() + 90), valetLabel.getY());
                        lodgePanel.add(valetActual);

                        freeBreakfastLabel.setPosition(nameLabel.getX(), 250);
                        lodgePanel.add(freeBreakfastLabel);

                        freeBreakfastActual.setText(Boolean.toString(freeBreakfast));
                        freeBreakfastActual.setPosition((freeBreakfastLabel.getX() + 100), freeBreakfastLabel.getY());
                        lodgePanel.add(freeBreakfastActual);

                        fireExitLabel.setPosition(nameLabel.getX(), 275);
                        lodgePanel.add(fireExitLabel);

                        fireExitActual.setText(Boolean.toString(fireExit));
                        fireExitActual.setPosition((fireExitLabel.getX() + 60), fireExitLabel.getY());
                        lodgePanel.add(fireExitActual);

                        elevatorLabel.setPosition(nameLabel.getX(), 300);
                        lodgePanel.add(elevatorLabel);

                        elevatorActual.setText(Boolean.toString(elevators));
                        elevatorActual.setPosition((elevatorLabel.getX() + 70), elevatorLabel.getY());
                        lodgePanel.add(elevatorActual);

                        poolLabel.setPosition(nameLabel.getX(), 325);
                        lodgePanel.add(poolLabel);

                        poolActual.setText(Boolean.toString(pool));
                        poolActual.setPosition((poolLabel.getX() + 40), poolLabel.getY());
                        lodgePanel.add(poolActual);

                    }

                    dateSet1.setBounds(300, 100, 200, 35);
                    lodgePanel.add(dateSet1);

                    Label dtd = new Label("To", 25, 25);
                    dtd.setPosition(400, 175);
                    lodgePanel.add(dtd);

                    dateSet2.setBounds(300, 250, 200, 35);
                    lodgePanel.add(dateSet2);


                    lodgePanel.add(customerImageSp);


                    lodgePanel.add(placeOrderButton);

                    returnButton.setPosition(lodgePanel.getWidth() / 2 - returnButton.getWidth() / 2, 375);
                    lodgePanel.add(returnButton);
                }
                catch (Exception ex){
                    LodgeData loadData = new LodgeData();
                    Thread lodgeThread = new Thread(loadData);
                    lodgeThread.start();
                    
                    try {
                        lodgeThread.join();
                    }
                    catch (Exception ex2){
                        System.out.println(ex2);
                    }
                }
            }
        });

        cvImages.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent c){
                imageIndex = cvImages.getSelectedIndex();               
                
                frame.setEnabled(false);
                imageFrame.setVisible(true);
                imagePanel.setVisible(true);

                ImageIcon newImgIcon = new ImageIcon(EmployeeView.lodgesList.get(lodgeIndex).imagesList.get(imageIndex).myImage);
                double imgWidth = newImgIcon.getIconWidth(),
                    imgHeight = newImgIcon.getIconHeight(),
                    ratio,
                    widthNum;
                
                ratio = imgHeight / 500;
                widthNum = imgWidth / ratio;
                
                enlargedImageIcon = new MyImageIcon(newImgIcon.getImage().getScaledInstance((int)widthNum,500, Image.SCALE_SMOOTH));
                enlargedImageLabel = new JLabel(enlargedImageIcon);
                enlargedImageLabel.setBounds((imageFrame.getWidth() / 2) - ((int)widthNum / 2),85,(int)widthNum,500);
                imagePanel.add(enlargedImageLabel);
                
                imagePanel.add(nextImageButton);
                
                imagePanel.add(previousImageButton);

                imageFrame.add(imagePanel); 
            }
        });
        
        imageFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
               cvImages.clearSelection();
               frame.setEnabled(true);
               imagePanel.remove(enlargedImageLabel);
               imagePanel.remove(nextImageButton);
               imagePanel.remove(previousImageButton);
            }
        });        
        
        nextImageButton.setPosition(1131, imagePanel.getHeight() / 2 - nextImageButton.getHeight() / 2);
        nextImageButton.addActionListener((ActionEvent c) ->{
            if (imageIndex == EmployeeView.lodgesList.get(lodgeIndex).imagesList.size() - 1){
                imageIndex = 0;  
            } else {
                imageIndex += 1;
            }
            imagePanel.remove(enlargedImageLabel);
            imageFrame.invalidate();
            imageFrame.validate();
            imageFrame.repaint();
            
            ImageIcon newImgIcon = new ImageIcon(EmployeeView.lodgesList.get(lodgeIndex).imagesList.get(imageIndex).myImage);
            double imgWidth = newImgIcon.getIconWidth(),
                imgHeight = newImgIcon.getIconHeight(),
                ratio,
                widthNum;

            ratio = imgHeight / 500;
            widthNum = imgWidth / ratio;

            enlargedImageIcon = new MyImageIcon(newImgIcon.getImage().getScaledInstance((int)widthNum,500, Image.SCALE_SMOOTH));
            enlargedImageLabel = new JLabel(enlargedImageIcon);
            enlargedImageLabel.setBounds((imageFrame.getWidth() / 2) - ((int)widthNum / 2),85,(int)widthNum,500);
            imagePanel.add(enlargedImageLabel);
        });
        
        previousImageButton.setPosition(50,imagePanel.getHeight() / 2 - previousImageButton.getHeight() / 2);
        previousImageButton.addActionListener((ActionEvent c) -> {
            if (imageIndex == 0){
                imageIndex = EmployeeView.lodgesList.get(lodgeIndex).imagesList.size() - 1;  
            } else {
                imageIndex -= 1;
            }
            imagePanel.remove(enlargedImageLabel);
            imageFrame.invalidate();
            imageFrame.validate();
            imageFrame.repaint();
            
            ImageIcon newImgIcon = new ImageIcon(EmployeeView.lodgesList.get(lodgeIndex).imagesList.get(imageIndex).myImage);
            double imgWidth = newImgIcon.getIconWidth(),
                imgHeight = newImgIcon.getIconHeight(),
                ratio,
                widthNum;

            ratio = imgHeight / 500;
            widthNum = imgWidth / ratio;

            enlargedImageIcon = new MyImageIcon(newImgIcon.getImage().getScaledInstance((int)widthNum,500, Image.SCALE_SMOOTH));
            enlargedImageLabel = new JLabel(enlargedImageIcon);
            enlargedImageLabel.setBounds((imageFrame.getWidth() / 2) - ((int)widthNum / 2),85,(int)widthNum,500);
            imagePanel.add(enlargedImageLabel);
        });
        
        confirmButton.setPosition(viewOrderPanel.getWidth() / 2 - confirmButton.getWidth() / 2, 300);
        confirmButton.addActionListener((ActionEvent c) -> {
            orderBool = false;
            ordersList.add(orderDetails);
            OrderConfirm ordCon = new OrderConfirm();
            ordCon.setOrderDetails(orderDetails);
            Thread orderConfirmationThread = new Thread(ordCon);
            orderConfirmationThread.start();
            
            viewOrderPanel.setVisible(false);
            frame.remove(viewOrderPanel);
            cvLodges.setEnabled(true);
            frame.add(panel);
            viewOrderButton.setVisible(false);
            viewOrderButton.setEnabled(false);
            logoutButton.setEnabled(true);
            panel.setVisible(true);
        });

        cancelButton.setPosition(viewOrderPanel.getWidth() / 2 - cancelButton.getWidth() / 2, 375);
        cancelButton.addActionListener((ActionEvent c) -> {
            orderBool = false;
            order = null;
            orderDetails = null;
            viewOrderPanel.setVisible(false);
            frame.remove(viewOrderPanel);
            cvLodges.setEnabled(true);
            frame.add(panel);
            viewOrderButton.setVisible(false);
            viewOrderButton.setEnabled(false);
            logoutButton.setEnabled(true);
            panel.setVisible(true);
        });

        returnButton.setPosition(viewOrderPanel.getWidth() / 2 - returnButton.getWidth() / 2, 450);
        returnButton.addActionListener((ActionEvent c) -> {            
            viewOrderButton.setVisible(false);
            viewOrderPanel.setVisible(false);            
            frame.remove(viewOrderPanel);
            logoutButton.setEnabled(false);
            logoutButton.setEnabled(true);
            cvLodges.clearSelection();
            cvImages.clearSelection();
            lodgePanel.setVisible(false);
            lodgePanel.remove(bedroomNumLabel);
            lodgePanel.remove(bedroomNumActual);
            lodgePanel.remove(bedNumLabel);
            lodgePanel.remove(bedNumActual);
            lodgePanel.remove(bathroomNumLabel);
            lodgePanel.remove(bathroomNumActual);
            lodgePanel.remove(storyNumLabel);
            lodgePanel.remove(storyNumActual);
            lodgePanel.remove(valetLabel);
            lodgePanel.remove(valetActual);
            lodgePanel.remove(freeBreakfastLabel);
            lodgePanel.remove(freeBreakfastActual);
            lodgePanel.remove(fireExitLabel);
            lodgePanel.remove(fireExitActual);
            lodgePanel.remove(elevatorLabel);
            lodgePanel.remove(elevatorActual);
            lodgePanel.remove(poolLabel);
            lodgePanel.remove(poolActual);
            lodgePanel.remove(customerImageSp);
            frame.remove(lodgePanel);
            orderHistoryPanel.setVisible(false);
            frame.remove(orderHistoryPanel);
            if (orderBool == true){
                logoutButton.setEnabled(false);
                cvLodges.setEnabled(false);
                viewOrderButton.setEnabled(true);
                viewOrderButton.setVisible(true);
            } else {
                logoutButton.setEnabled(true);
                cvLodges.setEnabled(true);
                viewOrderButton.setEnabled(false);
                viewOrderButton.setVisible(false);
            }
            frame.add(panel);
            panel.setVisible(true);
        });

        viewOrderButton.setPosition(panel.getWidth() / 2 - viewOrderButton.getWidth() / 2, 200);
        viewOrderButton.addActionListener((ActionEvent e) -> {
            if (order != null) {
                panel.setVisible(false);
                frame.remove(panel);
                frame.add(viewOrderPanel);
                viewOrderPanel.setVisible(true);

                nameLabel.setPosition(viewOrderPanel.getWidth() / 6 - nameLabel.getWidth() / 6, 50);
                viewOrderPanel.add(nameLabel);

                nameActual.setPosition((nameLabel.getX() + 50), nameLabel.getY());
                viewOrderPanel.add(nameActual);

                nightsStayingLabel.setPosition(nameLabel.getX(), 75);
                viewOrderPanel.add(nightsStayingLabel);

                nightsStayingActual.setText(String.format("%d", nightsStaying));
                nightsStayingActual.setPosition((nightsStayingLabel.getX() + 100), nightsStayingLabel.getY());
                viewOrderPanel.add(nightsStayingActual);

                totalLabel.setPosition(nameLabel.getX(), 100);
                viewOrderPanel.add(totalLabel);

                totalActual.setText(String.format("$%.2f", total));
                totalActual.setPosition((totalLabel.getX() + 40), totalLabel.getY());
                viewOrderPanel.add(totalActual);

                viewOrderPanel.add(confirmButton);

                viewOrderPanel.add(cancelButton);

                viewOrderPanel.add(returnButton);
            }
        });
        panel.add(viewOrderButton);

        viewOrderButton.setVisible(false);
        viewOrderButton.setEnabled(false);

        orderHistoryButton.setPosition(panel.getWidth() / 2 - orderHistoryButton.getWidth() / 2, 275);
        orderHistoryButton.addActionListener((ActionEvent e) -> {
            if (LoginState.guestBool == true){
                System.out.println("You need to login to see your order history");
            } else {    
                panel.setVisible(false);
                frame.remove(panel);
                frame.add(orderHistoryPanel);
                EmployeeView.orderHistoryPanel.setVisible(false);
                orderHistoryPanel.setVisible(true);
                
                dateSet3.setBounds(300, 100, 200, 35);
                orderHistoryPanel.add(dateSet3);

                Label dtd = new Label("To", 25, 25);
                dtd.setPosition(400, 175);
                orderHistoryPanel.add(dtd);

                dateSet4.setBounds(300, 250, 200, 35);
                orderHistoryPanel.add(dateSet4);
                
                searchButton.setPosition(orderHistoryPanel.getWidth() / 2 - searchButton.getWidth() / 2, 300);
                orderHistoryPanel.add(searchButton);
                
                returnButton.setPosition(orderHistoryPanel.getWidth() / 2 - returnButton.getWidth() / 2, 375);
                orderHistoryPanel.add(returnButton);
                            
            }            
        });
        panel.add(orderHistoryButton);
        
        searchButton.addActionListener((ActionEvent e) -> {
            SearchOrders orderSearch = new SearchOrders();
            Thread orderSearchThread = new Thread(orderSearch);
            orderSearchThread.start();
        });
        
        logoutButton.setPosition(panel.getWidth() / 2 - logoutButton.getWidth() / 2, 350);
        logoutButton.addActionListener((ActionEvent e) -> {
            LoginState.cusBool = false;
            cvLodges.clearSelection();
            panel.setVisible(false);
            frame.remove(panel);
            frame.add(login.panel);
            login.panel.setVisible(true);
            frame.setTitle("Login");
        });
        panel.add(logoutButton);
    } 
}

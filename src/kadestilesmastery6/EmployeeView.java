/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
class EmployeeView extends State {

    //variables
    public int typeId,
            lodgeId,
            numberOfBeds,
            numberOfBedrooms,
            numberOfBathrooms,
            numberOfStories,
            maxOccupants,
            vacancies,
            lodgeIndex,
            imageIndex;
    public double parkingFee,
            pricePerNight;
    public String name,
            address,
            description,
            selectedLodge = "";
    public Boolean valetParking,
            freeBreakfast,
            fireExit,
            elevators,
            pool,
            editNameBool = false,
            editPriceBool = false,
            addImageBool = false,
            hotelImageBool = false,
            houseImageBool = false;
    MyImageIcon enlargedImageIcon;

    static MyImageIcon imageIcon,
            updatedImageIcon;
    
    public static ArrayList<Lodging> lodgesList = new ArrayList<>();
    static List evLodges = new List(new DefaultListModel(), 100, 300);
    static List evImages = new List(new DefaultListModel(), 205, 400);
   
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");

    static Button returnButton = new Button("Return", 75);

    static Button newLodgeButton = new Button("Add Lodge", 105);
    JPanel chooseLodgeTypePanel = new JPanel(null);
    Button hotel = new Button("Hotel", 100);
    Button house = new Button("House", 100);

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
    static Button editLodgeButton = new Button("Edit Lodge", 100);
    static Button removeLodgeButton = new Button("Remove Lodge", 125);

    JPanel addHotelPanel = new JPanel(null);
    Label hotelNameLabel = new Label("Name: ", 45);
    TextField hotelNameTf = new TextField(150);
    Label hotelAddressLabel = new Label("Address: ", 60);
    TextField hotelAddressTf = new TextField(200);
    Label hotelPriceLabel = new Label("Price Per Night: ", 150);
    TextField hotelPriceTf = new TextField(100);
    Label hotelDescLabel = new Label("Description: ", 125);
    TextField hotelDescTf = new TextField(300);
    Label hotelMaxLabel = new Label("Max Occupants: ", 150);
    TextField hotelMaxTf = new TextField(50);
    Label hotelVacLabel = new Label("Vacancies: ", 70);
    TextField hotelVacTf = new TextField(50);
    Label hotelParkFeeLabel = new Label("Parking Fee: ", 80);
    TextField hotelParkFeeTf = new TextField(50);
    Label hotelValetLabel = new Label("Valet Parking: ", 85);
    JPanel valetBoolGroupPanel = new JPanel(new GridLayout(0, 2));
    ButtonGroup valetBool = new ButtonGroup();
    Label hotelFreeBreakfastLabel = new Label("Free Breakfast: ", 100);
    JPanel breakfastBoolGroupPanel = new JPanel(new GridLayout(0, 2));
    ButtonGroup breakfastBool = new ButtonGroup();
    Label hotelFireExitLabel = new Label("Fire Exit: ", 60);
    JPanel fireExitBoolGroupPanel = new JPanel(new GridLayout(0, 2));
    ButtonGroup fireExitBool = new ButtonGroup();
    Label hotelElevatorLabel = new Label("Elevators: ", 65);
    JPanel elevatorBoolGroupPanel = new JPanel(new GridLayout(0, 2));
    ButtonGroup elevatorBool = new ButtonGroup();
    Label hotelPoolLabel = new Label("Pool: ", 40);
    JPanel poolBoolGroupPanel = new JPanel(new GridLayout(0, 2));
    ButtonGroup poolBool = new ButtonGroup();
    Button hotelImageChooserButton = new Button("Add file", 100);
    static JFileChooser hotelImageChooser = new JFileChooser();
    
    Button addHotel = new Button("Add", 75);

    JPanel addHousePanel = new JPanel(null);
    Label houseNameLabel = new Label("Name: ", 45);
    TextField houseNameTf = new TextField(150);
    Label houseAddressLabel = new Label("Address: ", 60);
    TextField houseAddressTf = new TextField(200);
    Label housePriceLabel = new Label("Price Per Night: ", 150);
    TextField housePriceTf = new TextField(100);
    Label houseDescLabel = new Label("Description: ", 125);
    TextField houseDescTf = new TextField(300);
    Label houseMaxLabel = new Label("Max Occupants: ", 150);
    TextField houseMaxTf = new TextField(50);
    Label houseVacLabel = new Label("Vacancies: ", 70);
    TextField houseVacTf = new TextField(50);
    Label houseParkFeeLabel = new Label("Parking Fee: ", 80);
    TextField houseParkFeeTf = new TextField(50);
    Label houseBedroomNumLabel = new Label("Number of Bedrooms: ", 135);
    TextField houseBedroomNumTf = new TextField(50);
    Label houseBedNumLabel = new Label("Number of Beds: ", 105);
    TextField houseBedNumTf = new TextField(50);
    Label houseBathroomNumLabel = new Label("Number of Bathrooms: ", 140);
    TextField houseBathroomNumTf = new TextField(50);
    Label houseStoryNumLabel = new Label("Number of Stories: ", 115);
    TextField houseStoryNumTf = new TextField(50);
    RadioButton valetTrue = new RadioButton("True");
    RadioButton valetFalse = new RadioButton("False");
    RadioButton breakfastTrue = new RadioButton("True");
    RadioButton breakfastFalse = new RadioButton("False");
    RadioButton fireExitTrue = new RadioButton("True");
    RadioButton fireExitFalse = new RadioButton("False");
    RadioButton elevatorTrue = new RadioButton("True");
    RadioButton elevatorFalse = new RadioButton("False");
    RadioButton poolTrue = new RadioButton("True");
    RadioButton poolFalse = new RadioButton("False");
    Button houseImageChooserButton = new Button("Add file", 100);
    static JFileChooser houseImageChooser = new JFileChooser();
    Button addHouse = new Button("Add", 75);

    JPanel editLodgePanel = new JPanel(null);
    Label editNameLabel = new Label("Name: ", 50);
    TextField editNameTf = new TextField(150);
    Label editPriceLabel = new Label("Price Per Night: ", 150);
    TextField editPriceTf = new TextField(50);
    static Button imageChooserButton = new Button("Add file", 100);
    
    static JFileChooser imageChooser = new JFileChooser();
    
    Button finishEdit = new Button("Finish", 75);

    JFrame imageFrame = new JFrame();
    JPanel imagePanel = new JPanel(null);
    JLabel enlargedImageLabel = new JLabel();
    Button nextImageButton = new Button(">", 100, 100, 50);
    Button previousImageButton = new Button("<", 100, 100, 50);
    
    Button orderHistoryButton = new Button("Order History", 115);
    static JPanel orderHistoryPanel = new JPanel(null);
    static Dates dateSet3 = new Dates();
    static Dates dateSet4 = new Dates();
    Button searchButton = new Button("Search", 105);
    
    Button refreshButton = new Button("Refresh", 80);
    Button logoutButton = new Button("Logout", 75);
    
    static Label imageProgressLabel = new Label("", 70);
    static Label imageProgressActual = new Label("", 100);
    
    static Timer timer,
            hotelTimer,
            houseTimer;

    public EmployeeView() {
        
        panel.setBounds(0, 0, 800, 600);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#dee2d6"));
        panel.setVisible(true);

        imageProgressLabel.setPosition(550, 525);
        panel.add(imageProgressLabel);
        
        imageProgressActual.setPosition(610, 525);
        panel.add(imageProgressActual);
        
        chooseLodgeTypePanel.setBounds(0, 0, 800, 600);
        chooseLodgeTypePanel.setBackground(Color.decode("#dee2d6"));

        addHotelPanel.setBounds(0, 0, 800, 600);
        addHotelPanel.setBackground(Color.decode("#dee2d6"));

        hotelImageChooser.setFileFilter(filter);
        hotelImageChooser.setMultiSelectionEnabled(true);

        addHousePanel.setBounds(0, 0, 800, 600);
        addHousePanel.setBackground(Color.decode("#dee2d6"));

        houseImageChooser.setFileFilter(filter);
        houseImageChooser.setMultiSelectionEnabled(true);

        lodgePanel.setBounds(0, 0, 800, 600);
        lodgePanel.setBackground(Color.decode("#dee2d6"));

        editLodgePanel.setBounds(0, 0, 800, 600);
        editLodgePanel.setBackground(Color.decode("#dee2d6"));
        
        orderHistoryPanel.setBounds(0, 0, 800, 600);
        orderHistoryPanel.setBackground(Color.decode("#dee2d6"));

        imageChooser.setFileFilter(filter);
        imageChooser.setMultiSelectionEnabled(true);

        evLodges.setPosition(panel.getWidth() / 6 - evLodges.getWidth() / 6, 125);
        evLodges.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        evLodges.setLayoutOrientation(List.VERTICAL);

        panel.add(evLodges);
        
        ScrollPane employeeSp = new ScrollPane(evLodges.getWidth(), evLodges.getHeight());
        employeeSp.setViewportView(evLodges);
        employeeSp.setPosition(evLodges.getX(), evLodges.getY());

        panel.add(employeeSp);
        
        evImages.setPosition(550, 50);
        evImages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        evImages.setLayoutOrientation(List.VERTICAL);
        
        ScrollPane employeeImageSp = new ScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER, evImages.getWidth(), evImages.getHeight());
        employeeImageSp.setViewportView(evImages);
        employeeImageSp.setPosition(evImages.getX(), evImages.getY());
        
        
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
            
            evLodges.setEnabled(true);
        });
        panel.add(refreshButton);
                
        hotelImageChooserButton.addActionListener((ActionEvent a) -> {
            int returnVal = hotelImageChooser.showOpenDialog(null);
            if (returnVal == hotelImageChooser.APPROVE_OPTION) {
                hotelImageBool = true;                
            } else {
                hotelImageBool = false;
            }
        });
        
        addHotel.setPosition(addHotelPanel.getWidth() / 2 - addHotel.getWidth() / 2, 475);
        addHotel.addActionListener((ActionEvent c) -> {
            frame.remove(addHotelPanel);
            frame.add(panel);
            panel.setVisible(true);
            LodgeAdder hotelAdder = new LodgeAdder("Hotel");            
            hotelAdder.setHotelImageBool(hotelImageBool);
            typeId = 1;
            hotelAdder.setTypeId(typeId);
            name = hotelNameTf.getText();
            hotelAdder.setName(name);
            address = hotelAddressTf.getText();
            hotelAdder.setAddress(address);
            pricePerNight = Double.parseDouble(hotelPriceTf.getText());
            hotelAdder.setPricePerNight(pricePerNight);
            description = hotelDescTf.getText();
            hotelAdder.setDescription(description);
            maxOccupants = Integer.parseInt(hotelMaxTf.getText());
            hotelAdder.setMaxOccupants(maxOccupants);
            vacancies = Integer.parseInt(hotelVacTf.getText());
            hotelAdder.setVacancies(vacancies);
            parkingFee = Double.parseDouble(hotelParkFeeTf.getText());
            hotelAdder.setParkingFee(parkingFee);
            valetParking = Boolean.valueOf(valetBool.getSelection().getActionCommand());
            hotelAdder.setValetParking(valetParking);
            freeBreakfast = Boolean.valueOf(breakfastBool.getSelection().getActionCommand());
            hotelAdder.setFreeBreakfast(freeBreakfast);
            fireExit = Boolean.valueOf(fireExitBool.getSelection().getActionCommand());
            hotelAdder.setFireExit(fireExit);
            elevators = Boolean.valueOf(elevatorBool.getSelection().getActionCommand());
            hotelAdder.setElevators(elevators);
            pool = Boolean.valueOf(poolBool.getSelection().getActionCommand());
            hotelAdder.setPool(pool);
            Hotel newHotel = new Hotel(
                    valetParking,
                    freeBreakfast,
                    fireExit,
                    elevators,
                    pool,
                    lodgeId,
                    name,
                    address,
                    description,
                    parkingFee,
                    maxOccupants,
                    vacancies,
                    pricePerNight);
            lodgesList.add(newHotel);
            Thread newLodgeThread = new Thread(hotelAdder);
            newLodgeThread.start();
            
            if (hotelImageBool){
                hotelTimer = new Timer(0, e -> imageProgressActual.setText(Integer.toString(hotelAdder.imageNum + 1) + " / " + Integer.toString(hotelAdder.totalImageNum)));
                
                hotelTimer.start();
            }
            
            addHotelPanel.setVisible(false);
            hotelNameTf.clearTextField(hotelNameTf);
            hotelAddressTf.clearTextField(hotelAddressTf);
            hotelPriceTf.clearTextField(hotelPriceTf);
            hotelDescTf.clearTextField(hotelDescTf);
            hotelMaxTf.clearTextField(hotelMaxTf);
            hotelVacTf.clearTextField(hotelVacTf);
            hotelParkFeeTf.clearTextField(hotelParkFeeTf);
            valetBool.clearSelection();
            breakfastBool.clearSelection();
            fireExitBool.clearSelection();
            elevatorBool.clearSelection();
            poolBool.clearSelection();           
            
            save();
        });

        hotel.setPosition(chooseLodgeTypePanel.getWidth() / 2 - hotel.getWidth() / 2, 225);
        hotel.addActionListener((ActionEvent e) -> {
            chooseLodgeTypePanel.setVisible(false);
            frame.remove(chooseLodgeTypePanel);
            frame.add(addHotelPanel);
            addHotelPanel.setVisible(true);

            hotelNameLabel.setPosition(addHotelPanel.getWidth() / 6 - hotelNameLabel.getWidth() / 6, 50);
            addHotelPanel.add(hotelNameLabel);

            hotelNameTf.setPosition((hotelNameLabel.getX() + 50), hotelNameLabel.getY());
            addHotelPanel.add(hotelNameTf);

            hotelAddressLabel.setPosition(hotelNameLabel.getX(), 85);
            addHotelPanel.add(hotelAddressLabel);

            hotelAddressTf.setPosition((hotelAddressLabel.getX() + 60), hotelAddressLabel.getY());
            addHotelPanel.add(hotelAddressTf);

            hotelPriceLabel.setPosition(hotelNameLabel.getX(), 120);
            addHotelPanel.add(hotelPriceLabel);

            hotelPriceTf.setPosition((hotelPriceLabel.getX() + 100), hotelPriceLabel.getY());
            addHotelPanel.add(hotelPriceTf);

            hotelDescLabel.setPosition(hotelNameLabel.getX(), 155);
            addHotelPanel.add(hotelDescLabel);

            hotelDescTf.setPosition((hotelDescLabel.getX() + 80), hotelDescLabel.getY());
            addHotelPanel.add(hotelDescTf);

            hotelMaxLabel.setPosition(hotelNameLabel.getX(), 190);
            addHotelPanel.add(hotelMaxLabel);

            hotelMaxTf.setPosition((hotelMaxLabel.getX() + 100), hotelMaxLabel.getY());
            addHotelPanel.add(hotelMaxTf);

            hotelVacLabel.setPosition(hotelNameLabel.getX(), 225);
            addHotelPanel.add(hotelVacLabel);

            hotelVacTf.setPosition((hotelVacLabel.getX() + 70), hotelVacLabel.getY());
            addHotelPanel.add(hotelVacTf);

            hotelParkFeeLabel.setPosition(hotelNameLabel.getX(), 260);
            addHotelPanel.add(hotelParkFeeLabel);

            hotelParkFeeTf.setPosition((hotelParkFeeLabel.getX() + 80), hotelParkFeeLabel.getY());
            addHotelPanel.add(hotelParkFeeTf);

            hotelValetLabel.setPosition(hotelNameLabel.getX(), 295);
            addHotelPanel.add(hotelValetLabel);

            valetBoolGroupPanel.setBounds(hotelValetLabel.getX() + 90, hotelValetLabel.getY(), 115, 25);

            valetBoolGroupPanel.add(valetTrue);
            valetTrue.setActionCommand("true");
            valetBool.add(valetTrue);
            valetBoolGroupPanel.add(valetFalse);
            valetFalse.setActionCommand("false");
            valetBool.add(valetFalse);
            addHotelPanel.add(valetBoolGroupPanel);

            hotelFreeBreakfastLabel.setPosition(hotelNameLabel.getX(), 330);
            addHotelPanel.add(hotelFreeBreakfastLabel);

            breakfastBoolGroupPanel.setBounds(hotelFreeBreakfastLabel.getX() + 100, hotelFreeBreakfastLabel.getY(), 115, 25);

            breakfastBoolGroupPanel.add(breakfastTrue);
            breakfastTrue.setActionCommand("true");
            breakfastBool.add(breakfastTrue);
            breakfastBoolGroupPanel.add(breakfastFalse);
            breakfastFalse.setActionCommand("false");
            breakfastBool.add(breakfastFalse);
            addHotelPanel.add(breakfastBoolGroupPanel);

            hotelFireExitLabel.setPosition(hotelNameLabel.getX(), 365);
            addHotelPanel.add(hotelFireExitLabel);

            fireExitBoolGroupPanel.setBounds(hotelFireExitLabel.getX() + 60, hotelFireExitLabel.getY(), 115, 25);

            fireExitBoolGroupPanel.add(fireExitTrue);
            fireExitTrue.setActionCommand("true");
            fireExitBool.add(fireExitTrue);
            fireExitBoolGroupPanel.add(fireExitFalse);
            fireExitFalse.setActionCommand("false");
            fireExitBool.add(fireExitFalse);
            addHotelPanel.add(fireExitBoolGroupPanel);

            hotelElevatorLabel.setPosition(hotelNameLabel.getX(), 400);
            addHotelPanel.add(hotelElevatorLabel);

            elevatorBoolGroupPanel.setBounds(hotelElevatorLabel.getX() + 70, hotelElevatorLabel.getY(), 115, 25);

            elevatorBoolGroupPanel.add(elevatorTrue);
            elevatorTrue.setActionCommand("true");
            elevatorBool.add(elevatorTrue);
            elevatorBoolGroupPanel.add(elevatorFalse);
            elevatorFalse.setActionCommand("false");
            elevatorBool.add(elevatorFalse);
            addHotelPanel.add(elevatorBoolGroupPanel);

            hotelPoolLabel.setPosition(hotelNameLabel.getX(), 435);
            addHotelPanel.add(hotelPoolLabel);

            poolBoolGroupPanel.setBounds(hotelPoolLabel.getX() + 40, hotelPoolLabel.getY(), 115, 25);

            poolBoolGroupPanel.add(poolTrue);
            poolTrue.setActionCommand("true");
            poolBool.add(poolTrue);
            poolBoolGroupPanel.add(poolFalse);
            poolFalse.setActionCommand("false");
            poolBool.add(poolFalse);
            addHotelPanel.add(poolBoolGroupPanel);

            hotelImageChooserButton.setPosition(650, 100);
            addHotelPanel.add(hotelImageChooserButton);
            
            addHotelPanel.add(addHotel);

            returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 525);
            addHotelPanel.add(returnButton);
        });

        houseImageChooserButton.addActionListener((ActionEvent a) -> {
            int returnVal = houseImageChooser.showOpenDialog(null);
            if (returnVal == houseImageChooser.APPROVE_OPTION) {
                houseImageBool = true;
            } else {
                houseImageBool = false;
            }
        });
        
        addHouse.setPosition(addHousePanel.getWidth() / 2 - addHouse.getWidth() / 2, 475);
        addHouse.addActionListener((ActionEvent c) -> {
            frame.remove(addHousePanel);
            frame.add(panel);
            panel.setVisible(true); 
            LodgeAdder houseAdder = new LodgeAdder("House");
            houseAdder.setHouseImageBool(houseImageBool);
            typeId = 2;
            houseAdder.setTypeId(typeId);
            name = houseNameTf.getText();
            houseAdder.setName(name);
            address = houseAddressTf.getText();
            houseAdder.setAddress(address);
            pricePerNight = Double.parseDouble(housePriceTf.getText());
            houseAdder.setPricePerNight(pricePerNight);
            description = houseDescTf.getText();
            houseAdder.setDescription(description);
            maxOccupants = Integer.parseInt(houseMaxTf.getText());
            houseAdder.setMaxOccupants(maxOccupants);
            vacancies = Integer.parseInt(houseVacTf.getText());
            houseAdder.setVacancies(vacancies);
            parkingFee = Double.parseDouble(houseParkFeeTf.getText());
            houseAdder.setParkingFee(parkingFee);
            numberOfBedrooms = Integer.parseInt(houseBedroomNumTf.getText());
            houseAdder.setNumberOfBedrooms(numberOfBedrooms);
            numberOfBeds = Integer.parseInt(houseBedNumTf.getText());
            houseAdder.setNumberOfBeds(numberOfBeds);
            numberOfBathrooms = Integer.parseInt(houseBathroomNumTf.getText());
            houseAdder.setNumberOfBathrooms(numberOfBathrooms);
            numberOfStories = Integer.parseInt(houseStoryNumTf.getText());
            houseAdder.setNumberOfStories(numberOfStories);
            House newHouse = new House(
                    numberOfBeds,
                    numberOfBedrooms,
                    numberOfBathrooms,
                    numberOfStories,
                    lodgeId,
                    name,
                    address,
                    description,
                    parkingFee,
                    maxOccupants,
                    vacancies,
                    pricePerNight);
            lodgesList.add(newHouse);
            Thread newLodgeThread = new Thread(houseAdder);
            newLodgeThread.start();
            
            if (houseImageBool){
                houseTimer = new Timer(0, e -> imageProgressActual.setText(Integer.toString(houseAdder.imageNum + 1) + " / " + Integer.toString(houseAdder.totalImageNum)));
                
                houseTimer.start();
            }
            
            addHousePanel.setVisible(false);
            houseNameTf.clearTextField(houseNameTf);
            houseAddressTf.clearTextField(houseAddressTf);
            housePriceTf.clearTextField(housePriceTf);
            houseDescTf.clearTextField(houseDescTf);
            houseMaxTf.clearTextField(houseMaxTf);
            houseVacTf.clearTextField(houseVacTf);
            houseParkFeeTf.clearTextField(houseParkFeeTf);
            houseBedroomNumTf.clearTextField(houseBedroomNumTf);
            houseBedNumTf.clearTextField(houseBedNumTf);
            houseBathroomNumTf.clearTextField(houseBathroomNumTf);
            houseStoryNumTf.clearTextField(houseStoryNumTf);
            
            save();
        });

        house.setPosition(chooseLodgeTypePanel.getWidth() / 2 - house.getWidth() / 2, 300);
        house.addActionListener((ActionEvent e) -> {
            chooseLodgeTypePanel.setVisible(false);
            frame.remove(chooseLodgeTypePanel);
            frame.add(addHousePanel);
            addHousePanel.setVisible(true);

            houseNameLabel.setPosition(addHousePanel.getWidth() / 6 - houseNameLabel.getWidth() / 6, 50);
            addHousePanel.add(houseNameLabel);

            houseNameTf.setPosition((houseNameLabel.getX() + 50), houseNameLabel.getY());
            addHousePanel.add(houseNameTf);

            houseAddressLabel.setPosition(houseNameLabel.getX(), 85);
            addHousePanel.add(houseAddressLabel);

            houseAddressTf.setPosition((houseAddressLabel.getX() + 60), houseAddressLabel.getY());
            addHousePanel.add(houseAddressTf);

            housePriceLabel.setPosition(houseNameLabel.getX(), 120);
            addHousePanel.add(housePriceLabel);

            housePriceTf.setPosition((housePriceLabel.getX() + 100), housePriceLabel.getY());
            addHousePanel.add(housePriceTf);

            houseDescLabel.setPosition(houseNameLabel.getX(), 155);
            addHousePanel.add(houseDescLabel);

            houseDescTf.setPosition((houseDescLabel.getX() + 80), houseDescLabel.getY());
            addHousePanel.add(houseDescTf);

            houseMaxLabel.setPosition(houseNameLabel.getX(), 190);
            addHousePanel.add(houseMaxLabel);

            houseMaxTf.setPosition((houseMaxLabel.getX() + 100), houseMaxLabel.getY());
            addHousePanel.add(houseMaxTf);

            houseVacLabel.setPosition(houseNameLabel.getX(), 225);
            addHousePanel.add(houseVacLabel);

            houseVacTf.setPosition((houseVacLabel.getX() + 70), houseVacLabel.getY());
            addHousePanel.add(houseVacTf);

            houseParkFeeLabel.setPosition(houseNameLabel.getX(), 260);
            addHousePanel.add(houseParkFeeLabel);

            houseParkFeeTf.setPosition((houseParkFeeLabel.getX() + 80), houseParkFeeLabel.getY());
            addHousePanel.add(houseParkFeeTf);

            houseBedroomNumLabel.setPosition(houseNameLabel.getX(), 295);
            addHousePanel.add(houseBedroomNumLabel);

            houseBedroomNumTf.setPosition((houseBedroomNumLabel.getX() + 140), houseBedroomNumLabel.getY());
            addHousePanel.add(houseBedroomNumTf);

            houseBedNumLabel.setPosition(houseNameLabel.getX(), 330);
            addHousePanel.add(houseBedNumLabel);

            houseBedNumTf.setPosition((houseBedNumLabel.getX() + 110), houseBedNumLabel.getY());
            addHousePanel.add(houseBedNumTf);

            houseBathroomNumLabel.setPosition(houseNameLabel.getX(), 365);
            addHousePanel.add(houseBathroomNumLabel);

            houseBathroomNumTf.setPosition((houseBathroomNumLabel.getX() + 145), houseBathroomNumLabel.getY());
            addHousePanel.add(houseBathroomNumTf);

            houseStoryNumLabel.setPosition(houseNameLabel.getX(), 400);
            addHousePanel.add(houseStoryNumLabel);

            houseStoryNumTf.setPosition((houseStoryNumLabel.getX() + 120), houseStoryNumLabel.getY());
            addHousePanel.add(houseStoryNumTf);

            houseImageChooserButton.setPosition(650, 100);
            addHousePanel.add(houseImageChooserButton);

            
            addHousePanel.add(addHouse);

            returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 525);
            addHousePanel.add(returnButton);
        });
        
        returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 450);
        returnButton.addActionListener((ActionEvent b) -> {
            evLodges.clearSelection();
            chooseLodgeTypePanel.setVisible(false);
            chooseLodgeTypePanel.remove(returnButton);
            frame.remove(chooseLodgeTypePanel);
            addHotelPanel.setVisible(false);
            hotelNameTf.clearTextField(hotelNameTf);
            hotelAddressTf.clearTextField(hotelAddressTf);
            hotelPriceTf.clearTextField(hotelPriceTf);
            hotelDescTf.clearTextField(hotelDescTf);
            hotelMaxTf.clearTextField(hotelMaxTf);
            hotelVacTf.clearTextField(hotelVacTf);
            hotelParkFeeTf.clearTextField(hotelParkFeeTf);
            valetBool.clearSelection();
            breakfastBool.clearSelection();
            fireExitBool.clearSelection();
            elevatorBool.clearSelection();
            poolBool.clearSelection();
            addHotelPanel.remove(returnButton);
            frame.remove(addHotelPanel);
            addHousePanel.setVisible(false);
            houseNameTf.clearTextField(houseNameTf);
            houseAddressTf.clearTextField(houseAddressTf);
            housePriceTf.clearTextField(housePriceTf);
            houseDescTf.clearTextField(houseDescTf);
            houseMaxTf.clearTextField(houseMaxTf);
            houseVacTf.clearTextField(houseVacTf);
            houseParkFeeTf.clearTextField(houseParkFeeTf);
            houseBedroomNumTf.clearTextField(houseBedroomNumTf);
            houseBedNumTf.clearTextField(houseBedNumTf);
            houseBathroomNumTf.clearTextField(houseBathroomNumTf);
            houseStoryNumTf.clearTextField(houseStoryNumTf);
            addHousePanel.remove(returnButton);
            frame.remove(addHousePanel);
            editLodgePanel.setVisible(false);
            editNameTf.clearTextField(editNameTf);
            editNameBool = false;
            editPriceTf.clearTextField(editPriceTf);
            editPriceBool = false;
            editLodgePanel.remove(returnButton);
            frame.remove(editLodgePanel);
            lodgePanel.setVisible(false);
            lodgePanel.remove(evImages);            
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
            lodgePanel.remove(returnButton);
            lodgePanel.remove(imagePanel);            
            frame.remove(lodgePanel);
            orderHistoryPanel.setVisible(false);
            frame.remove(orderHistoryPanel);
            frame.add(panel);
            panel.setVisible(true);
        });

        newLodgeButton.setPosition(panel.getWidth() / 2 - newLodgeButton.getWidth() / 2, 150);
        newLodgeButton.addActionListener((ActionEvent b) -> {
            panel.setVisible(false);
            frame.remove(panel);
            frame.add(chooseLodgeTypePanel);
            chooseLodgeTypePanel.setVisible(true);

            chooseLodgeTypePanel.add(hotel);

            chooseLodgeTypePanel.add(house);

            returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 375);
            chooseLodgeTypePanel.add(returnButton);
        });
        panel.add(newLodgeButton);

        editNameTf.addKeyListener((new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                name = editNameTf.getText();
                if (!name.equals("") && !name.equals(" ")) {
                    editNameBool = true;
                }
            }
        }));

        editPriceTf.addKeyListener((new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                pricePerNight = Double.parseDouble(editPriceTf.getText());
                if (!name.equals("") && !name.equals(" ")) {
                    editPriceBool = true;
                }
            }
        }));

        imageChooserButton.addActionListener((ActionEvent a) -> {
            int returnVal = imageChooser.showOpenDialog(null);
            if (returnVal == imageChooser.APPROVE_OPTION) {
                addImageBool = true;
            } else {
                addImageBool = false;
            }
        });

        finishEdit.addActionListener((ActionEvent a) -> {
            LodgeEdit editData = new LodgeEdit();            
            editData.setEditNameBool(editNameBool);
            if (editNameBool){
                editData.setName(name);
            }
            
            editData.setEditPriceBool(editPriceBool);
            if (editPriceBool){
                editData.setPricePerNight(pricePerNight);
            }
            editData.setAddImageBool(addImageBool);
            editData.setSelectedLodge(selectedLodge);
            Thread lodgeEditThread = new Thread(editData);
            lodgeEditThread.start();
            
            if (addImageBool){
                timer = new Timer(0, e -> imageProgressActual.setText(Integer.toString(editData.imageNum + 1) + " / " + Integer.toString(editData.totalImageNum)));
                
                timer.start();                      
            }
            
            evLodges.clearSelection();
            editLodgePanel.setVisible(false);
            editNameTf.clearTextField(editNameTf);
            editNameBool = false;
            editPriceTf.clearTextField(editPriceTf);
            editPriceBool = false;
            addImageBool = false;            
            frame.remove(editLodgePanel);
            frame.add(panel);
            panel.setVisible(true);            
            save();
        });

        editLodgeButton.setPosition(panel.getWidth() / 2 - editLodgeButton.getWidth() / 2, 225);
        editLodgeButton.addActionListener((ActionEvent b) -> {
            lodgePanel.setVisible(false);
            frame.remove(lodgePanel);
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
            lodgePanel.remove(evImages);
            evImages.clearSelection();
            frame.add(editLodgePanel);
            editLodgePanel.setVisible(true);

            editNameLabel.setPosition((editLodgePanel.getWidth() / 2 - editNameLabel.getWidth() / 2) - 65, 50);
            editLodgePanel.add(editNameLabel);

            editNameTf.setPosition(editNameLabel.getX() + editNameLabel.getWidth(), editNameLabel.getY());
            editLodgePanel.add(editNameTf);

            editPriceLabel.setPosition((editLodgePanel.getWidth() / 2 - editPriceLabel.getWidth() / 2) - 10, 125);
            editLodgePanel.add(editPriceLabel);

            editPriceTf.setPosition(editPriceLabel.getX() + 110, editPriceLabel.getY());
            editLodgePanel.add(editPriceTf);

            imageChooserButton.setPosition(editLodgePanel.getWidth() / 2 - imageChooserButton.getWidth() / 2, 200);
            editLodgePanel.add(imageChooserButton);

            finishEdit.setPosition(editLodgePanel.getWidth() / 2 - finishEdit.getWidth() / 2, 275);
            editLodgePanel.add(finishEdit);

            returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 350);
            editLodgePanel.add(returnButton);
        });

        removeLodgeButton.setPosition(panel.getWidth() / 2 - removeLodgeButton.getWidth() / 2, 300);
        removeLodgeButton.addActionListener((ActionEvent b) -> {
            LodgeRemoval removeLodge = new LodgeRemoval();
            removeLodge.setSelectedLodge(selectedLodge);
            removeLodge.setLodgeIndex(lodgeIndex);
            Thread lodgeRemovalThread = new Thread(removeLodge);
            lodgeRemovalThread.start();
            
            lodgePanel.setVisible(false);
            frame.remove(lodgePanel);
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
            evImages.clearSelection();
            lodgePanel.remove(evImages);            
            frame.add(panel);
            panel.setVisible(true);  
            save();            
        });

        evLodges.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    lodgeIndex = evLodges.getSelectedIndex();
                    selectedLodge = (String)evLodges.getSelectedValue();
                    
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

                    nameLabel.setPosition(lodgePanel.getWidth() / 6 - nameLabel.getWidth() / 6, 50);
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

                    lodgePanel.add(editLodgeButton);

                    lodgePanel.add(removeLodgeButton);

                    lodgePanel.add(employeeImageSp);

                    returnButton.setPosition(panel.getWidth() / 2 - returnButton.getWidth() / 2, 375);
                    lodgePanel.add(returnButton);
                    
                    ImageData loadImages = new ImageData();
                    loadImages.setLodgeIndex(lodgeIndex);
                    loadImages.setSelectedLodge(selectedLodge);
                    Thread imageThread = new Thread(loadImages);
                    imageThread.start(); 
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
        
        evImages.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent c){                
                imageIndex = evImages.getSelectedIndex();

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
               evImages.clearSelection();
               imagePanel.remove(enlargedImageLabel);
               imagePanel.remove(nextImageButton);
               imagePanel.remove(previousImageButton);
            }
        });       
        
        nextImageButton.setPosition(1131, imagePanel.getHeight() / 2 - nextImageButton.getHeight() / 2);
        nextImageButton.addActionListener((ActionEvent c) ->{
            if (imageIndex == lodgesList.get(lodgeIndex).imagesList.size() - 1){
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
                imageIndex = lodgesList.get(lodgeIndex).imagesList.size() - 1;  
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

        orderHistoryButton.setPosition(panel.getWidth() / 2 - orderHistoryButton.getWidth() / 2, 225);
        orderHistoryButton.addActionListener((ActionEvent e) -> {  
            panel.setVisible(false);
            frame.remove(panel);
            frame.add(orderHistoryPanel);
            CustomerView.orderHistoryPanel.setVisible(false);
            orderHistoryPanel.setVisible(true);
            
            dateSet3.setBounds(300, 100, 200, 35);
            orderHistoryPanel.add(dateSet3);

            Label dtd = new Label("To", 25, 25);
            dtd.setPosition(400, 175);
            orderHistoryPanel.add(dtd);

            dateSet4.setBounds(300, 250, 200, 35);
            orderHistoryPanel.add(dateSet4);

            searchButton.setPosition(orderHistoryPanel.getWidth() / 2 - searchButton.getWidth() / 2, 400);
            orderHistoryPanel.add(searchButton);   
            
            returnButton.setPosition(orderHistoryPanel.getWidth() / 2 - returnButton.getWidth() / 2, 525);
            orderHistoryPanel.add(returnButton);
        });
        panel.add(orderHistoryButton);
        
        searchButton.addActionListener((ActionEvent e) -> {
            SearchOrders orderSearch = new SearchOrders();
            Thread orderSearchThread = new Thread(orderSearch);
            orderSearchThread.start();            
        });
        
        logoutButton.setPosition(panel.getWidth() / 2 - logoutButton.getWidth() / 2, 300);
        logoutButton.addActionListener((ActionEvent e) -> {
            LoginState.employBool = false;
            panel.setVisible(false);
            evLodges.clearSelection();
            frame.remove(panel);
            frame.add(login.panel);
            login.panel.setVisible(true);
            frame.setTitle("Login");
        });
        panel.add(logoutButton);

    }

    @Override
    void save() {
        try {
            BufferedWriter bwl = new BufferedWriter(new FileWriter("Lodges.txt"));
            for (Lodging lodge : lodgesList) {
                if (lodge instanceof Hotel) {
                    Hotel h = (Hotel) lodge;
                    bwl.append(h.valetParking + "~" + h.freeBreakfast + "~" + h.fireExit + "~" + h.elevators + "~" + h.pool + "~" + lodge.name + "~" + lodge.address + "~" + lodge.description + "~" + lodge.parkingFee + "~" + lodge.maxOccupants + "~" + lodge.vacancies + "~" + lodge.pricePerNight + "\n");
                } else {
                    House h = (House) lodge;
                    bwl.append(h.numberOfBeds + "~" + h.numberOfBedrooms + "~" + h.numberOfBathrooms + "~" + h.numberOfStories + "~" + lodge.name + "~" + lodge.address + "~" + lodge.description + "~" + lodge.parkingFee + "~" + lodge.maxOccupants + "~" + lodge.vacancies + "~" + lodge.pricePerNight + "\n");
                }
            }
            bwl.close();
        } catch (Exception ex2) {
            System.out.print(ex2);
        }
    }
}


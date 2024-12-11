/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import static kadestilesmastery6.EmployeeView.lodgesList;
import static kadestilesmastery6.State.*;

/**
 *
 * @author KadeS
 */
public class ImageData implements Runnable{   
    String selectedLodge; 
    
    int lodgeIndex;

    public void setSelectedLodge(String selectedLodge) {
        this.selectedLodge = selectedLodge;
    }
    
    public void setLodgeIndex(int lodgeIndex) {
        this.lodgeIndex = lodgeIndex;
    }
    
    @Override
    public void run(){
        try {  
            CustomerView.returnButton.setEnabled(false);
            CustomerView.placeOrderButton.setEnabled(false);
            EmployeeView.returnButton.setEnabled(false);
            EmployeeView.editLodgeButton.setEnabled(false);
            EmployeeView.removeLodgeButton.setEnabled(false);
            int id = 0;
            for (int i = 0; i < lodgesList.size(); i++){
                if (selectedLodge.equals(lodgesList.get(i).name)){
                    id = lodgesList.get(i).lodgeId;
                    break;
                }
            }
            EmployeeView.lodgesList.get(lodgeIndex).imagesList.clear();
            
            CustomerView.cvImages.setVisible(false);                           
            EmployeeView.evImages.setVisible(false);
            

            Blob imageBlob;                

            String s4 = "";
            String query4 = "SELECT ActualImage FROM stilesksu23.Images WHERE LodgeID = " + id;
            PreparedStatement ps4 = con.prepareStatement(query4);
            ResultSet rs4 = ps4.executeQuery();

            while (rs4.next()) {                       
                imageBlob = rs4.getBlob("ActualImage");
                byte[] b = imageBlob.getBytes(1, (int) imageBlob.length());
                if (LoginState.cusBool){
                    CustomerView.imageIcon = new MyImageIcon(new ImageIcon(b).getImage());
                    EmployeeView.lodgesList.get(lodgeIndex).imagesList.add(CustomerView.imageIcon); 
                } else if (LoginState.employBool){
                    EmployeeView.imageIcon = new MyImageIcon(new ImageIcon(b).getImage());
                    EmployeeView.lodgesList.get(lodgeIndex).imagesList.add(EmployeeView.imageIcon); 
                }
                                    
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        DefaultListModel imageListModel = new DefaultListModel();
        MyImageIcon[] images;

        images = new MyImageIcon[EmployeeView.lodgesList.get(lodgeIndex).imagesList.size()];        
        
        for (int i = 0; i < images.length; i++) {
            ImageIcon subImgIcon;
            
            subImgIcon = new ImageIcon(EmployeeView.lodgesList.get(lodgeIndex).imagesList.get(i).myImage);
            
            MyImageIcon subMyImgIcon = new MyImageIcon(subImgIcon.getImage());
            images[i] = subMyImgIcon;
            double imgWidth = images[i].getIconWidth(),
                    imgHeight = images[i].getIconHeight(),
                    ratio,
                    widthNum;
            
            ratio = imgHeight / 75;
            widthNum = imgWidth / ratio;
            
            if (LoginState.cusBool){
                CustomerView.updatedImageIcon = new MyImageIcon(subImgIcon.getImage().getScaledInstance((int)widthNum, 75, Image.SCALE_SMOOTH));
                images[i] = CustomerView.updatedImageIcon;
            } else if (LoginState.employBool){
                EmployeeView.updatedImageIcon = new MyImageIcon(subImgIcon.getImage().getScaledInstance((int)widthNum, 75, Image.SCALE_SMOOTH));
                images[i] = EmployeeView.updatedImageIcon;
            }            
            
            imageListModel.addElement(images[i]);
            
            if (LoginState.cusBool){
                CustomerView.cvImages.setModel(imageListModel);
                CustomerView.cvImages.setVisible(true);   
            } else if (LoginState.employBool){                
                EmployeeView.evImages.setModel(imageListModel);
                EmployeeView.evImages.setVisible(true);
            }             
        }  
        
        if (LoginState.cusBool){
            CustomerView.returnButton.setEnabled(true);  
            CustomerView.placeOrderButton.setEnabled(true);
        } else if (LoginState.employBool){                
            EmployeeView.returnButton.setEnabled(true);
            EmployeeView.editLodgeButton.setEnabled(true);
            EmployeeView.removeLodgeButton.setEnabled(true);
        }   
    }
}

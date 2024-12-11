/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

/**
 *
 * @author KadeS
 */
import java.awt.Color;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.*;

class Dates extends JPanel {

    JComboBox dayBox, monthBox, yearBox;

    Dates() {
  
        dayBox = new JComboBox();
        monthBox = new JComboBox();
        yearBox = new JComboBox();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        
        
        // populate boxes with dates
        for (int i = currentYear; i < currentYear + 10; i++) {
            yearBox.addItem(i);
        }
        
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < 12; i++) {
            monthBox.addItem(months[i]);
        }
        
        monthBox.setSelectedIndex(currentMonth);
        
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayBox.addItem(i + 1);
        }
        
//        dayBox.setSelectedIndex(currentDay);

        monthBox.addActionListener((e) -> {
       
            //get a temporary  calendar to manipulate
            Calendar c = Calendar.getInstance();
            
            // extract values from the combo boxes.
            int year = Integer.parseInt((String) yearBox.getSelectedItem().toString());
            int month = monthBox.getSelectedIndex();
            int day = Integer.parseInt((String) dayBox.getSelectedItem().toString());

            // set the temp calendar to the extracted values
            c.set(year, month, 1);
            
            // if the selected date in the combobox was too high for the current month, make it the highest valid date instead.
            while (day > c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                day--;
            }
            // clear the day box before repopulating 
            dayBox.removeAllItems();
       
            // repopulate the day box based on the temp calendar.
            for (int i = 0; i < c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                dayBox.addItem(i + 1);
            }
            // set the selected day to what it was or highest possible.
            dayBox.setSelectedIndex(day - 1);
        });
        
        // same as above
        yearBox.addActionListener((e) -> {

            Calendar c = Calendar.getInstance();
            int year = Integer.parseInt((String) yearBox.getSelectedItem().toString());
            int month = monthBox.getSelectedIndex();
            int day = Integer.parseInt((String) dayBox.getSelectedItem().toString());
            c.set(year, month, 1);

            while (day > c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                day--;
            }
    
            
            dayBox.removeAllItems();
   
            for (int i = 0; i < c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                dayBox.addItem(i + 1);
            }
            dayBox.setSelectedIndex(day - 1);
        });

        this.setBounds(0, 0, 200, 40);
        this.setBackground(Color.DARK_GRAY);
        this.add(monthBox);
        this.add(dayBox);
        this.add(yearBox);

    }
    public String toString(){
        String s = monthBox.getSelectedItem().toString() + " " + dayBox.getSelectedItem().toString() + " " + yearBox.getSelectedItem().toString();
        return s;
    }
    
    public LocalDate toNumbers(){
        int month = monthBox.getSelectedIndex() + 1;
        int day = dayBox.getSelectedIndex() + 1;
        int year = Integer.parseInt(yearBox.getSelectedItem().toString());
        
        
        return LocalDate.of(year, month, day);
    }
}

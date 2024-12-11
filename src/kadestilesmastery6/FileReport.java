/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kadestilesmastery6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author KadeS
 */
public class FileReport {
    ResultSet rs;
    ResultSetMetaData md;
    String baseIntro = "<!doctype html><html><body>", 
            title = "",
            baseBody = "",
            baseClose = "</table></body></html>",
            header = "",
            style = "",
            filePath = "";
    
    FileReport(String title, ResultSet rs, String type) throws Exception {
        this.title = title;
        this.rs = rs;
        md = rs.getMetaData();
        setStyle();
        if (type.equals("c")){
            setCustomerHeader();
        } else {
            setEmployeeHeader();
        }
        fillTable();
        buildReport();
    }

    void setStyle() {
        style = "\n<style> table{"
                + "border-collapse: collapse;"
                + "border-block-style: groove;"
                + "margin-left: auto;"
                + "margin-right: auto;}"
                + "th{  background-color: grey;"
                + "padding: 10px;}"
                + "td { padding: 6px;}"
                + "tr:nth-child(odd){background-color: #dee2d6;}"
                + "tr:nth-child(even){background-color: #fcb07e;}"
                + ".TableTitle{"
                + "text-align: center;"
                + "font-weight: bold;"
                + "font-size: 20px;"
                + "}"
                + "</style>\n";
    }

    void setCustomerHeader() throws Exception {
        header = "<div class = TableTitle>" + title + "</div><table><tr>\n";
        header += "<th>Lodge Name</th>";
        header += "<th>Nights Staying</th>";
        header += "<th>Total Spending</th>";
        header += "<th>Start Date</th>";
        header += "</tr>\n";
    }
    
    void setEmployeeHeader() throws Exception {
        header = "<div class = TableTitle>" + title + "</div><table><tr>\n";
        header += "<th>Customer ID</th>";
        header += "<th>Nights Staying</th>";
        header += "<th>Total Spending</th>";
        header += "<th>Start Date</th>";
        header += "</tr>\n";
    }

    // adds rows of table data
    void fillTable() throws Exception {
        
        while (rs.next()) {
            baseBody += "<tr>";
            for (int i = 1; i < md.getColumnCount() + 1; i++) {
                
                if (rs.getString(i).contains(".")){
                   baseBody += "<td>" + String.format("$%.2f", rs.getDouble(i)) + "</td>";
                } else{
                   baseBody += "<td>" + rs.getString(i) + "</td>"; 
                }                
            }
            baseBody += "</tr>\n";
        }
    }

    void buildReport() throws Exception {
        String time = Calendar.getInstance(Locale.getDefault()).getTime().toString();
        time = time.substring(3, 19);
        time = time.replace(" ", "");
        time = time.replace(":", "_");
        System.out.println("Time: " + time);
        String fileName = time + "report.html";
        filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        filePath = filePath + "/Reports/" + fileName;
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        String finalReport = baseIntro + style + header + baseBody + baseClose;
        bw.write(finalReport);
        bw.close();
        System.out.println("Report saved ");
    }
    
    String getFilePath(){
        return filePath;
    }
}


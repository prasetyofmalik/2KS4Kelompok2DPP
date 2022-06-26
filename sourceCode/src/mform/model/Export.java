/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mform.model;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DiVA
 * buat export ke excel dan csv
 */
public class Export {
    
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private BufferedWriter fileWriter;
     
    public void export(JTable table) {
        JFileChooser chooseFile = new JFileChooser();
        chooseFile.showSaveDialog(table);
        File savedFile = chooseFile.getSelectedFile();
        String csvFileName = getFileName(savedFile.toString().concat("_Export"));
         
        try{
            Koneksi connection = new Koneksi();   
            Statement stat = connection.getKoneksi().createStatement();
            String sql  = "Select * from perusahaan";
            ResultSet res   = stat.executeQuery(sql);
             
            fileWriter = new BufferedWriter(new FileWriter(csvFileName));
             
            int columnCount = writeHeaderLine(res);
             
            while (res.next()) {
                String line = "";
                 
                for (int i = 2; i <= columnCount; i++) {
                    Object valueObject = res.getObject(i);
                    String valueString = "";
                     
                    if (valueObject != null) valueString = valueObject.toString();
                     
                    if (valueObject instanceof String) {
                        valueString = "\"" + escapeDoubleQuotes(valueString) + "\"";
                    }
                     
                    line = line.concat(valueString);
                     
                    if (i != columnCount) {
                        line = line.concat(",");
                    }
                }
                 
                fileWriter.newLine();
                fileWriter.write(line);            
            }
             
            stat.close();
            fileWriter.close();
             
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
         
    }
 
    private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.csv", dateTimeInfo));
    }
     
    private int writeHeaderLine(ResultSet result) throws SQLException, IOException {
        // write header line containing column names
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        String headerLine = "";
         
        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            headerLine = headerLine.concat(columnName).concat(",");
        }
         
        fileWriter.write(headerLine.substring(0, headerLine.length() - 1));
         
        return numberOfColumns;
    }
     
    private String escapeDoubleQuotes(String value) {
        return value.replaceAll("\"", "\"\"");
    }
    
    public void saveCSV(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
 
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null && state == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                PrintWriter fileWriter = new PrintWriter(bufferedWriter);
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Object o = model.getValueAt(i, j);
                        String s = (o == null ? "" : String.format("\"%s\"", o.toString()));
                        System.out.print(s);
                        bufferedWriter.write(s);
 
                        if(j < model.getColumnCount() - 1 ){
                            bufferedWriter.write(",");
                        } else {
                            bufferedWriter.write("\r\n");
                        }
                    }
                }
 
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failure");
            }
        }
    }
}

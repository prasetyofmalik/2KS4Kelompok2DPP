/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mform.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DiVA
 * ini buat koneksi ke database
 */
public class Koneksi {
    private Connection koneksi;
 
    public Connection getKoneksi() {
        if (koneksi == null) {
                try {
                    String url = "jdbc:mysql://localhost:3306/dpp";  
                    koneksi = DriverManager.getConnection(url, "root", ""); 
                    System.out.println("Koneksi Database sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal error:" + se);
                    System.exit(0);
                }
        }
        return koneksi;
    }
}

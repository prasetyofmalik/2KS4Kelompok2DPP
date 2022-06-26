/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mform;

import com.mysql.cj.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mform.model.KabKot;
import mform.model.Kecamatan;

/**
 *
 * @author Faqih
 */
public class QueryWilayah {
    
    /**
     * Membangun koneksi database
     * @return koneksi
     */
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/dpp", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    /**
     * Method untuk mendapatkan daftar kab/kota di suatu prov
     * @param provId
     * @return ArrayList<KabKot>
     */
    public ArrayList<KabKot> getKabKot(int provId) {
        ArrayList<KabKot> listKabKot = new ArrayList<KabKot>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            st =  con.createStatement();
            rs = st.executeQuery("SELECT `id`, `name`, `province_id` FROM `regencies` WHERE `province_id` = " + provId );
            KabKot k;
            while (rs.next()) {
                k = new KabKot(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("province_id")
                );  
            listKabKot.add(k);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QueryWilayah.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return listKabKot;  
    }
    
    /**
     * Method untuk mendapatkn kode provinsi
     * @param namaProv
     * @return kodeProv
     */
    public int getProvId(String namaProv) {
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        int id = 1;
        
        try {
            st =  con.createStatement();
            rs = st.executeQuery("SELECT `id`, `name` FROM `provinces` WHERE `name` = '" + namaProv + "'");
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryWilayah.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return id;
  
    }
    /**
     * Method untuk mendapatkan daftar kecamatan di suatu kota
     * @param kabKotId
     * @return ArrayList<Kecamatan>
     */
    public ArrayList<Kecamatan> getKecamatan(int kabKotId) {
        ArrayList<Kecamatan> listKecamatan = new ArrayList<Kecamatan>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            st =  con.createStatement();
            rs = st.executeQuery("SELECT `id`, `name`, `regency_id` FROM `districts` WHERE `regency_id` = " + kabKotId );
            
            Kecamatan k;
            while (rs.next()) {
                k = new Kecamatan(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("regency_id")
                );  
            listKecamatan.add(k);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QueryWilayah.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return listKecamatan; 
    }
    
    /**
     * Method untuk mendapatkan kode kab/kota
     * @param namaKab
     * @return kodeKab
     */
    public int getKabKotId(String namaKab) {
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        int id = 1101;
        
        try {
            st =  con.createStatement();
            rs = st.executeQuery("SELECT `id`, `name` FROM `regencies` WHERE `name` = '" + namaKab + "'");
        
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryWilayah.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return id;
    }
}

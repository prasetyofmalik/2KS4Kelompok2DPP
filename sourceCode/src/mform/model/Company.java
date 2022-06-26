package mform.model;

import java.util.HashMap;

public class Company {
    //Properties
    private int no;
    private KIP kip;
    private String namaPerusahaan;
    private String alamatPerusahaan;
    private String noTelp;
    private String noFax;
    private BadanHukum badanHukum;
    private int isKonfirm;
    private int status;
    private HashMap<String, String> subSektor = new HashMap<>();
    private String usahaUtama; //Inputan di form
    private HashMap<String, String> usahaUtama2 = new HashMap<>(); //Data Usaha Utama
    private String tanamanPangan;
    private String holtikultura;
    private String perkebunan;
    private String peternakan;
    private String kehutanan;
    private String perikanan;

    //Method get set 

    public Company() {
    }
    
    
    public KIP getKIP() {
        return this.kip;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    
    public void setKIP(KIP kip) {
        this.kip = kip;
    }

    public String getNamaPerusahaan() {
        return this.namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getAlamatPerusahaan() {
        return this.alamatPerusahaan;
    }

    public void setAlamatPerusahaan(String alamatPerusahaan) {
        this.alamatPerusahaan = alamatPerusahaan;
    }

    public String getNoTelp() {
        return this.noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    
    public String getNoFax() {
        return this.noFax;
    }

    public void setNoFax(String noFax) {
        this.noFax = noFax;
    }

    public BadanHukum getBadanHukum() {
        return this.badanHukum;
    }

    public void setBadanHukum(BadanHukum badanHukum) {
        this.badanHukum = badanHukum;
    }

    public int isKonfirm() {
        return isKonfirm;
    }

    public void setKonfirm(int konfirm) {
        this.isKonfirm = konfirm;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInputUsahaUtama() {
        return this.usahaUtama;
    }

    public void setInputUsahaUtama(String usahaUtama) {
        this.usahaUtama = usahaUtama;
    }
    
    public HashMap<String,String> getSubsektor() {
        return this.subSektor;
    }

    public void setSubsektor(HashMap<String,String> subSektor) {
        this.subSektor = subSektor;
    }

    public HashMap<String, String> getUsahaUtama() {
        return usahaUtama2;
    }

    public void setUsahaUtama(HashMap<String,String> usahaUtama2) {
        this.usahaUtama2 = usahaUtama2;
    }   

    public String getTanamanPangan() {
        return tanamanPangan;
    }

    public void setTanamanPangan(String tanamanPangan) {
        this.tanamanPangan = tanamanPangan;
    }

    public String getHoltikultura() {
        return holtikultura;
    }

    public void setHoltikultura(String holtikultura) {
        this.holtikultura = holtikultura;
    }

    public String getPerkebunan() {
        return perkebunan;
    }

    public void setPerkebunan(String perkebunan) {
        this.perkebunan = perkebunan;
    }

    public String getPeternakan() {
        return peternakan;
    }

    public void setPeternakan(String peternakan) {
        this.peternakan = peternakan;
    }

    public String getKehutanan() {
        return kehutanan;
    }

    public void setKehutanan(String kehutanan) {
        this.kehutanan = kehutanan;
    }

    public String getPerikanan() {
        return perikanan;
    }

    public void setPerikanan(String perikanan) {
        this.perikanan = perikanan;
    }
    

}

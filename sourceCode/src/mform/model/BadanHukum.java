package mform.model;


public class BadanHukum {
    private int kode;
    private String nama;
    
    public BadanHukum(int kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public BadanHukum() {
        
    }
    
    public int getKode() {
        return this.kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }
    
    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mform.model;

/**
 *
 * @author Faqih
 */
public class Kecamatan {
    private int id;
    private String name;
    private int kabKotId;

    public Kecamatan() {
    }

    public Kecamatan(int id, String name, int kabKotId) {
        this.id = id;
        this.name = name;
        this.kabKotId = kabKotId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKabKotId() {
        return kabKotId;
    }

    public void setKabKotId(int kabKotId) {
        this.kabKotId = kabKotId;
    }
    
    
}

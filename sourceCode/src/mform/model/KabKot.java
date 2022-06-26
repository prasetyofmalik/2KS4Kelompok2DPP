/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mform.model;

/**
 *
 * @author Faqih
 */
public class KabKot {
    private int id;
    private String name;
    private int provId;

    public KabKot() {
    }

    public KabKot(int id, String name, int provId) {
        this.id = id;
        this.name = name;
        this.provId = provId;
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

    public int getProvId() {
        return provId;
    }

    public void setProvId(int provId) {
        this.provId = provId;
    }
    
    

    
}

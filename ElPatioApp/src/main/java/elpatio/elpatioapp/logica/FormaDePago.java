/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpatio.elpatioapp.logica;

/**
 *
 * @author Leo
 */
public class FormaDePago {
    
    private int id;
    private String formaDePago;

    public FormaDePago() {
    }

    public FormaDePago(int id, String formaDePago) {
        this.id = id;
        this.formaDePago = formaDePago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }
    
    
    
}

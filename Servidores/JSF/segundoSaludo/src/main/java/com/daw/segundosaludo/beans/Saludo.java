/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.segundosaludo.beans;

/**
 *
 * @author Usuario
 */
public class Saludo {

    /**
     * Creates a new instance of Saludo
     */
    private String usuario;
    private String contra;
    public Saludo() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String validarClave() {
        if (contra.equals("daw"))
        return "ir";
        else
        return "error";
    }
    
}

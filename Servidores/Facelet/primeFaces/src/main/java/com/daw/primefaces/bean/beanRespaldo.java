/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.primefaces.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "respaldo")
@RequestScoped
public class beanRespaldo {

    /**
     * Creates a new instance of beanRespaldo
     */
    private String color;
    
    public beanRespaldo() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void verColor(){
        
    }
    
}

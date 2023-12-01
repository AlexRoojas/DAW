/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.pojos;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author kete
 */
@Named(value = "email1")
@Dependent
public class Email {

    /**
     * Creates a new instance of Email
     */
    
    private String extension;
    private String dominio;
    
    public Email() {
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    @Override
    public String toString() {
        return "Email{" + "extension=" + extension + ", dominio=" + dominio + '}';
    }
    
}

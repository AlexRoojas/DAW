/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.formuvalidacion;

import com.daw.pojos.Email;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author kete
 */
public class converterEmail implements Converter{

    /**
     * Creates a new instance of converterEmail
     */
    public converterEmail() {
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Email email = new Email();
        
        String valores [] = string.split("@");
        String fina[] = valores[2].split(".");
        
        if(valores.length!=2){
            throw new ConverterException(new FacesMessage("Formato incorrecto, falta el dominio"));
        }
        if(valores[1].length()>=10){
            throw new ConverterException(new FacesMessage("Formato dominio muy largo"));
        }
        if(fina.length!=2){
            throw new ConverterException(new FacesMessage("Falta el .com o .es"));
        }
        
        email.setDominio(valores[0]);
        email.setExtension(valores[1]);
        
        return email;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

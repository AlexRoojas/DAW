/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.formuvalidacion;

import com.daw.pojos.Nif;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author kete
 */
public class converterNif implements Converter{

    /**
     * Creates a new instance of converterNif
     */
    public converterNif() {
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        
        Nif nif = new Nif();
        
        String valores[] = string.split("-");
        
        if(valores.length!=2){
            throw new ConverterException(new FacesMessage("Formato incorrecto, falta la letra"));
        }
        if(valores[0].length()!=8){
            throw new ConverterException(new FacesMessage("Formato incorrecto, necesitas 8 Dígitos"));
        }
        String[] letras = new String[]{"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int numero = Integer.parseInt(valores[0]);
        int resto = numero%23;
        String letra = letras[resto];
        
        
        
        nif.setNumero(numero);
        nif.setLetra(letra);
        
        return nif;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}

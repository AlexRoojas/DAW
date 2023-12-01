/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Usuario
 */
public class validaNif implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        
        String[] nifSplit=o.toString().split("-");
             
             if(nifSplit[0].length()==0){
                 throw new ConverterException(new FacesMessage("Añade números")); 
             }
             
             if(nifSplit[1].length()==0){
                throw new ConverterException(new FacesMessage("Falta una letra")); 
             }
             
             if(nifSplit[0].length()==8 && nifSplit[1].length()==1){
                 int num=Integer.parseInt(nifSplit[0]);
                 
                 int resto=num%23;
                 
                 String letraComprobar=letras[resto];
                 
                 if(!letraComprobar.equals(nifSplit[1])){
                     throw new ValidatorException(new FacesMessage("La letra del nif : "+num+" , es incorrecta, la correcta es: "+letraComprobar)); 
                 }
             }
        
        
    }
    
}

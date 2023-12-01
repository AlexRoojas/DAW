/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.POJOS;

import com.mycompany.RESPALDO.Nif;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Usuario
 */
public class NifConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String valorComponente) {
       
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        
        Nif nifValidado=null;
        
       // if(!StringUtils.isEmpty(valorComponente)){
        
             nifValidado=new Nif();
            
             String valoresNif[]=valorComponente.split("-");
             
             if(valoresNif[0].length()==0){
                 throw new ConverterException(new FacesMessage("El Nif debe tener numeros")); 
             }else if(valoresNif[0].length()<8){
                 throw new ConverterException(new FacesMessage("El Nif debe tener 8 digitos")); 
             }
             
             if(valoresNif[1].length()==0){
                throw new ConverterException(new FacesMessage("El Nif debe tener una letra")); 
             }else if(valoresNif[1].length()>1){
                throw new ConverterException(new FacesMessage("El Nif debe tener como maximo una letra")); 
             }
             
             if(valoresNif[0].length()==8 && valoresNif[1].length()==1){
                 int numerosAComprobarLetra=Integer.parseInt(valoresNif[0]);
                 
                 int resto=numerosAComprobarLetra%23;
                 
                 String letraComprobar=letras[resto];
                 
                 if(!letraComprobar.equals(valoresNif[1])){
                     throw new ConverterException(new FacesMessage("La letra del nif : "+numerosAComprobarLetra+" , es incorrecta, la correcta es: "+letraComprobar)); 
                 }else{
                    nifValidado.setNumeros(numerosAComprobarLetra);
                    nifValidado.setLetra(letraComprobar);
                 }
             }
                   
        
        //}
        
        return nifValidado;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
      return o.toString();
    }
    

       
    
}

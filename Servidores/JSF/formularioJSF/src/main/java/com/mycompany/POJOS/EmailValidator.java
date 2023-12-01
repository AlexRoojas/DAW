package com.mycompany.POJOS;


 

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;

import javax.faces.validator.ValidatorException;


 

import org.apache.commons.lang.StringUtils;


 

/**

 * Validador de NIF

 * @author AUTENTIA

 */

public class EmailValidator implements Validator{

            /**

             * Efectúa el proceso de validación

             */

                public void validate(FacesContext context,UIComponent component, Object value) throws ValidatorException {
      
                String email = value.toString();

                if(!email.matches("((?=(.*[a-z]))?)((?=(.*[A-Z]))?)((?=(.*[0-9]))?)[a-zA-Z\\d?]{4,}\\@[a-z]{2,}\\.[a-z]{2,}")){
                    throw new ValidatorException(new FacesMessage("El  email debe cumplir con el formato: minimo 4 caracteres, @, dominio y extension"));
                }                        
            }

}
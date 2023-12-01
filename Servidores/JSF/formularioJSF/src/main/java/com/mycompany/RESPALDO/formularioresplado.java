/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RESPALDO;

import com.mycompany.POJOS.EmailValidator;
import com.mycompany.POJOS.NifConverter;

/**
 *
 * @author Usuario
 */
public class formularioresplado {

    /**
     * Creates a new instance of formularioresplado
     */
    
    
    private Nif nif;
    private String email;
    
    
    public formularioresplado() {
        
    }

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
  
        this.email = email;
    }
    

    @Override
    public String toString() {
        return "formularioresplado{" + "nif=" + nif + ", email=" + email + '}';
    }

    
    
}

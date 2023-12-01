/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.beans;

import com.daw.seneca2dawalexrojas.DTO.Profesor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean(name="beanRespaldo")
@SessionScoped
public class beanRespaldo {

    /**
     * Creates a new instance of beanRespaldo
     */
    private Profesor profe;
    
    public beanRespaldo() {
    }

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }
    
}

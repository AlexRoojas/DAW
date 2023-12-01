/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author kete
 */
@Named(value = "beanRespaldo")
@SessionScoped
public class beanRespaldo implements Serializable {

    /**
     * Creates a new instance of beanRespaldo
     */
    public beanRespaldo() {
    }
    
}

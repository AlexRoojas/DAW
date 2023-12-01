/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.beans;

import com.mycompany.floristeriadefinitiva.DTO.Usuarios;
import static com.mycompany.floristeriadefinitiva.beans.beanFlore.redireccionar;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    
    private Usuarios miUsu;
    private boolean isOk;
    private String titulo;
    
    public beanRespaldo() {
        titulo="Bienvenido a la Tienda Online";
    }

    

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }
    
    

    public Usuarios getMiUsu() {
        return miUsu;
    }

    public void setMiUsu(Usuarios miUsu) {
        this.miUsu = miUsu;
    }
    
    public String getComprueba() {
        if(miUsu == null){
            redireccionar("login.jsp");
        }
        
        return titulo;
        
    }
    
    public String saludadcioasd(){
        if(miUsu == null){
            redireccionar("login.jsp");
        }
        return "La mamá de la mamá De la mamá de la mamá De la mamá de la mamá";
    }

    public static void redireccionar(String url){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
       
        try {
            ctx.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(beanRespaldo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void logout(String url){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        try {
            ((HttpSession)ctx.getSession(true)).invalidate();
            ctx.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(beanRespaldo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

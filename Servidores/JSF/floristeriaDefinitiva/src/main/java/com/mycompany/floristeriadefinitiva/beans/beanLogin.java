/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.beans;

import com.mycompany.floristeriadefinitiva.DAO.UsuariosJpaController;
import com.mycompany.floristeriadefinitiva.DTO.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kete
 */

@ManagedBean(name="beanLog")
@RequestScoped

public class beanLogin{

    /**
     * Creates a new instance of beanLogin
     */
    
    UsuariosJpaController ctrlUsu;
    
    private String contra;
    private String usuario;
    private String dni;
    private String error;
    private boolean isOk;
    
    private Usuarios miUsuario;
    
    public beanLogin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_floristeriaDefinitiva_war_1.0-SNAPSHOTPU");
        ctrlUsu = new UsuariosJpaController(emf);
        
        contra="";
        usuario="";
        dni="";
        error="";
        
        isOk=false;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Usuarios getMiUsuario() {
        return miUsuario;
    }

    public void setMiUsuario(Usuarios miUsuario) {
        this.miUsuario = miUsuario;
    }

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }
    
    
    
    
    public String compruebaUsu(){
        List usu = ctrlUsu.buscarUsuario(usuario, contra);
       
        if(usu.size()>0){
            
            miUsuario = (Usuarios) usu.get(0);
            isOk=true;
            
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession sesion = (HttpSession)ctx.getSession(true);
            beanRespaldo b = new beanRespaldo();
            b.setMiUsu(miUsuario);
            b.setIsOk(isOk);
            sesion.setAttribute("beanRespaldo", b);
            
            return "ir";
        }
        return error = "Error Usuario Y Contraseña Invalidos";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.beans;

import com.daw.seneca2dawalexrojas.DAO.ProfesorJpaController;
import com.daw.seneca2dawalexrojas.DTO.Profesor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */

@ManagedBean(name="beanLoge")
@RequestScoped
public class beanLogin {

    ProfesorJpaController ctrlProfe;
    
    private Profesor miProfe;
    
    private String nombre;
    private String contra;
    private String error;
    
    public beanLogin() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.2daw_seneca2dawAlexRojas_war_1.0-SNAPSHOTPU");
        ctrlProfe = new ProfesorJpaController(emf);
        
        nombre="";
        contra="";
        error="";
    }

    public Profesor getMiProfe() {
        return miProfe;
    }

    public void setMiProfe(Profesor miProfe) {
        this.miProfe = miProfe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public String compruebaProf(){
        List prof = ctrlProfe.buscarProfe(nombre, contra);
        
       
        if(prof.size()>0){
            
            miProfe = (Profesor)prof.get(0);
            
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession sesion = (HttpSession)ctx.getSession(true);
            beanRespaldo b = new beanRespaldo();
            b.setProfe(miProfe);
            sesion.setAttribute("beanRespaldo", b);
            
            return "ir";
        }
        return error = "Error Usuario Y Contraseña Invalidos";
    }
    
    
}

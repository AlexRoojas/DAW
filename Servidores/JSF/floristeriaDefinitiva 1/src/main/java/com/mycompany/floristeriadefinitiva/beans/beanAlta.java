/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.beans;

import com.mycompany.floristeriadefinitiva.DAO.FloresJpaController;
import com.mycompany.floristeriadefinitiva.DTO.Flores;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Part;

/**
 *
 * @author kete
 */
@ManagedBean(name="beanAlta")
@RequestScoped
public class beanAlta {

    /**
     * Creates a new instance of beanAlta
     */
    
    private int codFlor;
    private String nombreCom;
    private String nombreCi;
    private int codLuzFlor;
    private int precio;
    private int uniVendidas;
    private String imagenFlor;
    private int codLuzSel2;
    
    private Part[] archivo;
    
    FloresJpaController ctrlFlor;
    
    public beanAlta() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_floristeriaDefinitiva_war_1.0-SNAPSHOTPU");
        ctrlFlor = new FloresJpaController(emf);
        archivo = new Part[1];
    }

    public Part[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Part[] archivo) {
        this.archivo = archivo;
    }

    
    
    public int getCodFlor() {
        return codFlor;
    }

    public void setCodFlor(int codFlor) {
        this.codFlor = codFlor;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    public String getNombreCi() {
        return nombreCi;
    }

    public void setNombreCi(String nombreCi) {
        this.nombreCi = nombreCi;
    }

    public int getCodLuzFlor() {
        return codLuzFlor;
    }

    public void setCodLuzFlor(int codLuzFlor) {
        this.codLuzFlor = codLuzFlor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUniVendidas() {
        return uniVendidas;
    }

    public void setUniVendidas(int uniVendidas) {
        this.uniVendidas = uniVendidas;
    }

    public String getImagenFlor() {
        return imagenFlor;
    }

    public void setImagenFlor(String imagenFlor) {
        this.imagenFlor = imagenFlor;
    }

    public int getCodLuzSel2() {
        return codLuzSel2;
    }

    public void setCodLuzSel2(int codLuzSel2) {
        this.codLuzSel2 = codLuzSel2;
    }
    
    
    
    public String altaFlor(){
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        String imagen = archivo[0].getSubmittedFileName();
        String ruta = contexto.getExternalContext().getRealPath("/flores");
        
        try {
            InputStream input = archivo[0].getInputStream();
            
            Files.copy(input, new File(ruta, imagen).toPath());
        } catch (IOException ex) {
            Logger.getLogger(beanAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        Flores nuevaFlor = new Flores(null,nombreCom,nombreCi,codLuzSel2,precio,uniVendidas,imagen);
        
        ctrlFlor.create(nuevaFlor);
        
        return "volver";
    }
    
}

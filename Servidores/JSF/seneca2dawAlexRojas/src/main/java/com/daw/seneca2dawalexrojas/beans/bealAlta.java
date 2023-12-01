/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.beans;

import com.daw.seneca2dawalexrojas.DAO.AlumnoJpaController;
import com.daw.seneca2dawalexrojas.DAO.CursosJpaController;
import com.daw.seneca2dawalexrojas.DTO.Alumno;
import com.daw.seneca2dawalexrojas.DTO.Cursos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Part;

/**
 *
 * @author Usuario
 */

@ManagedBean(name="beanAlta")
@RequestScoped
public class bealAlta {

    /**
     * Creates a new instance of bealAlta
     */
    private String dni;
    private String nomApe;
    private String localidad;
    private int idCurso;
    private String img;
    
    private Part[] archivo;
    
    CursosJpaController ctrlCurso;
    AlumnoJpaController ctrlAlum;
    
    public bealAlta() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.2daw_seneca2dawAlexRojas_war_1.0-SNAPSHOTPU");
        ctrlCurso = new CursosJpaController(emf);
        ctrlAlum = new AlumnoJpaController(emf);
        dni="";
        nomApe="";
        localidad="";
        idCurso=0;
        img="";
        
        archivo = new Part[1];
    }

    public Part[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Part[] archivo) {
        this.archivo = archivo;
    }

    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomApe() {
        return nomApe;
    }

    public void setNomApe(String nomApe) {
        this.nomApe = nomApe;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    public ArrayList listaCursos(){
        
        ArrayList listaL = new ArrayList();
        
        List<Cursos> listaC =  ctrlCurso.findCursosEntities();
        
        for(Cursos cu : listaC){
            listaL.add(new SelectItem(cu.getIdCurso(),cu.getNomCursos()));
        }
        
        return listaL;
    }
    
    public String altaAlum(){
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        String imagen = archivo[0].getSubmittedFileName();
        String ruta = contexto.getExternalContext().getRealPath("/flores");
        
        try {
            InputStream input = archivo[0].getInputStream();
            
            Files.copy(input, new File(ruta, imagen).toPath());
        } catch (IOException ex) {
            
        }
        
        
        Alumno nuevoAlum = new Alumno(null,dni,nomApe,localidad,idCurso,imagen);
        
        ctrlAlum.create(nuevoAlum);
        
        /*Flores nuevaFlor = new Flores(null,nombreCom,nombreCi,codLuzSel2,precio,uniVendidas,imagen);
        
        ctrlFlor.create(nuevaFlor);*/
        
        return "volver";
    }
    
}

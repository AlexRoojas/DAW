/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.beans;

import com.mycompany.floristeriadefinitiva.DAO.CarritoJpaController;
import com.mycompany.floristeriadefinitiva.DAO.FloresJpaController;
import com.mycompany.floristeriadefinitiva.DAO.LuzJpaController;
import com.mycompany.floristeriadefinitiva.DAO.UsuariosJpaController;
import com.mycompany.floristeriadefinitiva.DAO.VistadetalleJpaController;
import com.mycompany.floristeriadefinitiva.DAO.exceptions.NonexistentEntityException;
import com.mycompany.floristeriadefinitiva.DTO.Carrito;
import com.mycompany.floristeriadefinitiva.DTO.CarritoPK;
import com.mycompany.floristeriadefinitiva.DTO.Flores;
import com.mycompany.floristeriadefinitiva.DTO.Luz;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kete
 */

@ManagedBean(name="beanFlor")
@ViewScoped

public class beanFlore {

    LuzJpaController ctrlLuz;
    FloresJpaController ctrlFlor;
    UsuariosJpaController ctrlUsu;
    CarritoJpaController ctrlCarro;
    VistadetalleJpaController ctrlVista;
    
    private int codLuzSel;
    private int codLuzSel2;
    private String florDetalle;
    private String miImagen;
    private String infoFlor;
    private int posActual;
    
    private boolean mostrarMenosZoom;
    private boolean mostrarZoom;
    
    private ArrayList arrayFlores;      
    private ArrayList listaFlor;
    
    private HtmlGraphicImage laFoto;
    
    @ManagedProperty(value = "#{beanLog}")
    private beanLogin loguinRespaldo;
    
    public beanFlore() {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_floristeriaDefinitiva_war_1.0-SNAPSHOTPU");
        ctrlLuz = new LuzJpaController(emf);
        ctrlFlor = new FloresJpaController(emf);
        ctrlUsu = new UsuariosJpaController(emf);
        ctrlCarro = new CarritoJpaController(emf);
        ctrlVista = new VistadetalleJpaController(emf);
        
        florDetalle = "";
        miImagen = "";
        arrayFlores = new ArrayList();
        posActual = 0;
        infoFlor="";
        mostrarMenosZoom=true;
        mostrarZoom=true;
        
    }

    public beanLogin getLoguinRespaldo() {
        return loguinRespaldo;
    }

    public void setLoguinRespaldo(beanLogin loguinRespaldo) {
        this.loguinRespaldo = loguinRespaldo;
    }

    
    
    public int getCodLuzSel() {
        return codLuzSel;
    }

    public void setCodLuzSel(int codLuzSel) {
        this.codLuzSel = codLuzSel;
    }

    public int getCodLuzSel2() {
        return codLuzSel2;
    }

    public void setCodLuzSel2(int codLuzSel2) {
        this.codLuzSel2 = codLuzSel2;
    }

    public String getFlorDetalle() {
        return florDetalle;
    }

    public void setFlorDetalle(String florDetalle) {
        this.florDetalle = florDetalle;
    }

    public String getMiImagen() {
        return miImagen;
    }

    public void setMiImagen(String miImagen) {
        this.miImagen = miImagen;
    }

    public String getInfoFlor() {
        return infoFlor;
    }

    public void setInfoFlor(String infoFlor) {
        this.infoFlor = infoFlor;
    }

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    public boolean isMostrarMenosZoom() {
        return mostrarMenosZoom;
    }

    public void setMostrarMenosZoom(boolean mostrarMenosZoom) {
        this.mostrarMenosZoom = mostrarMenosZoom;
    }

    public boolean isMostrarZoom() {
        return mostrarZoom;
    }

    public void setMostrarZoom(boolean mostrarZoom) {
        this.mostrarZoom = mostrarZoom;
    }

    public ArrayList getArrayFlores() {
        return arrayFlores;
    }

    public void setArrayFlores(ArrayList arrayFlores) {
        this.arrayFlores = arrayFlores;
    }

    public ArrayList getListaFlor() {
        return listaFlor;
    }

    public void setListaFlor(ArrayList listaFlor) {
        this.listaFlor = listaFlor;
    }

    public HtmlGraphicImage getLaFoto() {
        return laFoto;
    }

    public void setLaFoto(HtmlGraphicImage laFoto) {
        this.laFoto = laFoto;
    }
    
    
    
    //-----METODOS---------------
    public ArrayList listaLuz(){
        
        ArrayList listaL = new ArrayList();
        
        List<Luz> listaLuzEntera =  ctrlLuz.findLuzEntities();
        
        for(Luz lu : listaLuzEntera){
            listaL.add(new SelectItem(lu.getCodigoLuz(),(lu.getTipoLuz()+" -- "+lu.getAgua())));
        }
        
        return listaL;
    }
    
    public void cambiaFlores (ValueChangeEvent event){
        int miCod = (int) event.getNewValue();
        
        
        List<Flores> listaFlores = ctrlFlor.getListaFloresCod(miCod);
        
        
        Luz lu = ctrlLuz.findLuz(miCod);
        
        florDetalle = lu.getTipoLuz() + " Agua: "+lu.getAgua()+ " - "+listaFlores.size()+ " ejemplares.";
        
        
        Flores flor = ctrlFlor.findFlores(miCod);
        
        miImagen = flor.getImagen();
        
        arrayFlores.clear();
        
        for(Flores flo : listaFlores){
            arrayFlores.add(flo);
        }
        
    } 
    
    public void avanza(){
        int tamaño = arrayFlores.size();
        
        if(tamaño>posActual){
            posActual++;
            
        }else{
            posActual=0;
        }
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        miImagen = floo.getImagen();
    }
    
    public void retrocede(){
        int tamaño = arrayFlores.size();
        if(tamaño >= 0){
            
        
        if(posActual==0){
            
           posActual=tamaño-1;
        }else{
           posActual--;
        }
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        miImagen = floo.getImagen();
        }
        
    }
    
    public void menoszoom(){
        laFoto.setStyle("width:100px");
        mostrarZoom=true;
        mostrarMenosZoom=false;
    }
    
    public void maszoom(){
        laFoto.setStyle("width:800px");
        mostrarZoom=false;
        mostrarMenosZoom=true;
    }
    
    public void rest(){
        laFoto.setStyle("width: 500px");
        mostrarZoom=true;
        mostrarMenosZoom=true;
    }
    
    public void borrarImagen(){
        
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        arrayFlores.remove(posActual);
        
        
        try {
            ctrlFlor.destroy(floo.getCodigoFlor());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(beanFlore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void info(){
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        infoFlor = floo.getNombreComun() + " - " +floo.getNombreCientifico() + " cuesta " +floo.getPrecio()+ "€";
    }
    
    
    public void alcarro(){
        
        
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        String dni = loguinRespaldo.getMiUsuario().getDniusuario();
        
        CarritoPK cPK = new CarritoPK(dni,floo.getCodigoFlor());
        
        Carrito miCarro = ctrlCarro.findCarrito(cPK);
        int uni = miCarro.getUnidades();
        
        if (miCarro == null){
            miCarro = new Carrito(cPK, 1, floo.getPrecio());
            try {
                ctrlCarro.create(miCarro);
            } catch (Exception ex) {
                Logger.getLogger(beanFlore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            uni++;
            miCarro = new Carrito(cPK, uni, floo.getPrecio());
            try {
                ctrlCarro.edit(miCarro);
            } catch (Exception ex) {
                Logger.getLogger(beanFlore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

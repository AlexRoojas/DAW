/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeria.beans;

import com.mycompany.floristeria.DAO.CarritoJpaController;
import com.mycompany.floristeria.DAO.FloresJpaController;
import com.mycompany.floristeria.DAO.LuzJpaController;
import com.mycompany.floristeria.DAO.UsuariosJpaController;
import com.mycompany.floristeria.DAO.VistadetalleJpaController;
import com.mycompany.floristeria.DAO.exceptions.NonexistentEntityException;
import com.mycompany.floristeria.DTO.Carrito;
import com.mycompany.floristeria.DTO.CarritoPK;
import com.mycompany.floristeria.DTO.Flores;
import com.mycompany.floristeria.DTO.Luz;
import com.mycompany.floristeria.DTO.Usuarios;
import com.mycompany.floristeria.DTO.Vistadetalle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kete
 */
public class beanFlores {

    /**
     * Creates a new instance of beanFlores
     */
    
    LuzJpaController ctrlLuz;
    FloresJpaController ctrlFlor;
    UsuariosJpaController ctrlUsu;
    CarritoJpaController ctrlCarro;
    VistadetalleJpaController ctrlVista;
    
    //private HashMap<Integer,Flores> mapFlores = new HashMap<>();
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
    
    
    private String contra;
    private String usuario;
    private String dni;
    private String error;
    
    private int codFlor;
    private String nombreCom;
    private String nombreCi;
    private int codLuzFlor;
    private int precio;
    private int uniVendidas;
    private String imagenFlor;
    
    
    private int cantidad;
    
    public beanFlores() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("flor");
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
        cantidad = 0;
        dni="";
    }

    public int getCodLuzSel() {
        return codLuzSel;
    }

    public void setCodLuzSel(int codLuzSel) {
        this.codLuzSel = codLuzSel;
    }


    public String getDni() {
        return dni;
    }

    /*public HashMap<Integer, Flores> getMapFlores() {
    return mapFlores;
    }
    public void setMapFlores(HashMap<Integer, Flores> mapFlores) {
    this.mapFlores = mapFlores;
    }*/
    public void setDni(String dni) {
        this.dni = dni;
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

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    public HtmlGraphicImage getLaFoto() {
        return laFoto;
    }

    public void setLaFoto(HtmlGraphicImage laFoto) {
        this.laFoto = laFoto;
    }

    public String getInfoFlor() {
        return infoFlor;
    }

    public void setInfoFlor(String infoFlor) {
        this.infoFlor = infoFlor;
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
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        
        if(posActual==0){
            
           posActual=tamaño-1;
        }else{
           posActual--;
        }
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        miImagen = floo.getImagen();
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
            Logger.getLogger(beanFlores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void info(){
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        infoFlor = floo.getNombreComun() + " - " +floo.getNombreCientifico() + " cuesta " +floo.getPrecio()+ "€";
    }
    
    public String compruebaUsu(){
        List usu = ctrlUsu.buscarUsuario(usuario, contra);
        
        Usuarios miUsu = (Usuarios) usu.get(0);
        
        dni = miUsu.getDniusuario();
        
        if(usu.size()>0){
            return "ir";
        }
        return error = "Error Usuario Y Contraseña Invalidos";
    }
    

    
    public String altaFlor(){
        
        Flores nuevaFlor = new Flores(null,nombreCom,nombreCi,codLuzSel2,precio,uniVendidas,nombreCom+".jpg");
        
        ctrlFlor.create(nuevaFlor);
        
        return "volver";
    }
    
    public void alcarro(){
        
        
        Flores floo = (Flores) arrayFlores.get(posActual);
        
        CarritoPK cPK = new CarritoPK(dni,floo.getCodigoFlor());
        
        Carrito miCarro = ctrlCarro.findCarrito(cPK);
        int uni = miCarro.getUnidades();
        
        if (miCarro == null){
            miCarro = new Carrito(cPK, 1, floo.getPrecio());
            try {
                ctrlCarro.create(miCarro);
            } catch (Exception ex) {
                Logger.getLogger(beanFlores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            uni++;
            miCarro = new Carrito(cPK, uni, floo.getPrecio());
            try {
                ctrlCarro.edit(miCarro);
            } catch (Exception ex) {
                Logger.getLogger(beanFlores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public List<Vistadetalle> cargaDetalle(){
        
        List<Vistadetalle> listaLuzEntera =  ctrlVista.buscarDetalle(dni);
        
        
        return listaLuzEntera;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.traductor.beans;

import com.daw.traductor.DAO.DiccionarioJpaController;
import com.daw.traductor.DAO.EnglishJpaController;
import com.daw.traductor.DAO.SpanishJpaController;
import com.daw.traductor.DTO.Diccionario;
import com.daw.traductor.DTO.DiccionarioPK;
import com.daw.traductor.DTO.English;
import com.daw.traductor.DTO.Spanish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class beanTraductor {

    /**
     * Creates a new instance of beanTraductor
     */
    private String idioma;
    
    SpanishJpaController ctrlSpanish;
    EnglishJpaController ctrlEng;
    DiccionarioJpaController ctrlDicc;
    
    private int codPalES;
    private int codPalEN;
    private Spanish espa;
    //private HashMap <Integer,> diccionario;
    
    private ArrayList listaPalabrasInglesSel;
    
    private String palabraEntera;
    private String fraseEspa;
    
    public beanTraductor() {
        listaPalabrasInglesSel = new ArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("disionario"); 
        ctrlSpanish = new SpanishJpaController(emf);
        ctrlEng = new EnglishJpaController(emf);
        ctrlDicc = new DiccionarioJpaController(emf);
        palabraEntera="";
        fraseEspa="";
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public int getCodPalES() {
        return codPalES;
    }

    public void setCodPalES(int codPalES) {
        this.codPalES = codPalES;
    }
    
    public int getCodPalEN() {
        return codPalEN;
    }

    public void setCodPalEN(int codPalEN) {
        this.codPalEN = codPalEN;
    }
    
    public ArrayList getListaPalabrasInglesSel() {
        return listaPalabrasInglesSel;
    }

    public void setListaPalabrasInglesSel(ArrayList listaPalabrasInglesSel) {
        this.listaPalabrasInglesSel = listaPalabrasInglesSel;
    }
    
    public Spanish getEspa() {
        return espa;
    }

    public void setEspa(Spanish espa) {
        this.espa = espa;
    }
    
    public String getPalabraEntera() {
        return palabraEntera;
    }

    public void setPalabraEntera(String palabraEntera) {
        this.palabraEntera = palabraEntera;
    }
    
    public String getFraseEspa() {
        return fraseEspa;
    }

    public void setFraseEspa(String fraseEspa) {
        this.fraseEspa = fraseEspa;
    }
    
    //METODOS------------------------------------

    

    

    
    
    
    public void cambioIdioma(ValueChangeEvent evento) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if (evento.getNewValue().equals("usa")) {
            contexto.getViewRoot().setLocale(Locale.US);
        } else {
            contexto.getViewRoot().setLocale(Locale.getDefault());
        }
        
    }
    public void esss() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getViewRoot().setLocale(Locale.getDefault());
    }
    public void ingle() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getViewRoot().setLocale(Locale.US);
    }
    
    
    //LISTA----------
    public ArrayList listaPalabras(){
        
        ArrayList listaP = new ArrayList();
        
        List<Spanish> listaPalabras =  ctrlSpanish.getListaPalabras();
        
        for(Spanish spa : listaPalabras){
            listaP.add(new SelectItem(spa.getCodPal(),spa.getPalabra()));
        }
        
        return listaP;
    }
    
    
    

    public void listaPalEng(ValueChangeEvent event){
        
        int miCod = (int) event.getNewValue();
        
        listaPalabrasInglesSel.clear();
        event.getNewValue();
        
        listaPalabrasInglesSel.add(new SelectItem("",""));
        
        //List<Diccionario> listaCodEn =  ctrlDicc.getListaPalEngEsp(miCod);
        List<Diccionario> listaCodEn =  ctrlDicc.listaIngles(miCod);
        
        for(Diccionario dc : listaCodEn){
            English engl = ctrlEng.findEnglish(dc.getDiccionarioPK().getCodpalIn());
            listaPalabrasInglesSel.add(new SelectItem(engl.getCodPal(),(engl.getPalabra()+" -- "+engl.getComentario())));
        }
        
        
    }
    
    public void addPalabra(ValueChangeEvent event){
        
        String palabra =(ctrlSpanish.findSpanish(codPalES)).getPalabra();
        
        fraseEspa+= " " +palabra;
        int codEng = (int) event.getNewValue();
        
        English ingle = ctrlEng.findEnglish(codEng);
        
        palabraEntera+= " "+ ingle.getPalabra();
    }

    public void limpiaUltimo(){
        int pos;
        
        palabraEntera = palabraEntera.trim();
        
        pos = palabraEntera.lastIndexOf(" ");
        
        if (pos != -1) {
            palabraEntera = palabraEntera.substring(0, pos);
        } else {
            palabraEntera = "";
        }
        
    }

    
    
}

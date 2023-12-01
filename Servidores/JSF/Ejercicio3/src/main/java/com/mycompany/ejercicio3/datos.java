/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio3;

import java.util.ArrayList;
import javax.faces.model.SelectItem;

/**
 *
 * @author kete
 */
public class datos {

    /**
     * Creates a new instance of datos
     */
    
    private String nombre;
    private String motivo;
    private String[] comprension;
    private String ponente;
    private String razon;
    private String sistema;
    private String[] lenguajes;
    private String[] aficiones;
    
    private ArrayList listaMotivos = null;
    private ArrayList listaComprension = null;
    
    public datos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String[] getComprension() {
        return comprension;
    }

    public void setComprension(String[] comprension) {
        this.comprension = comprension;
    }

    public String getPonente() {
        return ponente;
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String[] getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String[] lenguajes) {
        this.lenguajes = lenguajes;
    }

    public String[] getAficiones() {
        return aficiones;
    }

    public void setAficiones(String[] aficiones) {
        this.aficiones = aficiones;
    }
    
    
    //Listas y hay dos formas de rellenarlos
    
    public ArrayList getListaMotivos() {
        if (listaMotivos == null) {
            
            listaMotivos = new ArrayList();
            listaMotivos.add(new SelectItem("nuevas_capacidades", "Adquirir nuevos conocimientos"));
            listaMotivos.add(new SelectItem("impartir_modulo", "El próximo curso impartiré este módulo"));
            listaMotivos.add(new SelectItem("aumentar_puntos", "Aumentar mis puntos"));
            listaMotivos.add(new SelectItem("vida_social", "Hacer vida social"));
        }
        return listaMotivos;
    }

    public ArrayList getListaComprension() {
        if (listaComprension == null) {
            
            listaComprension = new ArrayList();
            listaComprension.add(new SelectItem("facil", "Fácil"));
            listaComprension.add(new SelectItem("normal", "Normal"));
            listaComprension.add(new SelectItem("dificil", "Difícil"));
            listaComprension.add(new SelectItem("pronto", "Aún es pronto"));
        }
        return listaComprension;
    }

    public ArrayList getListaSistemas() {
        ArrayList lista = new ArrayList();
        
        lista.add(new SelectItem("winxp", "Windows XP"));
        lista.add(new SelectItem("win7", "Windows 7"));
        lista.add(new SelectItem("ubuntu", "Ubuntu"));
        lista.add(new SelectItem("mac", "Mac OS"));
        
        return lista;
    }

    public ArrayList getListaLenguajes() {
        ArrayList lista = new ArrayList();
        
        lista.add(new SelectItem("delphi", "Delphi"));
        lista.add(new SelectItem("c++", "C++"));
        lista.add(new SelectItem("cs", "C#"));
        lista.add(new SelectItem("java", "Java"));
        lista.add(new SelectItem("visualbasic", "Visual Basic"));
        
        return lista;
    }
    
    public String getSecComprension() {
        return concatenar(comprension);
    }

    public String getSecLenguajes() {
        return concatenar(lenguajes);
    }

    public String getSecAficiiones() {
        return concatenar(aficiones);
    }
// Utilidad para "concatenar" enun String un array de String(String[]):
public String concatenar(String[] a) {
        String sal = "";
        for (String s : a) {
            sal += (s + ", ");
        }
        return sal.substring(0, sal.length()
                - 2);
    }

    
    
}

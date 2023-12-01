/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.BD;

public class DatosConex {
    
    private String conector;
    private String url;
    private String basedatos;
    private String usuario;
    private String pwd;
    private String completa;

    public DatosConex(){
        
    }
    
    public DatosConex(String conector, String url, String basedatos, String usuario, String pwd){
        this.conector = conector;
        this.url = url;
        this.basedatos = basedatos;
        this.usuario = usuario;
        this.pwd = pwd;
    }

    public String getConector(){
        return conector;
    }

    public void setConector(String conector){
        this.conector = conector;
    }

    public String getUrl(){
        return url;
    }

    public String getCompleta() {
        return completa;
    }

    public void setCompleta(String completa) {
        this.completa = completa;
        String [] parametros=completa.split(";");
        this.conector= parametros[0];
        this.url=parametros[1];
        this.basedatos=parametros[2];
        this.usuario=parametros[3];
        this.pwd=parametros[4];
    }
    

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBasedatos(){
        return basedatos;
    }

    public void setBasedatos(String basedatos){
        this.basedatos = basedatos;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DTO;

/**
 *
 * @author kete
 */
public class Directores {
    
    private String nombre;
    private String dni;
    private String nacionalidad;

    public Directores() {
    }

    public Directores(String nombre, String dni, String nacionalidad) {
        
        this.nombre = nombre;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nomobre) {
        this.nombre = nomobre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
}

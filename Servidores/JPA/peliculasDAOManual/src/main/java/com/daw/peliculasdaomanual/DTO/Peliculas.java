/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DTO;

import java.text.ParseException;
/**
 *
 * @author kete
 */
public class Peliculas {
    private  int codigo_pelicula;
    private String nombre;
    private String director;
    private String genero;
    private String estreno;
    private String publico;
    private String fecha_insercion;
    private String imagen;

    public Peliculas() {
    }

    public Peliculas(int codigo_pelicula, String nombre, String director, String genero, String estreno, String publico, String fecha_insercion, String imagen) throws ParseException {
        this.codigo_pelicula=codigo_pelicula;
        this.nombre=nombre;
        this.director=director;
        this.genero=genero;
        this.estreno=estreno;
        this.publico=publico;
        this.fecha_insercion = fecha_insercion;
        this.imagen=imagen;
    }

    public int getCodigo_pelicula() {
        return codigo_pelicula;
    }

    public void setCodigo_pelicula(int codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getPublico() {
        return publico;
    }

    public void setPublico(String publico) {
        this.publico = publico;
    }

    public String getFecha_insercion() {
        return fecha_insercion;
    }

    public void setFecha_insercion(String fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}

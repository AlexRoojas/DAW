/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author kete
 */
public class Peliculas {
    private  int codigo_pelicula;
    private String nombre;
    private String director;
    private String genero;
    private int estreno;
    private int publico;
    private Date fecha_insercion;
    private String imagen;

    public Peliculas() {
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

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }

    public Date getFecha_insercion() {
        return fecha_insercion;
    }

    public void setFecha_insercion(Date fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}

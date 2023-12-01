/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;


/**
 *
 * @author lola
 */
public class cPeliculas {
    
    private  int codigo_pelicula;
    private String nombre;
    private String director;
    private String genero;
    private int estreno;
    private int publico;
    private Date fecha_insercion;
    private String imagen;

    /**
     * @return the codigo_pelicula
     */
    public int getCodigo_pelicula() {
        return codigo_pelicula;
    }

    /**
     * @param codigo_pelicula the codigo_pelicula to set
     */
    public void setCodigo_pelicula(int codigo_pelicula) {
        this.codigo_pelicula = codigo_pelicula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the estreno
     */
    public int getEstreno() {
        return estreno;
    }

    /**
     * @param estreno the estreno to set
     */
    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    /**
     * @return the publico
     */
    public int getPublico() {
        return publico;
    }

    /**
     * @param publico the publico to set
     */
    public void setPublico(int publico) {
        this.publico = publico;
    }

    /**
     * @return the fecha_insercion
     */
    public Date getFecha_insercion() {
        return fecha_insercion;
    }

    /**
     * @param fecha_insercion the fecha_insercion to set
     */
    public void setFecha_insercion(Date fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
            
    
    
    
    
}

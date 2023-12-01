/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mi2daw;

/**
 *
 * @author Lola Verdu
 */
public class Articulos 
{
    private int cod_art;
    private String nombre;
    private String tema;
    private int pvp;
    private int existencias;

    /**
     * @return the cod_art
     */
    
    public Articulos(String nombre, String tema, int pvp, int existencias) {
        this.cod_art=0;
        this.nombre = nombre;
        this.tema = tema;
        this.pvp = pvp;
        this.existencias = existencias;
    }

    public Articulos(int cod_art, String nombre, String tema, int pvp, int existencias) {
        this.cod_art = cod_art;
        this.nombre = nombre;
        this.tema = tema;
        this.pvp = pvp;
        this.existencias = existencias;
    }

    
    public int getCod_art() {
        return cod_art;
    }

    /**
     * @param cod_art the cod_art to set
     */
    public void setCod_art(int cod_art) {
        this.cod_art = cod_art;
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
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the pvp
     */
    public int getPvp() {
        return pvp;
    }

    /**
     * @param pvp the pvp to set
     */
    public void setPvp(int pvp) {
        this.pvp = pvp;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Articulos{" + "cod_art=" + cod_art + ", nombre=" + nombre + ", tema=" + tema + ", pvp=" + pvp + ", exixtencias=" + existencias + '}';
    }
   
}

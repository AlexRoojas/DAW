/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mi2daw;

import java.io.Serializable;

/**
 *
 * @author Lola
 */
public class Cliente implements Serializable {
    
    
     private String usuario;
	private String clave;
	private String nombre;
	private String direccion;
	private int importe_acu;

    /**
     * @return the usuario
     */
     public Cliente(){}
    public Cliente(String usuario, String clave, String nombre, String direccion, int importe_acu) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.importe_acu = importe_acu;
    }

        
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the importe_acu
     */
    public int getImporte_acu() {
        return importe_acu;
    }

    /**
     * @param importe_acu the importe_acu to set
     */
    public void setImporte_acu(int importe_acu) {
        this.importe_acu = importe_acu;
    }

    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + ", direccion=" + direccion + ", importe_acu=" + importe_acu + '}';
    }
    
    
	
    
}

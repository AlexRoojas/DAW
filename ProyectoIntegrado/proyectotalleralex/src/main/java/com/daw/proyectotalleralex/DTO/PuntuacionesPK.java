/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.proyectotalleralex.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kete
 */
@Embeddable
public class PuntuacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigoprod")
    private int codigoprod;
    @Basic(optional = false)
    @Column(name = "dniusuario")
    private String dniusuario;

    public PuntuacionesPK() {
    }

    public PuntuacionesPK(int codigoprod, String dniusuario) {
        this.codigoprod = codigoprod;
        this.dniusuario = dniusuario;
    }

    public int getCodigoprod() {
        return codigoprod;
    }

    public void setCodigoprod(int codigoprod) {
        this.codigoprod = codigoprod;
    }

    public String getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(String dniusuario) {
        this.dniusuario = dniusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoprod;
        hash += (dniusuario != null ? dniusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntuacionesPK)) {
            return false;
        }
        PuntuacionesPK other = (PuntuacionesPK) object;
        if (this.codigoprod != other.codigoprod) {
            return false;
        }
        if ((this.dniusuario == null && other.dniusuario != null) || (this.dniusuario != null && !this.dniusuario.equals(other.dniusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.PuntuacionesPK[ codigoprod=" + codigoprod + ", dniusuario=" + dniusuario + " ]";
    }
    
}

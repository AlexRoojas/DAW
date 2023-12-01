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
public class CestaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "dniusuario")
    private String dniusuario;
    @Basic(optional = false)
    @Column(name = "codproducto")
    private int codproducto;

    public CestaPK() {
    }

    public CestaPK(String dniusuario, int codproducto) {
        this.dniusuario = dniusuario;
        this.codproducto = codproducto;
    }

    public String getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(String dniusuario) {
        this.dniusuario = dniusuario;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniusuario != null ? dniusuario.hashCode() : 0);
        hash += (int) codproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CestaPK)) {
            return false;
        }
        CestaPK other = (CestaPK) object;
        if ((this.dniusuario == null && other.dniusuario != null) || (this.dniusuario != null && !this.dniusuario.equals(other.dniusuario))) {
            return false;
        }
        if (this.codproducto != other.codproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.CestaPK[ dniusuario=" + dniusuario + ", codproducto=" + codproducto + " ]";
    }
    
}

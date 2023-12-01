/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.proyectotalleralex.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kete
 */
@Entity
@Table(name = "puntuaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntuaciones.findAll", query = "SELECT p FROM Puntuaciones p"),
    @NamedQuery(name = "Puntuaciones.findByCodigoprod", query = "SELECT p FROM Puntuaciones p WHERE p.puntuacionesPK.codigoprod = :codigoprod"),
    @NamedQuery(name = "Puntuaciones.findByDniusuario", query = "SELECT p FROM Puntuaciones p WHERE p.puntuacionesPK.dniusuario = :dniusuario"),
    @NamedQuery(name = "Puntuaciones.findByPuntuacion", query = "SELECT p FROM Puntuaciones p WHERE p.puntuacion = :puntuacion")})
public class Puntuaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PuntuacionesPK puntuacionesPK;
    @Basic(optional = false)
    @Column(name = "puntuacion")
    private int puntuacion;

    public Puntuaciones() {
    }

    public Puntuaciones(PuntuacionesPK puntuacionesPK) {
        this.puntuacionesPK = puntuacionesPK;
    }

    public Puntuaciones(PuntuacionesPK puntuacionesPK, int puntuacion) {
        this.puntuacionesPK = puntuacionesPK;
        this.puntuacion = puntuacion;
    }

    public Puntuaciones(int codigoprod, String dniusuario) {
        this.puntuacionesPK = new PuntuacionesPK(codigoprod, dniusuario);
    }

    public PuntuacionesPK getPuntuacionesPK() {
        return puntuacionesPK;
    }

    public void setPuntuacionesPK(PuntuacionesPK puntuacionesPK) {
        this.puntuacionesPK = puntuacionesPK;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puntuacionesPK != null ? puntuacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntuaciones)) {
            return false;
        }
        Puntuaciones other = (Puntuaciones) object;
        if ((this.puntuacionesPK == null && other.puntuacionesPK != null) || (this.puntuacionesPK != null && !this.puntuacionesPK.equals(other.puntuacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Puntuaciones[ puntuacionesPK=" + puntuacionesPK + " ]";
    }
    
}

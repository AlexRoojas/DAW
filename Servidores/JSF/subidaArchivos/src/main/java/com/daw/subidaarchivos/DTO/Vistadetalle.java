/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.subidaarchivos.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "vistadetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistadetalle.findAll", query = "SELECT v FROM Vistadetalle v"),
    @NamedQuery(name = "Vistadetalle.findByUid", query = "SELECT v FROM Vistadetalle v WHERE v.uid = :uid"),
    @NamedQuery(name = "Vistadetalle.findByCodigoFlor", query = "SELECT v FROM Vistadetalle v WHERE v.codigoFlor = :codigoFlor"),
    @NamedQuery(name = "Vistadetalle.findByDniusuario", query = "SELECT v FROM Vistadetalle v WHERE v.dniusuario = :dniusuario"),
    @NamedQuery(name = "Vistadetalle.findByImagen", query = "SELECT v FROM Vistadetalle v WHERE v.imagen = :imagen"),
    @NamedQuery(name = "Vistadetalle.findByNombreComun", query = "SELECT v FROM Vistadetalle v WHERE v.nombreComun = :nombreComun"),
    @NamedQuery(name = "Vistadetalle.findByTotalprecio", query = "SELECT v FROM Vistadetalle v WHERE v.totalprecio = :totalprecio"),
    @NamedQuery(name = "Vistadetalle.findByUnidades", query = "SELECT v FROM Vistadetalle v WHERE v.unidades = :unidades")})
public class Vistadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "uid")
    private String uid;
    @Column(name = "codigoFlor")
    private Integer codigoFlor;
    @Size(max = 255)
    @Column(name = "dniusuario")
    private String dniusuario;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 255)
    @Column(name = "nombreComun")
    private String nombreComun;
    @Column(name = "totalprecio")
    private Integer totalprecio;
    @Column(name = "unidades")
    private Integer unidades;

    public Vistadetalle() {
    }

    public Vistadetalle(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCodigoFlor() {
        return codigoFlor;
    }

    public void setCodigoFlor(Integer codigoFlor) {
        this.codigoFlor = codigoFlor;
    }

    public String getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(String dniusuario) {
        this.dniusuario = dniusuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public Integer getTotalprecio() {
        return totalprecio;
    }

    public void setTotalprecio(Integer totalprecio) {
        this.totalprecio = totalprecio;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vistadetalle)) {
            return false;
        }
        Vistadetalle other = (Vistadetalle) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.subidaarchivos.DTO.Vistadetalle[ uid=" + uid + " ]";
    }
    
}

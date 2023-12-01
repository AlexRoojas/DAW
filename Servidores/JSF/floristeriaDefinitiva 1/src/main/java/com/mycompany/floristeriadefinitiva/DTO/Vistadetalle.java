/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.floristeriadefinitiva.DTO;

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
 * @author kete
 */
@Entity
@Table(name = "vistadetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistadetalle.findAll", query = "SELECT v FROM Vistadetalle v"),
    @NamedQuery(name = "Vistadetalle.findByUid", query = "SELECT v FROM Vistadetalle v WHERE v.uid = :uid"),
    @NamedQuery(name = "Vistadetalle.findByNombreComun", query = "SELECT v FROM Vistadetalle v WHERE v.nombreComun = :nombreComun"),
    @NamedQuery(name = "Vistadetalle.findByImagen", query = "SELECT v FROM Vistadetalle v WHERE v.imagen = :imagen"),
    @NamedQuery(name = "Vistadetalle.findByDniusuario", query = "SELECT v FROM Vistadetalle v WHERE v.dniusuario = :dniusuario"),
    @NamedQuery(name = "Vistadetalle.findByCodigoFlor", query = "SELECT v FROM Vistadetalle v WHERE v.codigoFlor = :codigoFlor"),
    @NamedQuery(name = "Vistadetalle.findByUnidades", query = "SELECT v FROM Vistadetalle v WHERE v.unidades = :unidades"),
    @NamedQuery(name = "Vistadetalle.findByTotalprecio", query = "SELECT v FROM Vistadetalle v WHERE v.totalprecio = :totalprecio")})
public class Vistadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 36)
    @Column(name = "uid")
    @Id
    private String uid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreComun")
    private String nombreComun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dniusuario")
    private String dniusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoFlor")
    private int codigoFlor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalprecio")
    private int totalprecio;

    public Vistadetalle() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(String dniusuario) {
        this.dniusuario = dniusuario;
    }

    public int getCodigoFlor() {
        return codigoFlor;
    }

    public void setCodigoFlor(int codigoFlor) {
        this.codigoFlor = codigoFlor;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getTotalprecio() {
        return totalprecio;
    }

    public void setTotalprecio(int totalprecio) {
        this.totalprecio = totalprecio;
    }
    
}

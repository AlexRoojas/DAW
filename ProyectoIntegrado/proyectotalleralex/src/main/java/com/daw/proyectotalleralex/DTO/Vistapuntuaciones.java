/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.proyectotalleralex.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author kete
 */
@Entity
@Immutable
@Table(name = "vistapuntuaciones")
@Subselect("select uuid() as id, hs.* from vistapuntuaciones hs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistapuntuaciones.findAll", query = "SELECT v FROM Vistapuntuaciones v"),
    @NamedQuery(name = "Vistapuntuaciones.findById", query = "SELECT v FROM Vistapuntuaciones v WHERE v.id = :id"),
    @NamedQuery(name = "Vistapuntuaciones.findByCodigoprod", query = "SELECT v FROM Vistapuntuaciones v WHERE v.codigoprod = :codigoprod"),
    @NamedQuery(name = "Vistapuntuaciones.findByDniusuario", query = "SELECT v FROM Vistapuntuaciones v WHERE v.dniusuario = :dniusuario"),
    @NamedQuery(name = "Vistapuntuaciones.findByPuntuacion", query = "SELECT v FROM Vistapuntuaciones v WHERE v.puntuacion = :puntuacion"),
    @NamedQuery(name = "Vistapuntuaciones.findByNomProd", query = "SELECT v FROM Vistapuntuaciones v WHERE v.nomProd = :nomProd"),
    @NamedQuery(name = "Vistapuntuaciones.findByImgProd", query = "SELECT v FROM Vistapuntuaciones v WHERE v.imgProd = :imgProd"),
    @NamedQuery(name = "Vistapuntuaciones.findByPuntuacionProd", query = "SELECT v FROM Vistapuntuaciones v WHERE v.puntuacionProd = :puntuacionProd")})
public class Vistapuntuaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Basic(optional = false)
    @Column(name = "codigoprod")
    private int codigoprod;
    @Basic(optional = false)
    @Column(name = "dniusuario")
    private String dniusuario;
    @Basic(optional = false)
    @Column(name = "puntuacion")
    private int puntuacion;
    @Basic(optional = false)
    @Column(name = "nom_prod")
    private String nomProd;
    @Basic(optional = false)
    @Column(name = "img_prod")
    private String imgProd;
    @Basic(optional = false)
    @Column(name = "puntuacion_prod")
    private int puntuacionProd;

    public Vistapuntuaciones() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getImgProd() {
        return imgProd;
    }

    public void setImgProd(String imgProd) {
        this.imgProd = imgProd;
    }

    public int getPuntuacionProd() {
        return puntuacionProd;
    }

    public void setPuntuacionProd(int puntuacionProd) {
        this.puntuacionProd = puntuacionProd;
    }
    
}

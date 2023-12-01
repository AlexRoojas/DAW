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
@Table(name = "vistacestacompleta")
@Subselect("select uuid() as id, hs.* from vistacestacompleta hs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistacestacompleta.findAll", query = "SELECT v FROM Vistacestacompleta v"),
    @NamedQuery(name = "Vistacestacompleta.findById", query = "SELECT v FROM Vistacestacompleta v WHERE v.id = :id"),
    @NamedQuery(name = "Vistacestacompleta.findByDniusuario", query = "SELECT v FROM Vistacestacompleta v WHERE v.dniusuario = :dniusuario"),
    @NamedQuery(name = "Vistacestacompleta.findByCodproducto", query = "SELECT v FROM Vistacestacompleta v WHERE v.codproducto = :codproducto"),
    @NamedQuery(name = "Vistacestacompleta.findByNomProd", query = "SELECT v FROM Vistacestacompleta v WHERE v.nomProd = :nomProd"),
    @NamedQuery(name = "Vistacestacompleta.findByPrecioProd", query = "SELECT v FROM Vistacestacompleta v WHERE v.precioProd = :precioProd"),
    @NamedQuery(name = "Vistacestacompleta.findByUnidadesCesta", query = "SELECT v FROM Vistacestacompleta v WHERE v.unidadesCesta = :unidadesCesta"),
    @NamedQuery(name = "Vistacestacompleta.findByTotalpreciocesta", query = "SELECT v FROM Vistacestacompleta v WHERE v.totalpreciocesta = :totalpreciocesta")})
public class Vistacestacompleta implements Serializable {

    
    @Basic(optional = false)
    @Column(name = "img_prod")
    private String imgProd;

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Basic(optional = false)
    @Column(name = "dniusuario")
    private String dniusuario;
    @Basic(optional = false)
    @Column(name = "codproducto")
    private int codproducto;
    @Basic(optional = false)
    @Column(name = "nom_prod")
    private String nomProd;
    @Basic(optional = false)
    @Column(name = "precio_prod")
    private double precioProd;
    @Basic(optional = false)
    @Column(name = "unidades_cesta")
    private int unidadesCesta;
    @Basic(optional = false)
    @Column(name = "totalpreciocesta")
    private double totalpreciocesta;

    public Vistacestacompleta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public int getUnidadesCesta() {
        return unidadesCesta;
    }

    public void setUnidadesCesta(int unidadesCesta) {
        this.unidadesCesta = unidadesCesta;
    }

    public double getTotalpreciocesta() {
        return totalpreciocesta;
    }

    public void setTotalpreciocesta(double totalpreciocesta) {
        this.totalpreciocesta = totalpreciocesta;
    }


    public String getImgProd() {
        return imgProd;
    }

    public void setImgProd(String imgProd) {
        this.imgProd = imgProd;
    }
    
}

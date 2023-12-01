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
@Table(name = "vistafacturacompleta")
@Subselect("select uuid() as id, hs.* from vistafacturacompleta hs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vistafacturacompleta.findAll", query = "SELECT v FROM Vistafacturacompleta v"),
    @NamedQuery(name = "Vistafacturacompleta.findById", query = "SELECT v FROM Vistafacturacompleta v WHERE v.id = :id"),
    @NamedQuery(name = "Vistafacturacompleta.findByCodProducto", query = "SELECT v FROM Vistafacturacompleta v WHERE v.codProducto = :codProducto"),
    @NamedQuery(name = "Vistafacturacompleta.findByCodFactura", query = "SELECT v FROM Vistafacturacompleta v WHERE v.codFactura = :codFactura"),
    @NamedQuery(name = "Vistafacturacompleta.findByNomProd", query = "SELECT v FROM Vistafacturacompleta v WHERE v.nomProd = :nomProd"),
    @NamedQuery(name = "Vistafacturacompleta.findByPrecioProd", query = "SELECT v FROM Vistafacturacompleta v WHERE v.precioProd = :precioProd"),
    @NamedQuery(name = "Vistafacturacompleta.findByImgProd", query = "SELECT v FROM Vistafacturacompleta v WHERE v.imgProd = :imgProd"),
    @NamedQuery(name = "Vistafacturacompleta.findByTotalUnidades", query = "SELECT v FROM Vistafacturacompleta v WHERE v.totalUnidades = :totalUnidades"),
    @NamedQuery(name = "Vistafacturacompleta.findByDniUsu", query = "SELECT v FROM Vistafacturacompleta v WHERE v.dniUsu = :dniUsu")})
public class Vistafacturacompleta implements Serializable {

   
    @Basic(optional = false)
    @Column(name = "fechafinal")
    private String fechafinal;

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private int codProducto;
    @Basic(optional = false)
    @Column(name = "cod_factura")
    private int codFactura;
    @Basic(optional = false)
    @Column(name = "nom_prod")
    private String nomProd;
    @Basic(optional = false)
    @Column(name = "precio_prod")
    private double precioProd;
    @Basic(optional = false)
    @Column(name = "img_prod")
    private String imgProd;
    @Basic(optional = false)
    @Column(name = "total_unidades")
    private int totalUnidades;
    @Basic(optional = false)
    @Column(name = "dni_usu")
    private String dniUsu;

    public Vistafacturacompleta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
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

    public String getImgProd() {
        return imgProd;
    }

    public void setImgProd(String imgProd) {
        this.imgProd = imgProd;
    }

    public int getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(int totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    public String getDniUsu() {
        return dniUsu;
    }

    public void setDniUsu(String dniUsu) {
        this.dniUsu = dniUsu;
    }


    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }
    
}

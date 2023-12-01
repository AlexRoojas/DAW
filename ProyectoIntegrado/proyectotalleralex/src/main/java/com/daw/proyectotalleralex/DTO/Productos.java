/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.proyectotalleralex.DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kete
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodProd", query = "SELECT p FROM Productos p WHERE p.codProd = :codProd"),
    @NamedQuery(name = "Productos.findByNomProd", query = "SELECT p FROM Productos p WHERE p.nomProd = :nomProd"),
    @NamedQuery(name = "Productos.findByCategoriaProd", query = "SELECT p FROM Productos p WHERE p.categoriaProd = :categoriaProd"),
    @NamedQuery(name = "Productos.findByImgProd", query = "SELECT p FROM Productos p WHERE p.imgProd = :imgProd"),
    @NamedQuery(name = "Productos.findByDescripProd", query = "SELECT p FROM Productos p WHERE p.descripProd = :descripProd"),
    @NamedQuery(name = "Productos.findByUnidadesProd", query = "SELECT p FROM Productos p WHERE p.unidadesProd = :unidadesProd"),
    @NamedQuery(name = "Productos.findByPrecioProd", query = "SELECT p FROM Productos p WHERE p.precioProd = :precioProd"),
    @NamedQuery(name = "Productos.findByPuntuacionProd", query = "SELECT p FROM Productos p WHERE p.puntuacionProd = :puntuacionProd"),
    @NamedQuery(name = "Productos.findByFechaProd", query = "SELECT p FROM Productos p WHERE p.fechaProd = :fechaProd")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_prod")
    private Integer codProd;
    @Basic(optional = false)
    @Column(name = "nom_prod")
    private String nomProd;
    @Basic(optional = false)
    @Column(name = "categoria_prod")
    private String categoriaProd;
    @Basic(optional = false)
    @Column(name = "img_prod")
    private String imgProd;
    @Basic(optional = false)
    @Column(name = "descrip_prod")
    private String descripProd;
    @Basic(optional = false)
    @Column(name = "unidades_prod")
    private int unidadesProd;
    @Basic(optional = false)
    @Column(name = "precio_prod")
    private double precioProd;
    @Basic(optional = false)
    @Column(name = "puntuacion_prod")
    private int puntuacionProd;
    @Basic(optional = false)
    @Column(name = "fecha_prod")
    @Temporal(TemporalType.DATE)
    private Date fechaProd;

    public Productos() {
    }

    public Productos(Integer codProd) {
        this.codProd = codProd;
    }

    public Productos(Integer codProd, String nomProd, String categoriaProd, String imgProd, String descripProd, int unidadesProd, double precioProd, int puntuacionProd, Date fechaProd) {
        this.codProd = codProd;
        this.nomProd = nomProd;
        this.categoriaProd = categoriaProd;
        this.imgProd = imgProd;
        this.descripProd = descripProd;
        this.unidadesProd = unidadesProd;
        this.precioProd = precioProd;
        this.puntuacionProd = puntuacionProd;
        this.fechaProd = fechaProd;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public String getImgProd() {
        return imgProd;
    }

    public void setImgProd(String imgProd) {
        this.imgProd = imgProd;
    }

    public String getDescripProd() {
        return descripProd;
    }

    public void setDescripProd(String descripProd) {
        this.descripProd = descripProd;
    }

    public int getUnidadesProd() {
        return unidadesProd;
    }

    public void setUnidadesProd(int unidadesProd) {
        this.unidadesProd = unidadesProd;
    }

    public double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(double precioProd) {
        this.precioProd = precioProd;
    }

    public int getPuntuacionProd() {
        return puntuacionProd;
    }

    public void setPuntuacionProd(int puntuacionProd) {
        this.puntuacionProd = puntuacionProd;
    }

    public Date getFechaProd() {
        return fechaProd;
    }

    public void setFechaProd(Date fechaProd) {
        this.fechaProd = fechaProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProd != null ? codProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codProd == null && other.codProd != null) || (this.codProd != null && !this.codProd.equals(other.codProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Productos[ codProd=" + codProd + " ]";
    }
    
}

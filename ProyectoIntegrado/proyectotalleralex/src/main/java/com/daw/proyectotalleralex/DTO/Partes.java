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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kete
 */
@Entity
@Table(name = "partes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partes.findAll", query = "SELECT p FROM Partes p"),
    @NamedQuery(name = "Partes.findByCodParte", query = "SELECT p FROM Partes p WHERE p.codParte = :codParte"),
    @NamedQuery(name = "Partes.findByCodmecParte", query = "SELECT p FROM Partes p WHERE p.codmecParte = :codmecParte"),
    @NamedQuery(name = "Partes.findByMatricParte", query = "SELECT p FROM Partes p WHERE p.matricParte = :matricParte"),
    @NamedQuery(name = "Partes.findByCostesTotal", query = "SELECT p FROM Partes p WHERE p.costesTotal = :costesTotal"),
    @NamedQuery(name = "Partes.findByEstadoParte", query = "SELECT p FROM Partes p WHERE p.estadoParte = :estadoParte"),
    @NamedQuery(name = "Partes.findByFechaParte", query = "SELECT p FROM Partes p WHERE p.fechaParte = :fechaParte"),
    @NamedQuery(name = "Partes.findByProductosParte", query = "SELECT p FROM Partes p WHERE p.productosParte = :productosParte"),
    @NamedQuery(name = "Partes.findByCodcitaParte", query = "SELECT p FROM Partes p WHERE p.codcitaParte = :codcitaParte")})
public class Partes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_parte")
    private Integer codParte;
    @Basic(optional = false)
    @Column(name = "codmec_parte")
    private String codmecParte;
    @Basic(optional = false)
    @Column(name = "matric_parte")
    private String matricParte;
    @Basic(optional = false)
    @Column(name = "costes_total")
    private int costesTotal;
    @Basic(optional = false)
    @Column(name = "estado_parte")
    private String estadoParte;
    @Basic(optional = false)
    @Column(name = "fecha_parte")
    private String fechaParte;
    @Basic(optional = false)
    @Column(name = "productos_parte")
    private String productosParte;
    @Basic(optional = false)
    @Column(name = "codcita_parte")
    private int codcitaParte;

    public Partes() {
    }

    public Partes(Integer codParte) {
        this.codParte = codParte;
    }

    public Partes(Integer codParte, String codmecParte, String matricParte, int costesTotal, String estadoParte, String fechaParte, String productosParte, int codcitaParte) {
        this.codParte = codParte;
        this.codmecParte = codmecParte;
        this.matricParte = matricParte;
        this.costesTotal = costesTotal;
        this.estadoParte = estadoParte;
        this.fechaParte = fechaParte;
        this.productosParte = productosParte;
        this.codcitaParte = codcitaParte;
    }

    public Integer getCodParte() {
        return codParte;
    }

    public void setCodParte(Integer codParte) {
        this.codParte = codParte;
    }

    public String getCodmecParte() {
        return codmecParte;
    }

    public void setCodmecParte(String codmecParte) {
        this.codmecParte = codmecParte;
    }

    public String getMatricParte() {
        return matricParte;
    }

    public void setMatricParte(String matricParte) {
        this.matricParte = matricParte;
    }

    public int getCostesTotal() {
        return costesTotal;
    }

    public void setCostesTotal(int costesTotal) {
        this.costesTotal = costesTotal;
    }

    public String getEstadoParte() {
        return estadoParte;
    }

    public void setEstadoParte(String estadoParte) {
        this.estadoParte = estadoParte;
    }

    public String getFechaParte() {
        return fechaParte;
    }

    public void setFechaParte(String fechaParte) {
        this.fechaParte = fechaParte;
    }

    public String getProductosParte() {
        return productosParte;
    }

    public void setProductosParte(String productosParte) {
        this.productosParte = productosParte;
    }

    public int getCodcitaParte() {
        return codcitaParte;
    }

    public void setCodcitaParte(int codcitaParte) {
        this.codcitaParte = codcitaParte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParte != null ? codParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partes)) {
            return false;
        }
        Partes other = (Partes) object;
        if ((this.codParte == null && other.codParte != null) || (this.codParte != null && !this.codParte.equals(other.codParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Partes[ codParte=" + codParte + " ]";
    }
    
}

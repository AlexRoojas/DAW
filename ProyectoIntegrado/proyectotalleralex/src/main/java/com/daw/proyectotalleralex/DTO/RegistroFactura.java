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
@Table(name = "registro_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroFactura.findAll", query = "SELECT r FROM RegistroFactura r"),
    @NamedQuery(name = "RegistroFactura.findByCodReg", query = "SELECT r FROM RegistroFactura r WHERE r.codReg = :codReg"),
    @NamedQuery(name = "RegistroFactura.findByCodFactura", query = "SELECT r FROM RegistroFactura r WHERE r.codFactura = :codFactura"),
    @NamedQuery(name = "RegistroFactura.findByCodProducto", query = "SELECT r FROM RegistroFactura r WHERE r.codProducto = :codProducto"),
    @NamedQuery(name = "RegistroFactura.findByDniUsu", query = "SELECT r FROM RegistroFactura r WHERE r.dniUsu = :dniUsu"),
    @NamedQuery(name = "RegistroFactura.findByTotalUnidades", query = "SELECT r FROM RegistroFactura r WHERE r.totalUnidades = :totalUnidades")})
public class RegistroFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_reg")
    private Integer codReg;
    @Basic(optional = false)
    @Column(name = "cod_factura")
    private int codFactura;
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private int codProducto;
    @Basic(optional = false)
    @Column(name = "dni_usu")
    private String dniUsu;
    @Basic(optional = false)
    @Column(name = "total_unidades")
    private int totalUnidades;

    public RegistroFactura() {
    }

    public RegistroFactura(Integer codReg) {
        this.codReg = codReg;
    }

    public RegistroFactura(Integer codReg, int codFactura, int codProducto, String dniUsu, int totalUnidades) {
        this.codReg = codReg;
        this.codFactura = codFactura;
        this.codProducto = codProducto;
        this.dniUsu = dniUsu;
        this.totalUnidades = totalUnidades;
    }

    public Integer getCodReg() {
        return codReg;
    }

    public void setCodReg(Integer codReg) {
        this.codReg = codReg;
    }

    public int getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getDniUsu() {
        return dniUsu;
    }

    public void setDniUsu(String dniUsu) {
        this.dniUsu = dniUsu;
    }

    public int getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(int totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReg != null ? codReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroFactura)) {
            return false;
        }
        RegistroFactura other = (RegistroFactura) object;
        if ((this.codReg == null && other.codReg != null) || (this.codReg != null && !this.codReg.equals(other.codReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.RegistroFactura[ codReg=" + codReg + " ]";
    }
    
}

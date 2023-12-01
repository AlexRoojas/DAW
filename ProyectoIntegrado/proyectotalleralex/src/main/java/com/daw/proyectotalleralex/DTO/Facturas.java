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
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByCodFact", query = "SELECT f FROM Facturas f WHERE f.codFact = :codFact"),
    @NamedQuery(name = "Facturas.findByDniCli", query = "SELECT f FROM Facturas f WHERE f.dniCli = :dniCli"),
    @NamedQuery(name = "Facturas.findByUnidadestotal", query = "SELECT f FROM Facturas f WHERE f.unidadestotal = :unidadestotal"),
    @NamedQuery(name = "Facturas.findByPreciototal", query = "SELECT f FROM Facturas f WHERE f.preciototal = :preciototal"),
    @NamedQuery(name = "Facturas.findByFechafinal", query = "SELECT f FROM Facturas f WHERE f.fechafinal = :fechafinal"),
    @NamedQuery(name = "Facturas.findByCodMec", query = "SELECT f FROM Facturas f WHERE f.codMec = :codMec")})
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_fact")
    private Integer codFact;
    @Basic(optional = false)
    @Column(name = "dni_cli")
    private String dniCli;
    @Basic(optional = false)
    @Column(name = "unidadestotal")
    private int unidadestotal;
    @Basic(optional = false)
    @Column(name = "preciototal")
    private int preciototal;
    @Basic(optional = false)
    @Column(name = "fechafinal")
    private String fechafinal;
    @Column(name = "cod_mec")
    private Integer codMec;

    public Facturas() {
    }

    public Facturas(Integer codFact) {
        this.codFact = codFact;
    }

    public Facturas(Integer codFact, String dniCli, int unidadestotal, int preciototal, String fechafinal) {
        this.codFact = codFact;
        this.dniCli = dniCli;
        this.unidadestotal = unidadestotal;
        this.preciototal = preciototal;
        this.fechafinal = fechafinal;
    }

    public Integer getCodFact() {
        return codFact;
    }

    public void setCodFact(Integer codFact) {
        this.codFact = codFact;
    }

    public String getDniCli() {
        return dniCli;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    public int getUnidadestotal() {
        return unidadestotal;
    }

    public void setUnidadestotal(int unidadestotal) {
        this.unidadestotal = unidadestotal;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Integer getCodMec() {
        return codMec;
    }

    public void setCodMec(Integer codMec) {
        this.codMec = codMec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFact != null ? codFact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.codFact == null && other.codFact != null) || (this.codFact != null && !this.codFact.equals(other.codFact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Facturas[ codFact=" + codFact + " ]";
    }
    
}

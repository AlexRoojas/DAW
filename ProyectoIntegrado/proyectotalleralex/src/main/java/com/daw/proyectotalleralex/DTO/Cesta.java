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

/**
 *
 * @author kete
 */
@Entity
@Table(name = "cesta")
@NamedQueries({
    @NamedQuery(name = "Cesta.findAll", query = "SELECT c FROM Cesta c"),
    @NamedQuery(name = "Cesta.findByDniusuario", query = "SELECT c FROM Cesta c WHERE c.cestaPK.dniusuario = :dniusuario"),
    @NamedQuery(name = "Cesta.findByCodproducto", query = "SELECT c FROM Cesta c WHERE c.cestaPK.codproducto = :codproducto"),
    @NamedQuery(name = "Cesta.findByUnidadesCesta", query = "SELECT c FROM Cesta c WHERE c.unidadesCesta = :unidadesCesta"),
    @NamedQuery(name = "Cesta.findByTotalpreciocesta", query = "SELECT c FROM Cesta c WHERE c.totalpreciocesta = :totalpreciocesta")})
public class Cesta implements Serializable {

    @Basic(optional = false)
    @Column(name = "totalpreciocesta")
    private double totalpreciocesta;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CestaPK cestaPK;
    @Basic(optional = false)
    @Column(name = "unidades_cesta")
    private int unidadesCesta;

    public Cesta() {
    }

    public Cesta(CestaPK cestaPK) {
        this.cestaPK = cestaPK;
    }

    public Cesta(CestaPK cestaPK, int unidadesCesta, int totalpreciocesta) {
        this.cestaPK = cestaPK;
        this.unidadesCesta = unidadesCesta;
        this.totalpreciocesta = totalpreciocesta;
    }

    public Cesta(String dniusuario, int codproducto) {
        this.cestaPK = new CestaPK(dniusuario, codproducto);
    }

    public CestaPK getCestaPK() {
        return cestaPK;
    }

    public void setCestaPK(CestaPK cestaPK) {
        this.cestaPK = cestaPK;
    }

    public int getUnidadesCesta() {
        return unidadesCesta;
    }

    public void setUnidadesCesta(int unidadesCesta) {
        this.unidadesCesta = unidadesCesta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cestaPK != null ? cestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cesta)) {
            return false;
        }
        Cesta other = (Cesta) object;
        if ((this.cestaPK == null && other.cestaPK != null) || (this.cestaPK != null && !this.cestaPK.equals(other.cestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Cesta[ cestaPK=" + cestaPK + " ]";
    }

    public double getTotalpreciocesta() {
        return totalpreciocesta;
    }

    public void setTotalpreciocesta(double totalpreciocesta) {
        this.totalpreciocesta = totalpreciocesta;
    }
    
}

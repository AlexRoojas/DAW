/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasjpaversion1.DTO;

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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByCodGen", query = "SELECT g FROM Genero g WHERE g.codGen = :codGen"),
    @NamedQuery(name = "Genero.findByNomGen", query = "SELECT g FROM Genero g WHERE g.nomGen = :nomGen")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codGen")
    private Integer codGen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomGen")
    private String nomGen;

    public Genero() {
    }

    public Genero(Integer codGen) {
        this.codGen = codGen;
    }

    public Genero(Integer codGen, String nomGen) {
        this.codGen = codGen;
        this.nomGen = nomGen;
    }

    public Integer getCodGen() {
        return codGen;
    }

    public void setCodGen(Integer codGen) {
        this.codGen = codGen;
    }

    public String getNomGen() {
        return nomGen;
    }

    public void setNomGen(String nomGen) {
        this.nomGen = nomGen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGen != null ? codGen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codGen == null && other.codGen != null) || (this.codGen != null && !this.codGen.equals(other.codGen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.peliculasjpaversion1.DTO.Genero[ codGen=" + codGen + " ]";
    }
    
}

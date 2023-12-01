/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.seneca2dawalexrojas.DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Embeddable
public class AlumasigPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlumno")
    private int idAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAsig")
    private int idAsig;

    public AlumasigPK() {
    }

    public AlumasigPK(int idAlumno, int idAsig) {
        this.idAlumno = idAlumno;
        this.idAsig = idAsig;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAsig() {
        return idAsig;
    }

    public void setIdAsig(int idAsig) {
        this.idAsig = idAsig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlumno;
        hash += (int) idAsig;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumasigPK)) {
            return false;
        }
        AlumasigPK other = (AlumasigPK) object;
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        if (this.idAsig != other.idAsig) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.seneca2dawalexrojas.DTO.AlumasigPK[ idAlumno=" + idAlumno + ", idAsig=" + idAsig + " ]";
    }
    
}

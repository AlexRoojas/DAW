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

/**
 *
 * @author kete
 */
@Entity
@Table(name = "suscrip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscrip.findAll", query = "SELECT s FROM Suscrip s"),
    @NamedQuery(name = "Suscrip.findByEmailSusc", query = "SELECT s FROM Suscrip s WHERE s.emailSusc = :emailSusc"),
    @NamedQuery(name = "Suscrip.findByFechaSusc", query = "SELECT s FROM Suscrip s WHERE s.fechaSusc = :fechaSusc")})
public class Suscrip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email_susc")
    private String emailSusc;
    @Basic(optional = false)
    @Column(name = "fecha_susc")
    private String fechaSusc;

    public Suscrip() {
    }

    public Suscrip(String emailSusc) {
        this.emailSusc = emailSusc;
    }

    public Suscrip(String emailSusc, String fechaSusc) {
        this.emailSusc = emailSusc;
        this.fechaSusc = fechaSusc;
    }

    public String getEmailSusc() {
        return emailSusc;
    }

    public void setEmailSusc(String emailSusc) {
        this.emailSusc = emailSusc;
    }

    public String getFechaSusc() {
        return fechaSusc;
    }

    public void setFechaSusc(String fechaSusc) {
        this.fechaSusc = fechaSusc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailSusc != null ? emailSusc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscrip)) {
            return false;
        }
        Suscrip other = (Suscrip) object;
        if ((this.emailSusc == null && other.emailSusc != null) || (this.emailSusc != null && !this.emailSusc.equals(other.emailSusc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Suscrip[ emailSusc=" + emailSusc + " ]";
    }
    
}

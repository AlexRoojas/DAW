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

/**
 *
 * @author kete
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByDniusu", query = "SELECT u FROM Usuario u WHERE u.dniusu = :dniusu"),
    @NamedQuery(name = "Usuario.findByNombreusu", query = "SELECT u FROM Usuario u WHERE u.nombreusu = :nombreusu"),
    @NamedQuery(name = "Usuario.findByApellusu", query = "SELECT u FROM Usuario u WHERE u.apellusu = :apellusu"),
    @NamedQuery(name = "Usuario.findByEmailusu", query = "SELECT u FROM Usuario u WHERE u.emailusu = :emailusu"),
    @NamedQuery(name = "Usuario.findByContrausu", query = "SELECT u FROM Usuario u WHERE u.contrausu = :contrausu"),
    @NamedQuery(name = "Usuario.findByLocalidadusu", query = "SELECT u FROM Usuario u WHERE u.localidadusu = :localidadusu"),
    @NamedQuery(name = "Usuario.findByTipousu", query = "SELECT u FROM Usuario u WHERE u.tipousu = :tipousu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dniusu")
    private String dniusu;
    @Basic(optional = false)
    @Column(name = "nombreusu")
    private String nombreusu;
    @Basic(optional = false)
    @Column(name = "apellusu")
    private String apellusu;
    @Basic(optional = false)
    @Column(name = "emailusu")
    private String emailusu;
    @Basic(optional = false)
    @Column(name = "contrausu")
    private String contrausu;
    @Basic(optional = false)
    @Column(name = "localidadusu")
    private String localidadusu;
    @Basic(optional = false)
    @Column(name = "tipousu")
    private String tipousu;

    public Usuario() {
    }

    public Usuario(String dniusu) {
        this.dniusu = dniusu;
    }

    public Usuario(String dniusu, String nombreusu, String apellusu, String emailusu, String contrausu, String localidadusu, String tipousu) {
        this.dniusu = dniusu;
        this.nombreusu = nombreusu;
        this.apellusu = apellusu;
        this.emailusu = emailusu;
        this.contrausu = contrausu;
        this.localidadusu = localidadusu;
        this.tipousu = tipousu;
    }

    public String getDniusu() {
        return dniusu;
    }

    public void setDniusu(String dniusu) {
        this.dniusu = dniusu;
    }

    public String getNombreusu() {
        return nombreusu;
    }

    public void setNombreusu(String nombreusu) {
        this.nombreusu = nombreusu;
    }

    public String getApellusu() {
        return apellusu;
    }

    public void setApellusu(String apellusu) {
        this.apellusu = apellusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getContrausu() {
        return contrausu;
    }

    public void setContrausu(String contrausu) {
        this.contrausu = contrausu;
    }

    public String getLocalidadusu() {
        return localidadusu;
    }

    public void setLocalidadusu(String localidadusu) {
        this.localidadusu = localidadusu;
    }

    public String getTipousu() {
        return tipousu;
    }

    public void setTipousu(String tipousu) {
        this.tipousu = tipousu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniusu != null ? dniusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.dniusu == null && other.dniusu != null) || (this.dniusu != null && !this.dniusu.equals(other.dniusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Usuario[ dniusu=" + dniusu + " ]";
    }
    
}

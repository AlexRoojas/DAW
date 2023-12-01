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
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByCodCita", query = "SELECT c FROM Citas c WHERE c.codCita = :codCita"),
    @NamedQuery(name = "Citas.findByMatricCoche", query = "SELECT c FROM Citas c WHERE c.matricCoche = :matricCoche"),
    @NamedQuery(name = "Citas.findByMarcaCoche", query = "SELECT c FROM Citas c WHERE c.marcaCoche = :marcaCoche"),
    @NamedQuery(name = "Citas.findByModeloCoche", query = "SELECT c FROM Citas c WHERE c.modeloCoche = :modeloCoche"),
    @NamedQuery(name = "Citas.findByTipoCita", query = "SELECT c FROM Citas c WHERE c.tipoCita = :tipoCita"),
    @NamedQuery(name = "Citas.findByDescrpCita", query = "SELECT c FROM Citas c WHERE c.descrpCita = :descrpCita"),
    @NamedQuery(name = "Citas.findByFechaCita", query = "SELECT c FROM Citas c WHERE c.fechaCita = :fechaCita"),
    @NamedQuery(name = "Citas.findByEstadoCita", query = "SELECT c FROM Citas c WHERE c.estadoCita = :estadoCita"),
    @NamedQuery(name = "Citas.findByDniCli", query = "SELECT c FROM Citas c WHERE c.dniCli = :dniCli")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cita")
    private Integer codCita;
    @Basic(optional = false)
    @Column(name = "matric_coche")
    private String matricCoche;
    @Basic(optional = false)
    @Column(name = "marca_coche")
    private String marcaCoche;
    @Basic(optional = false)
    @Column(name = "modelo_coche")
    private String modeloCoche;
    @Basic(optional = false)
    @Column(name = "tipo_cita")
    private String tipoCita;
    @Basic(optional = false)
    @Column(name = "descrp_cita")
    private String descrpCita;
    @Basic(optional = false)
    @Column(name = "fecha_cita")
    private String fechaCita;
    @Basic(optional = false)
    @Column(name = "estado_cita")
    private String estadoCita;
    @Basic(optional = false)
    @Column(name = "dni_cli")
    private String dniCli;

    public Citas() {
    }

    public Citas(Integer codCita) {
        this.codCita = codCita;
    }

    public Citas(Integer codCita, String matricCoche, String marcaCoche, String modeloCoche, String tipoCita, String descrpCita, String fechaCita, String estadoCita, String dniCli) {
        this.codCita = codCita;
        this.matricCoche = matricCoche;
        this.marcaCoche = marcaCoche;
        this.modeloCoche = modeloCoche;
        this.tipoCita = tipoCita;
        this.descrpCita = descrpCita;
        this.fechaCita = fechaCita;
        this.estadoCita = estadoCita;
        this.dniCli = dniCli;
    }

    public Integer getCodCita() {
        return codCita;
    }

    public void setCodCita(Integer codCita) {
        this.codCita = codCita;
    }

    public String getMatricCoche() {
        return matricCoche;
    }

    public void setMatricCoche(String matricCoche) {
        this.matricCoche = matricCoche;
    }

    public String getMarcaCoche() {
        return marcaCoche;
    }

    public void setMarcaCoche(String marcaCoche) {
        this.marcaCoche = marcaCoche;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getDescrpCita() {
        return descrpCita;
    }

    public void setDescrpCita(String descrpCita) {
        this.descrpCita = descrpCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public String getDniCli() {
        return dniCli;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCita != null ? codCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.codCita == null && other.codCita != null) || (this.codCita != null && !this.codCita.equals(other.codCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.daw.proyectotalleralex.DTO.Citas[ codCita=" + codCita + " ]";
    }
    
}

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

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 *
 * @author kete
 */
@Entity
@Immutable
@Table(name = "vista_factura")
@Subselect("select uuid() as id, hs.* from vista_factura hs")
@NamedQueries({
    @NamedQuery(name = "VistaFactura.findAll", query = "SELECT v FROM VistaFactura v"),
    @NamedQuery(name = "VistaFactura.findById", query = "SELECT v FROM VistaFactura v WHERE v.id = :id"),
    @NamedQuery(name = "VistaFactura.findByCodFact", query = "SELECT v FROM VistaFactura v WHERE v.codFact = :codFact"),
    @NamedQuery(name = "VistaFactura.findByNombreusu", query = "SELECT v FROM VistaFactura v WHERE v.nombreusu = :nombreusu"),
    @NamedQuery(name = "VistaFactura.findByMatricCoche", query = "SELECT v FROM VistaFactura v WHERE v.matricCoche = :matricCoche"),
    @NamedQuery(name = "VistaFactura.findByMarcaCoche", query = "SELECT v FROM VistaFactura v WHERE v.marcaCoche = :marcaCoche"),
    @NamedQuery(name = "VistaFactura.findByModeloCoche", query = "SELECT v FROM VistaFactura v WHERE v.modeloCoche = :modeloCoche"),
    @NamedQuery(name = "VistaFactura.findByTipoCita", query = "SELECT v FROM VistaFactura v WHERE v.tipoCita = :tipoCita"),
    @NamedQuery(name = "VistaFactura.findByDescrpCita", query = "SELECT v FROM VistaFactura v WHERE v.descrpCita = :descrpCita"),
    @NamedQuery(name = "VistaFactura.findByEstadoCita", query = "SELECT v FROM VistaFactura v WHERE v.estadoCita = :estadoCita")})
public class VistaFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Basic(optional = false)
    @Column(name = "cod_fact")
    private int codFact;
    @Basic(optional = false)
    @Column(name = "nombreusu")
    private String nombreusu;
    @Basic(optional = false)
    @Column(name = "matric_coche")
    private int matricCoche;
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
    @Column(name = "estado_cita")
    private String estadoCita;

    public VistaFactura() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodFact() {
        return codFact;
    }

    public void setCodFact(int codFact) {
        this.codFact = codFact;
    }

    public String getNombreusu() {
        return nombreusu;
    }

    public void setNombreusu(String nombreusu) {
        this.nombreusu = nombreusu;
    }

    public int getMatricCoche() {
        return matricCoche;
    }

    public void setMatricCoche(int matricCoche) {
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

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DTO;

/**
 *
 * @author kete
 */
public class Genero {
    private int codGen;
    private String nomGen;

    public Genero() {
    }

    public Genero(int codGen, String nomGen) {
        this.codGen = codGen;
        this.nomGen = nomGen;
    }

    public int getCodGen() {
        return codGen;
    }

    public void setCodGen(int codGen) {
        this.codGen = codGen;
    }

    public String getNomGen() {
        return nomGen;
    }

    public void setNomGen(String nomGen) {
        this.nomGen = nomGen;
    }
    
    
}

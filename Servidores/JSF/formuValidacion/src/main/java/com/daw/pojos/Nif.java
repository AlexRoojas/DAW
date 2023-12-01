/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.pojos;

/**
 *
 * @author kete
 */
public class Nif {

    /**
     * Creates a new instance of Nif
     */
    
    private int numero;
    private String letra;
    
    public Nif() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Nif{" + "numero=" + numero + ", letra=" + letra + '}';
    }
    
    
    
}

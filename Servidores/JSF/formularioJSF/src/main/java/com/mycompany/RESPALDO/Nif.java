/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RESPALDO;

/**
 *
 * @author Usuario
 */
public class Nif {

    /**
     * Creates a new instance of Nif
     */
    
    private int numeros;
    private String letra;
    
    
    public Nif() {
        
    }

    public Nif(int numeros, String letra) {
        this.numeros = numeros;
        this.letra = letra;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(int numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Nif{" + "numeros=" + numeros + ", letra=" + letra + '}';
    }
    
    
    
}

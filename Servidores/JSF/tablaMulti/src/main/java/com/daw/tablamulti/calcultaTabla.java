/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.tablamulti;

/**
 *
 * @author Usuario
 */
public class calcultaTabla {

    /**
     * Creates a new instance of calcultaTabla
     */
    private int numero;
    private Integer[] resultado;
    
    public calcultaTabla() {
        resultado= new Integer[10];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Integer[] getResultado() {
        return resultado;
    }

    public void setResultado(Integer  [] resultado) {
        this.resultado = resultado;
    }
    
    
    public void calculo(){
        for (int i = 0; i < 10; i++) {
            resultado[i]=numero*(i+1);
        }
    }
}

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
public class calculo {

    /**
     * Creates a new instance of calculo
     */
    
    private int numTabla;
    private String[][] stabla = new String[10][3];
    
    public calculo() {
    }

    public int getNumTabla() {
        return numTabla;
    }

    public void setNumTabla(int numTabla) {
        this.numTabla = numTabla;
    }

    public void setStabla(String[][] stabla) {
        this.stabla = stabla;
    }
    
    public String[][] getStabla() {
        for (int i = 1; i < 11; i++) {
            stabla[i - 1][0] = numTabla + " X " + i;
            stabla[i - 1][1] = " = ";
            stabla[i - 1][2] = String.valueOf(numTabla * i);
        }
        return stabla;
    }
    
}

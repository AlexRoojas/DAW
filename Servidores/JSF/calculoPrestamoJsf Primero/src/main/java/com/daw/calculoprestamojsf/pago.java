/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.calculoprestamojsf;

/**
 *
 * @author Usuario
 */
public class pago {

    /**
     * Creates a new instance of pago
     */
    
    private int inper; //Número de periodos
    private double dcapital;
    private double dtae;
    private double dcuota;
    private String speriodicidad="ano";
    
    public pago() {
    }

    public int getInper() {
        return inper;
    }

    public void setInper(int inper) {
        this.inper = inper;
    }

    public double getDcapital() {
        return dcapital;
    }

    public void setDcapital(double dcapital) {
        this.dcapital = dcapital;
    }

    public double getDtae() {
        return dtae;
    }

    public void setDtae(double dtae) {
        this.dtae = dtae;
    }

    /*public double getDcuota() {
        if (speriodicidad.equals("ano")) {
            dcuota = CalculoCuota(dtae / 12, dcapital, inper * 12);
        } else {
            dcuota = CalculoCuota(dtae, dcapital, inper);
        }
        return dcuota;
    }*/
    public double getDcuota(){
        return dcuota;
    }

    public void setDcuota(double dcuota) {
        this.dcuota = dcuota;
    }

    public String getPeriocidad() {
        return speriodicidad;
    }

    public void setPeriocidad(String periocidad) {
        this.speriodicidad = periocidad;
    }
    
    public void calculoCuota() {
        
        if (speriodicidad.equals("ano")){
            dtae = dtae/12;
            inper = inper *12;
        }
        
        if (dtae == 0) {
            dcuota = dcapital / inper;
        } else {
            dcuota = (dcapital * dtae) / (100 * (1 - Math.pow((1 + (dtae / 100)), -inper)));
        }
        
    }
    
    /*public void CalculoCuota2(double dtae, double dcapital, int inperiodos) {
        double dcalculo;
        if (dtae == 0) {
            dcalculo = dcapital / inperiodos;
        } else {
            dcalculo = (dcapital * dtae) / (100 * (1 - Math.pow((1 + (dtae / 100)), -inperiodos)));
        }
        //return dcalculo;
    }*/
    
    

}

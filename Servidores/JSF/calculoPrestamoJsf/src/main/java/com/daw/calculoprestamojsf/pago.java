/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.calculoprestamojsf;

import java.util.ArrayList;
import java.util.Locale;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

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
    private String idioma;
    private double[][] cuadro = null;
    private HtmlCommandButton respaldoBoton;
    
    public pago() {
        inper = 20;
        dcapital = 100000;
        dtae = 4;
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

    public void setPeriocidad(String speriodicidad) {
        this.speriodicidad = speriodicidad;
    }
    
    public String getSperiodicidad() {
        return speriodicidad;
    }
    public void setSperiodicidad(String speriodicidad) {
        this.speriodicidad = speriodicidad;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public double[][] getCuadro() {
        return cuadro;
    }

    public void setCuadro(double[][] cuadro) {
        this.cuadro = cuadro;
    }

    public HtmlCommandButton getRespaldoBoton() {
        return respaldoBoton;
    }

    public void setRespaldoBoton(HtmlCommandButton respaldoBoton) {
        this.respaldoBoton = respaldoBoton;
    }
    
    
    
    //_______METODOS________
    
    public void calculoCuota() {
        double i;
        int nPlazo;
        if (speriodicidad.equals("ano")){
            i = dtae/100;
            nPlazo= inper;
        }else{
            i = dtae/100/12;
            nPlazo= inper*12;
        }
        
        if (i == 0) {
                dcuota = dcapital / nPlazo;
            } else {
                dcuota = dcapital * (i*Math.pow((1+i), nPlazo))/(Math.pow((1+i), nPlazo)-1);
                
            }
        
        
        
       /* 
        
        if (speriodicidad.equals("ano")){
            
            double actualDtae=dtae/12;
            int actualInper=inper *12;
            
            if (actualDtae == 0) {
                dcuota = dcapital / actualInper;
            } else {
                dcuota = (dcapital * actualDtae) / (100 * (1 - Math.pow((1 + (actualDtae / 100)), -actualInper)));
            }
            
        }else{
            if (dtae == 0) {
                dcuota = dcapital / inper;
            } else {
                dcuota = (dcapital * dtae) / (100 * (1 - Math.pow((1 + (dtae / 100)), -inper)));
            }
        }*/
    }
    
    
    
    
    public ArrayList getListaIdiomas() {
        ArrayList lista = new ArrayList();
        
        lista.add(new SelectItem("es", "Español"));
        lista.add(new SelectItem("en", "Inglés"));
        
        return lista;
    }

    public void cambioIdioma(ValueChangeEvent evento) {
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if (evento.getNewValue().equals("en")) {
            contexto.getViewRoot().setLocale(Locale.US);
        } else {
            contexto.getViewRoot().setLocale(Locale.getDefault());
        }
        
    }

    
    
    public void calculaCuadro() {
        
        int inper_aux;
        
        double dtae_aux, dcapitalPen, dCinteres, dCcapital;
        
        if (!speriodicidad.equals("ano")) {
            dtae_aux = dtae / 12;
            inper_aux = inper * 12;
            
        } else {
            dtae_aux = dtae;
            inper_aux = inper;
        }
        
        dcapitalPen = dcapital;
        
        cuadro = new double[inper_aux][4];
        
        
        for (int i = 1; i <= inper_aux; i++) {
            
            dCinteres = dcapitalPen * (dtae_aux / 100);
            dCcapital = dcuota - dCinteres;
            dcapitalPen = dcapitalPen - dCcapital;
            
            cuadro[i - 1][0] = i;
            cuadro[i - 1][1] = dCinteres;
            cuadro[i - 1][2] = dCcapital;
            cuadro[i - 1][3] = dcapitalPen;
        }
        respaldoBoton.setStyleClass("verde");
        
    }

    

}

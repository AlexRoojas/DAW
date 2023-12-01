package com.entrada;
import java.util.*;

public class Usuario{
	private String nombreUsuario;
	private GregorianCalendar horaInicio;
	private Integer puestoConexion;
	
	public Usuario(){
		
	}
	
	public Usuario(String nombreUsuario, GregorianCalendar horaInicio, Integer puestoConexion){
		this.nombreUsuario=nombreUsuario;
		this.horaInicio=horaInicio;
		this.puestoConexion=puestoConexion;
		
	}
	
	public String getNombre(){
		return nombreUsuario;
	}
	
	public GregorianCalendar getHora(){
		return horaInicio;
	}
	
	public Integer getpuestoConexion(){
		return puestoConexion;
	}
	
	@Override
    public String toString() {
        return puestoConexion+".- "+nombreUsuario + " " + horaInicio.get(Calendar.HOUR_OF_DAY)+":"+horaInicio.get(Calendar.MINUTE);
    }
	
	public String toStringLargo() {
        return "Hola "+nombreUsuario + " te has conectado a las " + horaInicio.get(Calendar.HOUR_OF_DAY)+":"+horaInicio.get(Calendar.MINUTE);
    }
	
	
}
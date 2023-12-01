package pojos;
import java.util.*;
import java.io.*;

public class Tienda {
	String nombreTienda;
	HashMap <Integer , Articulo> listaArticulos = new HashMap<>();
	
	public  Tienda(){
		
	}
		
	
	//Get y set ------------------------------------------
	
	public String getNombreTienda(){
		return nombreTienda;
	}
	
	public void setNombreTienda(String nombreTienda){
		this.nombreTienda=nombreTienda;
	}

	public HashMap<Integer,Articulo> getListaArticulos(){
		return this.listaArticulos;
	}
	
	public void setListaArticulos(HashMap<Integer,Articulo> listaArticulos){
		this.listaArticulos = listaArticulos;
	}
	
	public Articulo getObtenerArticulo (int codigoArt){
		return listaArticulos.get(codigoArt);
	}
	
	public void setAnadirArticulosTiendas(String parametros){
		String primerSplit [] =parametros.split(";");
		int i=0;
		for(String split: primerSplit){
			String segundoSplit [] = split.split(":");
			Articulo art = new Articulo(i,segundoSplit[0],Integer.parseInt(segundoSplit[1]),Double.parseDouble(segundoSplit[2]));		
			this.listaArticulos.put(i,art);
			i++;
		}
	}
}
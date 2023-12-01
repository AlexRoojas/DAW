package pojos;
import java.util.*;

public class Tienda {
	private String nombreTienda;
	private HashMap<Integer,Articulo> listaArticulos;
	
	
	public Tienda () {
		this.nombreTienda = "indefinido";
		this.listaArticulos = new HashMap<Integer,Articulo>();
	}
	
	public Tienda (String nom) { // exists -> existencias
		this.nombreTienda = nom;
		this.listaArticulos = new HashMap<Integer,Articulo>();
	}
	
	public String getNombreTienda(){
		return this.nombreTienda;
	}
	
	public void setNombreTienda(String nombreTienda){
		this.nombreTienda = nombreTienda;
	}
	
	public HashMap<Integer,Articulo> getListaArticulos(){
		return this.listaArticulos;
	}
	
	public void setListaArticulos(HashMap<Integer,Articulo> listaArticulos){
		this.listaArticulos = listaArticulos;
	}
	
	public Articulo getObtenerArticulo(int codigoArticulo){
		return listaArticulos.get(codigoArticulo);
	}
	
	public void setCargarTienda(String articulo){
		String split[] = articulo.split(";"); 
		
		for (int i = 0; i < split.length; i++) {
			String splitEntero[] = split[i].split(":"); 
			Articulo art = new Articulo(i,splitEntero[0],Integer.parseInt(splitEntero[1]));
			this.listaArticulos.put(i,art);
			
		}
	}
	
}
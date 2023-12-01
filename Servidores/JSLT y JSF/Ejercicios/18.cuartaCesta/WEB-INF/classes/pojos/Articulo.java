package pojos;
import java.util.*;

public class Articulo {
	private int codigoArticulo;
	private String nombreArticulo;
	private int unidadesArticulo;
	private double precioArticulo;
	private String imagenArticulo;
	
	
	public Articulo () {
		this.codigoArticulo = -1;
		this.nombreArticulo = "indefinido";
		this.unidadesArticulo = -1;
		this.precioArticulo = -1.0;
		this.imagenArticulo = "sin imagen";
	}
	
	public Articulo (int cod, String nom, int exists) { // exists -> existencias
		this.codigoArticulo = cod;
		this.nombreArticulo = nom;
		this.unidadesArticulo = exists;
		this.precioArticulo = 0.0;
		this.imagenArticulo = "imagenes/" + nom + ".png";
	}
	
	public Articulo (int cod, String nom, int exists, double prec) { // exists -> existencias
		this.codigoArticulo = cod;
		this.nombreArticulo = nom;
		this.unidadesArticulo = exists;
		this.precioArticulo = prec;
		this.imagenArticulo = "imagenes/" + nom + ".png";
	}
	
	public String getNombreArticulo(){
		return nombreArticulo;
	}
	
	public int getUnidadesArticulo(){
		return unidadesArticulo;
	}
	
	public String getImagenArticulo(){
		return imagenArticulo;
	}
	
	public double getPrecioArticulo(){
		return precioArticulo;
	}
	
	public void decrementarUnidad() {
		this.unidadesArticulo--;
	}
	
	public void decrementarNUnidades(int uDecrementar) {
		this.unidadesArticulo -= uDecrementar;
	}
	public void incrementarUnidad() {
		this.unidadesArticulo++;
	}
	
	public void incrementarNUnidades(int uIncrementar) {
		this.unidadesArticulo += uIncrementar;
	}
	
}
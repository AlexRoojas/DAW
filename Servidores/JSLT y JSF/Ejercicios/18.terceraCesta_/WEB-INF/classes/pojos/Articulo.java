package pojos;
import java.util.*;

public class Articulo {
	private int codigoArticulo;
	private String nombreArticulo;
	private int unidadesArticulo;
	private double precio; // en desuso
	private String imagenArticulo; // en desuso
	
	
	public Articulo () {
		this.codigoArticulo = -1;
		this.nombreArticulo = "indefinido";
		this.unidadesArticulo = -1;
		this.precio = -1.0;
		this.imagenArticulo = "sin imagen";
	}
	
	public Articulo (int cod, String nom, int exists) { // exists -> existencias
		this.codigoArticulo = cod;
		this.nombreArticulo = nom;
		this.unidadesArticulo = exists;
		this.precio = 0.0;
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
	
	public void decrementarUnidad() {
		this.unidadesArticulo--;
	}
	
	public void decrementarNUnidades(int uDecrementar) {
		this.unidadesArticulo -= uDecrementar;
	}
	
}
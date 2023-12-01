package pojos;
import java.util.*;

public class Articulo{
	private int codigo;
	private String nombre;
	private int unidades;
	private double precio;
	private String imagen;
	
	public Articulo(){
		
	}
	
	public Articulo(int codigo,String nombre,int unidades){
		this.codigo=codigo;
		this.nombre=nombre;
		this.unidades=unidades;
		this.precio=0.0;
		this.imagen="images/"+nombre+".png";
		
	}
	public Articulo(int codigo,String nombre,int unidades,double precio){
		this.codigo=codigo;
		this.nombre=nombre;
		this.unidades=unidades;
		this.precio=precio;
		this.imagen="images/"+nombre+".png";
		
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getUnidades(){
		return unidades;
	}
	
	public void setUnidades(int unidades){
		this.unidades = unidades;
    }
	
	public double getPrecio(){
		return precio;
	}
	
	public String getImagen(){
		return imagen;
	}
	
	public void restaUnidades(Articulo articulo){
		articulo.setUnidades(articulo.getUnidades()-1);
	}
	
	public void sumaUnidades(Articulo articulo){
		articulo.setUnidades(articulo.getUnidades()+1);
	}
	
	@Override
    public String toString() {
        return codigo+".- "+nombre;
    }
	
	
	
}
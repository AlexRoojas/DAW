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
	
	@Override
    public String toString() {
        return codigo+".- "+nombre;
    }
	
	
	
}
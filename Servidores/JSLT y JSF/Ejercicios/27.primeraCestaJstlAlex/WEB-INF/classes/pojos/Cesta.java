package pojos;
import java.util.*;

public class Cesta{
	
	private String usuario;
	private HashMap <Integer,Integer> cestaCompra = new HashMap<>();
	
	public Cesta(){
		
	}
	
	
	
	public String getUsuario(){
		return usuario;
	}
	
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
    }
	
	public HashMap<Integer,Integer> getCestaCompra(){
		return this.cestaCompra;
	}
	
	public void setCestaCompra(HashMap<Integer,Integer> cestaCompra){
		this.cestaCompra=cestaCompra;
	}
	
	public void addArticulo(int codigoArt){
		if(cestaCompra.get(codigoArt)>0){
			cestaCompra.replace(codigoArt,cestaCompra.get(codigoArt)+1);
		}
	}
	
}
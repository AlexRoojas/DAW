package pojos;
import java.util.*;
import java.io.*;

public class Cesta {
	
	String usuario;
	HashMap <Integer , Integer> cestaCompra = new HashMap<>();
	
	public  Cesta(){
		
	}
		

	
	//Get y set ------------------------------------------
	
	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}

	public HashMap <Integer , Integer> getCestaCompra(){
		return this.cestaCompra;
	}
	
	public void setCestaCompra(HashMap<Integer,Integer> cestaCompra){
		this.cestaCompra = cestaCompra;
	}
	
	public void anadirArticulo (int codigoArt, int cantidad){

			if(cestaCompra.get(codigoArt)!=null){
				cestaCompra.replace(codigoArt,cestaCompra.get(codigoArt)+cantidad);
			}else{
				cestaCompra.put(codigoArt,cantidad);
			}

	}
}
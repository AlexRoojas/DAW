package pojos;
import java.util.*;
import java.io.*;

public class Articulo {
	
	int codigo;
	String nombre;
	String img;
	int existencias;
	double precio;
	
	public  Articulo(){
		codigo=0;
		nombre="";
		existencias=0;
		precio=0;
		img="";
	}
		
	
	public  Articulo(int codigo, String nombre, int existencias,double precio){
		this.codigo=codigo;
		this.nombre=nombre;
		this.existencias=existencias;
		this.precio=precio;
		this.img=nombre;
	}
	
	//Get y set ------------------------------------------
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}
	
	public int getExistencias(){
		return existencias;
	}

	public void setExistencias(int existencias){
		this.existencias=existencias;
	}
	
	public void setPrecio(double precio){
		this.precio=precio;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	public String getImg(){
		return img;
	}
	
	public void setImg(String img){
		this.img="imagenes/"+getNombre()+".jpg";
	}

	public void anadeExistencias(int numero){
		this.existencias=this.existencias+numero;
	}
	
	public void decrementaExistencias(int numero){
		this.existencias=this.existencias-numero;
	}
}
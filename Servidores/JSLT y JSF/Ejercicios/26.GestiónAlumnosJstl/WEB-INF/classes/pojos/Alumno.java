package pojos;
import java.util.*;

public class Alumno{
	
	private int nif;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int nAsig;
	private String curso;
	private String poblacion;
	private String cp;
	private int nHermanos;
	private Map<Integer,Double> asignaturas;
	
	public Alumno(){
		
		nombre="sinnombre";
	}
	
	public Alumno(int nif,String nombre,String apellido1,String apellido2,
					int edad,String curso, String poblacion,String cp,int nHermanos){
						
		this.nif = nif;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.curso = curso;
		this.poblacion = poblacion;
		this.cp = cp;
		this.nHermanos = nHermanos;
		this.asignaturas = new HashMap();
		this.nAsig = 5;
	}
	
	public void setNif(int nif){
		this.nif = nif;
	}
	
	public int getNif(){
		return this.nif;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setApellido1(String apellido1){
		this.apellido1 = apellido1;
	}
	
	public String getApellido1(){
		return this.apellido1;
	}
	
	public void setApellido2(String apellido2){
		this.apellido2 = apellido2;
	}
	
	public String getApellido2(){
		return this.apellido2;
	}
	
	public void setEdad(int edad){
		this.edad = edad;
	}
	
	public int getEdad(){
		return this.edad;
	}
	
	public void setNAsig(int nAsig){
		this.nAsig = nAsig;
	}
	
	public int getNAsig(){
		return this.nAsig;
	}
	
	public void setCurso(String curso){
		this.curso = curso;
	}
	
	public String getCurso(){
		return this.curso;
	}
	
	public void setPoblacion(String poblacion){
		this.curso = poblacion;
	}
	
	public String getPoblacion(){
		return this.poblacion;
	}
	
	public void setCp(String cp){
		this.cp = cp;
	}
	
	public String getCp(){
		return this.cp;
	}
	
	public void setnHermanos(int nHermanos){
		this.nHermanos = nHermanos;
	}
	
	public int getnHermanos(){
		return this.nHermanos;
	}
	
	public Map<Integer,Double> getAsignaturas(){
		return this.asignaturas;
	}
}
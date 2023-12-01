package pojos;
import java.util.*;

public class Alumno{
	private int nif;
	private String nombre;
	private String ape1;
	private String ape2;
	private int edad;
	private int numHerm;
	private String curso;
	private int nAsig;
	private String poblacion;
	private String CP;
	private HashMap<Integer,Double> asignaturas;
	
	public Alumno(){
		this.nif=0;
		this.nombre="";
		this.ape1="";
		this.ape2="";
		this.edad=0;
		this.numHerm=0;
		this.curso="";
		this.poblacion="";
		this.CP="";
	}
	
	public Alumno(int nif,String nombre,String ape1,String ape2,int edad,int numHerm,String curso,String poblacion,String CP){
		this.nif=nif;
		this.nombre=nombre;
		this.ape1=ape1;
		this.ape2=ape2;
		this.edad=edad;
		this.numHerm=numHerm;
		this.curso=curso;
		this.nAsig=5;
		this.poblacion=poblacion;
		this.CP=CP;
		this.asignaturas= new HashMap<Integer,Double>();
		
	}
	public int getNif() {
		return nif;
    }
    public void setNif(int nif) {
		this.nif = nif;
    }
    public String getNombre() {
		return nombre;
    }
    public void setNombre(String nombre) {
		this.nombre = nombre;
    }
	public String getApellido1() {
		return ape1;
    }
    public void setApellido1(String ape1) {
		this.ape1 = ape1;
    }
	public String getApellido2() {
		return ape2;
    }
    public void setApellido2(String ape2) {
		this.ape2 = ape2;
    }
	public int getEdad() {
		return edad;
    }
    public void setEdad(int edad) {
		this.edad = edad;
    }
	public String getCurso() {
		return curso;
    }
    public void setCurso(String curso) {
		this.curso = curso;
    }
	public String getPoblacion() {
		return poblacion;
    }
    public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
    }
	public String getCodPostal() {
		return CP;
    }
    public void setCodPostal(String CP) {
		this.CP = CP;
    }
	public int getNumHermanos() {
		return numHerm;
    }
    public void setNumHermanos(int numHerm) {
		this.numHerm = numHerm;
    }
	@Override
    public String toString() {
        return nif+".- "+nombre;
    }
	
	
	
}
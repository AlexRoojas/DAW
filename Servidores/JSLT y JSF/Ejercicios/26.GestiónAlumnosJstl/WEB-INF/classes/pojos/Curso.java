package pojos;
import java.util.*;

public class Curso{
	
	private String nombreCurso;
	private HashMap <Integer,Alumno> listaAlumnos;
	
	public Curso(){
		this.nombreCurso="vacio";
		this.listaAlumnos= new HashMap<Integer,Alumno>();
	}
	
	public void setNombreCurso(String nombreCurso){
		this.nombreCurso = nombreCurso;
	}
	
	public String getNombreCurso(){
		return this.nombreCurso;
	}
	
	public void setListaAlumnos(HashMap<Integer,Alumno> listaAlumnos){
		this.listaAlumnos=listaAlumnos;
	}
	
	public Map<Integer,Alumno> getListaAlumnos(){
		return this.listaAlumnos;
	}
	
	public void setAddAlumno(Alumno alm){
		listaAlumnos.put(alm.getNif(),alm);
	}
	
	public int getNumAlum(){
		return listaAlumnos.size();
	}
	
}
package pojos;
import java.util.*;


public class Jugador {
	
	private String nombreUsuario;
	private String passw;	
	private int puntuacion;
	private ArrayList<String> palabrasAcertadas;
	
	public Jugador () {
		puntuacion = 0;
		palabrasAcertadas = new ArrayList<String>();
	}
	
	public Jugador (String nombreUsuario, String passw, int puntuacion) {
		this.nombreUsuario = nombreUsuario;	
		this.passw = passw;
		this.puntuacion = puntuacion;	
		palabrasAcertadas = new ArrayList<String>();
	}
	
	public String getNombreUsuario(){
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getPassw(){
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	public int getPuntuacion(){
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public ArrayList<String> getPalabrasAcertadas(){
		return palabrasAcertadas;
	}
	public void setPalabrasAcertadas(ArrayList<String> palabrasAcertadas) {
		this.palabrasAcertadas = palabrasAcertadas;
	}
	
	/*Métodos*/
	public void addPuntos(int puntosNuevos){
		this.puntuacion += puntosNuevos;
	}
}
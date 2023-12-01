package pojos;
import java.util.*;


public class Partida {
	
	private String usuario;
	private int puntos;
	private int fallos;
	private int aciertos;
	private char[] miPalabra;
	private char[] palabraAcertada;
	private ArrayList<Character> letrasUsadas;
	
	public Partida () {
	}
	
	public Partida (String usuario) {
		this.puntos = 0;
		this.fallos = 0;
		this.aciertos = 0;
		letrasUsadas = new ArrayList();
		
	}
	
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

	public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
	
	public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
	
	public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
	
	public char[] getMiPalabra() {
        return miPalabra;
    }

    public void setMiPalabra(char[] miPalabra) {
        this.miPalabra = miPalabra;
    }
	public char[] getPalabraAcertada() {
        return palabraAcertada;
    }

    public void setPalabraAcertada(char[] palabraAcertada) {
        this.palabraAcertada = palabraAcertada;
    }
	
	public ArrayList<Character> getLetrasUsadas(){
		return this.letrasUsadas;
	}
	
	public void setLetrasUsadas(ArrayList<Character> letrasUsadas){
		this.letrasUsadas = letrasUsadas;
	}
	
	/*---METODOS---*/
	
	
	public void addFallo(){
		this.fallos++;
	}
	
	public void addAcierto(){
		this.aciertos++;
	}
	
	public int getAciertosMax(){
		return miPalabra.length; 
	}
	
	public void addPuntos(int numero){
		this.puntos += numero;
	}
	
	public static int numAleatorio(int min, int max){
		return (int) (Math.random()*(max-min))+min;
	}

	public void setLimpiaLetrasUs(String prueba){
		this.letrasUsadas = new ArrayList();
	}
	
	public void setCambiarPalabra(HashMap<Integer,String> palabras){
		String palabraElegida = palabras.get(numAleatorio(1, palabras.size()));
		this.miPalabra = palabraElegida.toCharArray();
		this.palabraAcertada = new char[miPalabra.length];
		for(int i = 0; i < palabraAcertada.length; i++){
			palabraAcertada[i] = '_';
		}
	}
	
}
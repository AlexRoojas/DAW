package pojos;
import java.util.*;

public class Lista{
	private HashMap<Integer,String> palabras;
	private HashMap<String,Jugador> jugadores;
	private static int numPalabra = 1;
	
	private static char[] abc = {'q','w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j',
	'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
	
	public Lista(){
		palabras = new HashMap();
		jugadores = new HashMap();
	}
	
	public Lista(HashMap<Integer,String> palabras, HashMap<String,Jugador> jugadores){
		this.palabras = palabras;
		this.jugadores = jugadores;
	}
	
	/*........Getter y Setters.......................................*/
	public char[] getAbc(){
		return this.abc;
	}
	
	public HashMap<Integer,String> getPalabras(){
		return this.palabras;
	}
	
	public void setPalabras(HashMap<Integer,String> palabras){
		this.palabras = palabras;
	}
	
	public HashMap<String,Jugador> getJugadores(){
		return this.jugadores;
	}
	
	public void setJugadores(HashMap<String,Jugador> jugadores){
		this.jugadores = jugadores;
	}
	
	/*...............Otros Métodos....................................*/
	public Jugador obtenerJugador(String nick){
		return jugadores.get(nick);
	}
	
	public void setAddJugador(Jugador jug){
		jugadores.put(jug.getNombreUsu(), jug);
	}
	
	public void setCargarPalabras(String palabrasXml){
		String[] palabrasString = palabrasXml.split(",");
		
		for(String pal : palabrasString){
			palabras.put(numPalabra, pal);
			numPalabra++;
		}
	}
}
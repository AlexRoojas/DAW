package pojos;
import java.util.*;


public class Lista {
	private HashMap<Integer,String> palabras;
	private HashMap<String,Jugador> jugadores;
	
	
	public Lista () {
		this.palabras = new HashMap<Integer,String>();
		this.jugadores = new HashMap<String,Jugador>();
	}
	public Lista(HashMap<Integer,String> palabras, HashMap<String,Jugador> jugadores){
		this.palabras = palabras;
		this.jugadores = jugadores;
	}
	
	public HashMap<Integer, String> getPalabras(){
        return palabras;
    }

    public void setPalabras(HashMap<Integer, String> palabras){
        this.palabras = palabras;
    }
	
	public HashMap <String,Jugador> getJugadores(){
        return jugadores;
    }

    public void setJugadores(HashMap <String,Jugador> jugadores) {
        this.jugadores = jugadores;
    }
	/*METODOS*/
	
	
	public void setAddJugador(Jugador jug){
		this.jugadores.put(jug.getNombreUsuario(),jug);
	}
	
	public Jugador obtenerJugador(String nick){
		return jugadores.get(nick);
	}
	
	public void setCargarPalabras(String letra) {
		String [] lPalabras=letra.split(";");
		
		for (int i=0;i<lPalabras.length;i++){
			palabras.put(i,lPalabras[i]);
		}
    }
	
	public String getMiPalabraJugar(){
        int posicionPalabraAJugar=((int)(Math.random()*this.palabras.size()));
        return this.palabras.get(posicionPalabraAJugar);
    }
	
	public ArrayList <String> getDividirCaracteres(String palabra){
        String primerSplit [] =palabra.split(";");
        int i=0;
        ArrayList <String> listaCaracteres = new ArrayList<>();
        for(String split: primerSplit){
            listaCaracteres.add(split);
            i++;
        }
        return listaCaracteres;
    }
	
}
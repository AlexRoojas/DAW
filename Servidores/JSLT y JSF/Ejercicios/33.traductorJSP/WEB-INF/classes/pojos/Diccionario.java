package pojos;
import pojos.*;
import java.util.*;

public class Diccionario{
    
	String idiomasDiccionario;
	HashMap<String,String[]> palabras;
	
    public Diccionario() {
		this.palabras=new HashMap<>();
    }
		
	public Diccionario(String idiomasDiccionario) {
		this.idiomasDiccionario=idiomasDiccionario;
		this.palabras=new HashMap<>();
    }
		
	public String getIdiomasDiccionario(){
		return idiomasDiccionario;
	}
	
	public void setIdiomasDiccionario(String idiomasDiccionario){
		this.idiomasDiccionario=idiomasDiccionario;
	}
	
	public HashMap<String,String[]> getPalabras(){
		return palabras;
	}
	
	public void setPalabras(HashMap<String,String[]>palabras){
		this.palabras=palabras;
	}
	
	public void setAddPalabras(String palabraEspaniol,String palabrasIngles[]){
		this.palabras.put(palabraEspaniol,palabrasIngles);
	}
	
    
}
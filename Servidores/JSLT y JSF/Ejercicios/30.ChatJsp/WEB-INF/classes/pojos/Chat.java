package pojos;
import java.util.*;


public class Chat {
	private String nombreChat;
	private HashMap<String,Sala> salas;
	
	
	public Chat () {
		this.salas = new HashMap<>();
	}
	
	public Chat (String nombreChat) {
		this.nombreChat = nombreChat;
		this.salas = new HashMap<>();
	}
	
	public String getNombreChat(){
		return nombreChat;
	}
	
	public void setNombreChat(String nombreChat){
		this.nombreChat = nombreChat;
	}
	
	public HashMap <String,Sala> getSalas(){
		return salas;
	}
	
	public void setSalas(HashMap <String,Sala> salas){
		this.salas=salas;
	}
	
	public Sala getObtenerSala(String nombreSala){
		return salas.get(nombreSala);
	}
	
	public void setAddListaSalas(Sala sala){
		this.salas.put(sala.getNombreSala(),sala);
	}
	
}
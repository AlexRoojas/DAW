package pojos;
import java.util.*;

public class Sala {
	private String nombreSala;
	private ArrayList<Mensajes> listaMensajes = new ArrayList<>();
	
	
	public Sala () {
		this.nombreSala = "indefinido";
	}
	
	public Sala (String nombreSala) {
		this.nombreSala = nombreSala;
	}
	
	public String getNombreSala(){
		return nombreSala;
	}
	
	public void setNombreSala(String nombreSala){
		this.nombreSala = nombreSala;
	}
	
	public ArrayList <Mensajes> getListaMensajes(){
		return listaMensajes;
	}
	
	public void setListaMensajes(ArrayList <Mensajes> listaMensajes){
		this.listaMensajes=listaMensajes;
	}
	
	public void setAddMensaje(Mensajes mens){
		this.listaMensajes.add(mens);
	}
	
	
}
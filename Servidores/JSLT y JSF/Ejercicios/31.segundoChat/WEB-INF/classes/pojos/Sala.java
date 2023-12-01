package pojos;
import java.util.*;

public class Sala {
	private String nombreSala;
	private ArrayList<Mensajes> listaMensajes = new ArrayList<>();
	private HashMap <String,Usuario> usuariosConectados = new HashMap<>();
	
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
	
	public HashMap <String,Usuario> getUsuariosConectados(){
		return usuariosConectados;
	}
	
	public void setUsuariosConectados(HashMap <String,Usuario> usuariosConectados){
		this.usuariosConectados=usuariosConectados;
	}
	
	//----------------------------
	public void setListaMensajes(ArrayList <Mensajes> listaMensajes){
		this.listaMensajes=listaMensajes;
	}
	
	public void setAddMensaje(Mensajes mens){
		this.listaMensajes.add(mens);
	}
	
	public void setAddUsuario(Usuario usu){
		this.usuariosConectados.put(usu.getNick(),usu);
	}
	
	public void setEliminaUsu(Usuario usu){
		this.usuariosConectados.remove(usu.getNick());
	}
	
}
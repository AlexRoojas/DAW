package pojos;
import java.util.*;

public class Mensajes {
	private String nick;
	private String color;
	private String texto;
	
	
	public Mensajes () {
		this.nick = "indefinido";
		this.color = "indefinido";
		this.texto = "indefinido";
	}
	
	public Mensajes (String nick, String color, String texto) {
		this.nick = nick;
		this.color = color;
		this.texto = texto;
	}
	
	public String getNick(){
		return nick;
	}
	
	public void setNick(String nick){
		this.nick = nick;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getTexto(){
		return texto;
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	@Override
    public String toString() {
        return nick+": "+texto;
    }
	
}
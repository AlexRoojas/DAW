package pojos;
import java.util.*;

public class Usuario {
	private String nick;
	private String color;
	
	
	public Usuario () {
		this.nick = "indefinido";
		this.color = "indefinido";
	}
	
	public Usuario (String nick, String color) {
		this.nick = nick;
		this.color = color;
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
	
}
package pojos;
import pojos.*;
import java.util.*;

public class Usuario{
    
	String nombreUsuario;
	String direccion;
	int bonos;
	String listaFrasesTraducidas[]=new String[5];;
	String frasesOriginales[]=new String[5];
	int contador=0;
	
    public Usuario() {
		this.bonos=5;
		this.listaFrasesTraducidas=new String[5];
		this.frasesOriginales=new String[5];
    }
	
	public Usuario(String nombreUsuario){
		this.nombreUsuario=nombreUsuario;
		this.bonos=5;
		this.listaFrasesTraducidas=new String[5];
		this.frasesOriginales=new String[5];
	}
	
		public Usuario(String nombreUsuario,String direccion){
		this.nombreUsuario=nombreUsuario;
		this.direccion=direccion;
		this.bonos=5;
		this.listaFrasesTraducidas=new String[5];
		this.frasesOriginales=new String[5];
	}
	
	
	public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
	
	
	public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
	
	public int getBonos(){
		return bonos;
	}
	
	public void setBonos(int bonos){
		this.bonos=bonos;
	}
	
	public String[] getListaFrasesTraducidas(){
		return listaFrasesTraducidas;
	}
	
	public void setListaFrasesTraducidas(String listaFrasesTraducidas[]){
		this.listaFrasesTraducidas=listaFrasesTraducidas;
	}
	
	
	public String[] getFrasesOriginales(){
		return frasesOriginales;
	}
	
	public void setFrasesOriginales(String frasesOriginales[]){
		this.frasesOriginales=frasesOriginales;
	}
	
	public void setAniadirFrasesTraducidas(String frase,String frasesOriginal){
		if(contador<=4){
			listaFrasesTraducidas[contador]=frase;
			frasesOriginales[contador]=frasesOriginal;
			contador++;
		}
	}
	
    
}
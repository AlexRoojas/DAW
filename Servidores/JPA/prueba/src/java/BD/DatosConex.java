 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author lola
 */
public class DatosConex 
{
    private String conector;
    private String url;
    private String basedatos;
    private String usuario;
    private String pwd;

    public DatosConex() 
    {
        
    }
    
    public DatosConex(String conector, String url, String basedatos, String usuario, String pwd) 
    {
        this.conector = conector;
        this.url = url;
        this.basedatos = basedatos;
        this.usuario = usuario;
        this.pwd = pwd;
    }

    public String getConector() 
    {
        return conector;
    }

    public void setConector(String conector) 
    {
        this.conector = conector;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBasedatos() 
    {
        return basedatos;
    }

    public void setBasedatos(String basedatos) 
    {
        this.basedatos = basedatos;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getPwd() 
    {
        return pwd;
    }

    public void setPwd(String pwd) 
    {
        this.pwd = pwd;
    }
}

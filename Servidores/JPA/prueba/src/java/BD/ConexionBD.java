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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD 
{
    private  Connection conexion;
    
    public  ConexionBD (DatosConex dc)
    {
        
        try 
        {
            Class.forName(dc.getConector()).newInstance();
            String urlDef=dc.getUrl()+dc.getBasedatos();
            conexion=DriverManager.getConnection(urlDef,dc.getUsuario(),dc.getPwd());
        }
        catch (Exception sql) 
        {
            System.out.println(sql.getMessage());
        }
    }    
    
    public Connection getConexion()
    {
        return conexion;
    }
    public boolean cerrar()
    {
        try
        {
            conexion.close();
            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
    }
}
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DAO;

import com.daw.peliculasdaomanual.BD.ConexionBD;
import com.daw.peliculasdaomanual.BD.DatosConex;
import com.daw.peliculasdaomanual.DTO.Directores;
import com.daw.peliculasdaomanual.DTO.Peliculas;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DirectorDAO implements com.daw.peliculasdaomanual.Interfaces.InterfaceDAO{

    private DatosConex dconex;
    Connection con;
    
    public DirectorDAO() {

    }

    public DirectorDAO(DatosConex dconex) {
        this.dconex = dconex;
    }

    public DatosConex getDatosConexion() {
        return dconex;
    }

    public void setDatosConexion(DatosConex dconex) {
        this.dconex = dconex;
    }
    
    @Override
    public boolean create(Object obj) {
        
        Connection con;
        ConexionBD miConexion = new ConexionBD(dconex);
        con = miConexion.getConexion();
        
        Directores nuevoDirector=(Directores) obj;
        
        String sql;
        sql = "insert into director values (?,?,?)";
        String dni = nuevoDirector.getDni();
        String nom = nuevoDirector.getNombre();
        String nac = nuevoDirector.getNacionalidad();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, dni);
            ps.setString(3, nac);
            ps.execute();
        }catch (SQLException ex) {
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public Object read(String val) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        int dni = Integer.parseInt(val);
        String sql;
        sql = "select * from director where dni=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setInt(1, dni);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean update(Object obj) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        Directores dire = (Directores) obj;
        
        String nom = dire.getNombre();
        String nac = dire.getNacionalidad();

        String sql;
        sql = "Update director set nombre=?, nacionalidad=? where dni=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setString(1, nom);
            sent.setString(2, nac);
            sent.setString(3, dire.getDni());
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;        
    }

    @Override
    public boolean delete(String val) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        int dni = Integer.parseInt(val);
        String sql;
        sql = "Delete from director where dni=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setInt(1, dni);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    @Override
    public ArrayList consulta(String att, String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public ArrayList consulta() {
        
        
        Connection con;
        ConexionBD miConexion = new ConexionBD(dconex);
        con = miConexion.getConexion();
        
        String dni,nombre,nacionalidad;
        
        String sql = "select * from director";
        
        ArrayList listaDirectores = new ArrayList();
        
        try {    
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                dni=rs.getString("dni");
                nombre=rs.getString("nombre");
                nacionalidad=rs.getString("nacionalidad");
                Directores dir = new Directores(dni,nombre,nacionalidad);
                listaDirectores.add(dir);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DirectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDirectores;
        
    }

    
    
}

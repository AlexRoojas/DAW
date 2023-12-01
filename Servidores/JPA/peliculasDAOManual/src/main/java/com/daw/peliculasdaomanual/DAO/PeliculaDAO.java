/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DAO;

import com.daw.peliculasdaomanual.BD.ConexionBD;
import com.daw.peliculasdaomanual.BD.DatosConex;
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
public class PeliculaDAO implements com.daw.peliculasdaomanual.Interfaces.InterfaceDAO{

    private DatosConex dconex;
    Connection con;
    
    public PeliculaDAO() {

    }

    public PeliculaDAO(DatosConex dconex) {
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
        
        Peliculas nuevaPeli=(Peliculas) obj;
        
        String sql;
        sql = "insert into peliculas values ("+null+",?,?,?,?,?,?,?)";
        String nom = nuevaPeli.getNombre();
                String dir = nuevaPeli.getDirector();
                String gen = nuevaPeli.getGenero();
                String est = nuevaPeli.getEstreno();
                String  pub = nuevaPeli.getPublico();
                String fecha = nuevaPeli.getFecha_insercion();
                String imag=nuevaPeli.getImagen();
                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    //sent.setInt(1, codPeli);
                    ps.setString(1, nom);
                    ps.setString(2, dir);
                    ps.setString(3, gen);
                    ps.setString(4, est);
                    ps.setString(5, pub);
                    ps.setDate(6, java.sql.Date.valueOf(fecha));
                    ps.setString(7, imag);
                    ps.execute();
                }catch (SQLException ex) {
                    return false;
                } finally {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        return true;
    }

    @Override
    public Object read(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object obj) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        Peliculas peli = (Peliculas) obj;
        String gen = peli.getGenero();
        String est = peli.getEstreno();
        String pub = peli.getPublico();

        String sql;
        sql = "Update peliculas set genero=?, estreno=?,publico=? where codigo_pelicula=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setString(1, gen);
            if(est.equals("on")){
                sent.setString(2, "1");
            }else{
                sent.setString(2, "0");
            }
            
            if(pub.equals("on")){
                sent.setString(3, "1");
            }else{
                sent.setString(3, "0");
            }
            sent.setInt(4, peli.getCodigo_pelicula());
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;        
    }

    @Override
    public boolean delete(String val) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        int codigoPeli = Integer.parseInt(val);
        String sql;
        sql = "Delete from peliculas where codigo_pelicula=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setInt(1, codigoPeli);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        
        String nombre,director,genero,fecha,imagen,estreno,publico;
        int codigo;
        
        String sql = "select * from peliculas";
        
        ArrayList listaPelis = new ArrayList();
        
        try {    
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                codigo=rs.getInt("codigo_pelicula");
                nombre=rs.getString("nombre");
                director=rs.getString("director");
                genero=rs.getString("genero");
                estreno=rs.getString("estreno");
                publico=rs.getString("publico");
                fecha=rs.getString("fecha_insercion");
                imagen=rs.getString("imagen");
                Peliculas pelis = new Peliculas(codigo,nombre,director,genero,estreno,publico,fecha,imagen);
                listaPelis.add(pelis);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPelis;

    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasdaomanual.DAO;

import com.daw.peliculasdaomanual.BD.ConexionBD;
import com.daw.peliculasdaomanual.BD.DatosConex;
import com.daw.peliculasdaomanual.DTO.Directores;
import com.daw.peliculasdaomanual.DTO.Genero;
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
public class GeneroDAO implements com.daw.peliculasdaomanual.Interfaces.InterfaceDAO{

    private DatosConex dconex;
    Connection con;
    
    public GeneroDAO() {

    }

    public GeneroDAO(DatosConex dconex) {
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
        
        Genero nuevoGenero=(Genero) obj;
        
        String sql;
        sql = "insert into genero values (?,?)";
        int cod = nuevoGenero.getCodGen();
        String nom = nuevoGenero.getNomGen();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.setString(2, nom);
            ps.execute();
        }catch (SQLException ex) {
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public Object read(String val) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        int cod = Integer.parseInt(val);
        String sql;
        sql = "select * from genero where codGen=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setInt(1, cod);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean update(Object obj) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        Genero gene = (Genero) obj;
        
        String nomGen = gene.getNomGen();
        int codGen = gene.getCodGen();

        String sql;
        sql = "Update genero set nomGen=? where codGen=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setString(1, nomGen);
            sent.setInt(2, codGen);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;        
    }

    @Override
    public boolean delete(String val) {
        Connection cn;
        ConexionBD miConexion = new ConexionBD(dconex);
        cn = miConexion.getConexion();
        int codGen = Integer.parseInt(val);
        String sql;
        sql = "Delete from genero where codGen=?";
        try {
            PreparedStatement sent = cn.prepareStatement(sql);
            sent.setInt(1, codGen);
            sent.execute();
        } catch (SQLException ex) {
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        
        String nomGen;
        int codGen;
        
        String sql = "select * from genero";
        
        ArrayList listaGeneros = new ArrayList();
        
        try {    
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                codGen=rs.getInt("codGen");
                nomGen=rs.getString("nomGen");
                Genero gene = new Genero(codGen,nomGen);
                listaGeneros.add(gene);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaGeneros;
        
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peliculasv2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojos.Peliculas;

/**
 *
 * @author kete
 */
public class gestionaBD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con =conectar();
        
        Peliculas nuevaPeli=(Peliculas) request.getAttribute("peli");
        
        String op = request.getParameter("op");
        String sql;
        //int codPeli = Integer.parseInt(request.getParameter("codPeli"));
        //int codPeli2 = Integer.parseInt(request.getParameter("codigo_pelicula"));
        if (op.equals("alta")) {

                /*
                String nom = request.getParameter("nombre");
                String dir = request.getParameter("director");
                String gen = request.getParameter("genero");
                int est = Integer.parseInt(request.getParameter("estreno"));
                int pub = Integer.parseInt(request.getParameter("publico"));
                String fecha = request.getParameter("fecha");
                String imag = request.getParameter("imagen");*/
                
                String nom = nuevaPeli.getNombre();
                String dir = nuevaPeli.getDirector();
                String gen = nuevaPeli.getGenero();
                int est = nuevaPeli.getEstreno();
                int  pub = nuevaPeli.getPublico();
                String fecha=request.getParameter("fecha");                           
                String imag=nuevaPeli.getImagen();

                sql = "insert into peliculas values ("+null+",?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    //sent.setInt(1, codPeli);
                    ps.setString(1, nom);
                    ps.setString(2, dir);
                    ps.setString(3, gen);
                    ps.setInt(4, est);
                    ps.setInt(5, pub);
                    ps.setDate(6, java.sql.Date.valueOf(fecha));
                    ps.setString(7, imag);
                    ps.execute();
                } catch (Exception ex) {
                    ex.printStackTrace(out);
                }
                
            } else if(op.equals("borrar")){
                try {
                    
                    sql = "delete from peliculas where codigo_pelicula=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, nuevaPeli.getCodigo_pelicula());
                    ps.execute();
                } catch (SQLException ex) {
                    System.out.println("Error al borrar "+ex);
                }
            }else{
            try {
                sql="update peliculas set genero=?, estreno=?, publico=? where codigo_pelicula=?";
                    
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, request.getParameter("genero"));
                if(request.getParameter("estreno")!=null){
                     ps.setInt(2, 1);
                }else{
                    ps.setInt(2, 0);
                }
                
                if(request.getParameter("publico")!=null){
                     ps.setInt(3, 1);
                }else{
                    ps.setInt(3, 0);
                }
                
                ps.setInt(4,nuevaPeli.getCodigo_pelicula());
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(gestionaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

           
            String userName = "root";
            String password = "root";

           
            String url = "jdbc:mysql://localhost/peliculas";

           
            Connection c = DriverManager.getConnection(url, userName, password);
            return c;
        } catch (Exception e) {
            return null;
        }

    }
}

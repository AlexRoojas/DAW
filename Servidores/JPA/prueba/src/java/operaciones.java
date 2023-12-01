
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BD.ConexionBD;
import BD.DatosConex;
import bean.cPeliculas;
import metodos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lola
 */
public class operaciones extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        Connection cn = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            ServletContext contexto = getServletContext();
            DatosConex dc = (DatosConex) contexto.getAttribute("datosConexion");
            ConexionBD miConexion = new ConexionBD(dc);
            cn = miConexion.getConexion();
            cPeliculas peliNueva = (cPeliculas) request.getAttribute("peli");
            //   pool metodospool = new pool();
            //   cn =metodospool.dataSource.getConnection();

            out.println();
            /* TODO output your page here. You may use following sample code. */

            String op = request.getParameter("operacion");
            String sql;
            if (op.equals("alta")) {

                String nom = peliNueva.getNombre();
                String dir = peliNueva.getDirector();
                String gen = peliNueva.getGenero();
                int est = peliNueva.getEstreno();
                int pub = peliNueva.getPublico();
                String fecha = request.getParameter("fecha");
                java.util.Date f = Date.valueOf(fecha);
                peliNueva.setFecha_insercion(f);
                String imag = peliNueva.getImagen();

                sql = "Insert into peliculas Values (" + null + ",?,?,?,?,?,?,?)";
                try {
                    PreparedStatement sent = cn.prepareStatement(sql);
                    sent.setString(1, peliNueva.getNombre());
                    sent.setString(2, dir);
                    sent.setString(3, gen);
                    sent.setInt(4, est);
                    sent.setInt(5, pub);
                    sent.setDate(6, Date.valueOf(fecha));
                    sent.setString(7, imag);
                    sent.execute();
                } catch (Exception ex) {
                    ex.printStackTrace(out);
                }
                /* TODO output your page here. You may use following sample code. */
            } else {
                if (op.equals("modif")) {
                    sql="Update peliculas set  genero=?, estreno=?,publico=? where codigo_pelicula=?";
                    
                     PreparedStatement sent = cn.prepareStatement(sql);
                     sent.setString(1, peliNueva.getGenero());
                     sent.setInt(2, peliNueva.getEstreno());
                     sent.setInt(3, peliNueva.getPublico());
                     sent.setInt(4,peliNueva.getCodigo_pelicula());
                    sent.execute();
           
                } else {
                    try {
                        sql = "Delete from peliculas where codigo_pelicula=?";
                        PreparedStatement sent = cn.prepareStatement(sql);
                        sent.setInt(1, peliNueva.getCodigo_pelicula());
                        sent.execute();

                    } catch (SQLException ee) {
                    } finally {
                        try {
                            cn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace(out);
                        }
                    }
                    
                }
            }
        }
        catch (Exception e){}
    }
        
                
            

    

    public Connection conectar() {

        //Paso 1: Cargar el driver JDBC.
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
            String userName = "root";
            String password = "root";

            //URL de la base de datos(equipo, puerto, base de datos)
            String url = "jdbc:mysql://localhost:3306/peliculas";

            //String url="jdbc:mysql://192.168.9.247/peliculas";
            Connection c = DriverManager.getConnection(url, userName, password);
            return c;
        } catch (Exception e) {
            return null;
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

}

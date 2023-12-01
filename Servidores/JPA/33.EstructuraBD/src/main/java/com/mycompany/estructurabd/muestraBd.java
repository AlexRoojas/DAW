/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estructurabd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kete
 */
public class muestraBd extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String servEle = request.getParameter("servEle");
            
            Connection con = establecerConexion("localhost",servEle,"servidores","servidores");
            
            out.println(con);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet muestraBd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet muestraBd at " + request.getContextPath() + "</h1>");
            
            DatabaseMetaData dbmd=con.getMetaData();
           
            ResultSet rs=dbmd.getCatalogs();
            
            
            out.println("<p>Valores devueltos por getCatalogs()</p>");
            out.println("<table>");
            out.println("<tr><th>Nombre de todas las BD</th></tr>");
            while(rs.next()){
                out.println("<tr><td>"+rs.getNString(1)+"</td></tr>");
            }
            out.println("</table>");
            
            rs.close();
            
            out.println("<p>Valores devueltos por getTables()</p>");
            out.println("<table>");
            out.println("<tr><th>Nombre Base de Datos</th><th>Nombre Tabla</th></tr>");
            rs=dbmd.getTables(null, null,servEle, null);
            while(rs.next()){
                for (int i = 0; i < 4; i++) {
                     out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
                }
            }
            out.println("</table>");
            rs.close();
            
            out.println("<p>Valores devueltos por getColums()</p>");
            out.println("<table>");
            out.println("<tr><th>Nombre de la columna</th><th>Nombre Columna</th></tr>");
            rs=dbmd.getColumns(null, null,servEle, null);
            
            while(rs.next()){
                     out.println("<tr><td>"+rs.getString(4)+"</td><td>"+rs.getString(6)+"</td></tr>");
                
            }
            out.println("</table>");
            rs.close();
            
            out.println("<p>Datos básicos de una Consulta select: Select nombre,director,estreno from peliculas</p>");
            Statement stm = con.createStatement();
            rs = stm.executeQuery("select nombre,director,estreno fromo peliculas");
            
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                out.println(rs.getString(1));
            }
            
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(muestraBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static Connection establecerConexion(String servidor,String nombreBD,String usuario,String contrasena){
        Connection con=null;
        String url="";
        try {
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            url="jdbc:mysql://"+servidor+"/"+nombreBD;
            
            con=DriverManager.getConnection(url,usuario,contrasena);            
        } catch (SQLException ex) {
            System.out.println("\nSe ha producido un error al intentar conectarse a la bd "+ex.getMessage());
        }
        return con;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejecucionsentenciasdb2;

import static com.mycompany.ejecucionsentenciasdb2.ServletStatement.establecerConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaime
 */
public class ServletStatementMulti extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletStatementMulti</title>");            
            out.println("</head>");
            out.println("<body>");
            String sentencia = request.getParameter("segundoFormu");
            Connection con=establecerConexion("localhost","juegosreducidos","servidores","servidores");
            
            String [] sentenciasEjecutar = sentencia.split(";");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static Connection establecerConexion(String servidor,String nombreBD,String usuario,String contrasena){
        Connection con=null;
        String url="";
        try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                url="jdbc:mysql://localhost/"+nombreBD;
            con=DriverManager.getConnection(url,usuario,contrasena);            
        } catch (SQLException ex) {
            System.out.println("\nSe ha producido un error al intentar conectarse a la bd "+ex.getMessage());
        }
        return con;
    }
    
    public static void cerrarConexion(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("\nSe ha producido un error al cerrar la conexion "+ex.getMessage());
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

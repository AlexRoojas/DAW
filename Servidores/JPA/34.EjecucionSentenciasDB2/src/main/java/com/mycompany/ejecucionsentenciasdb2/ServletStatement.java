/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejecucionsentenciasdb2;

import static com.mycompany.ejecucionsentenciasdb2.ServletBatch.establecerConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * @author jaime
 */
public class ServletStatement extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            Connection con=establecerConexion("localhost","juegosreducidos","servidores","servidores");
            String sentencia = request.getParameter("segundoFormu");
            
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sentencia);
            out.println("<table>");
            while(rs.next()){
                out.println("<tr>");
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    out.print("<td>"+rs.getObject(i)+"</td>"); 
                }
                out.println("</tr>");
            }
            out.println("</table>");
            rs.close();
            st.close();
            con.close();
            
            out.println("has acabado");
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletStatement</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletStatement at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
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

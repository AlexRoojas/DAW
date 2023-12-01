/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejecucionsentenciasbd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * @author kete
 */
public class multiState extends HttpServlet {

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
            Connection con=establecerConexion("localhost","peliculas","servidores","servidores");
            String comandos = request.getParameter("state2");
            
            if(con!=null){
            try {
               Statement st=con.createStatement();
               boolean resultado = st.execute(comandos); //True : se ha ejecutao select
                                                         //False: update
               while(resultado || st.getUpdateCount()!=-1){
                   if(st.getUpdateCount()!=-1){
                       
                   }else{
                       ResultSet rs = st.getResultSet();
                       while(rs.next()){
                           System.out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
                       }
                       out.println("</table>");
                   }
               }
                
                
                st.close();
                con.close();
                out.println("Se ha añadido");
                out.println("<form action='index.html'>");
                out.println("<input type='submit' value='volver'>");
                out.println("</form>");
                
            } catch (SQLException ex) {
                Logger.getLogger(multiState.class.getName()).log(Level.SEVERE, null, ex);
            }   
               
            }else{
                out.println("Error al conectar");
            }
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

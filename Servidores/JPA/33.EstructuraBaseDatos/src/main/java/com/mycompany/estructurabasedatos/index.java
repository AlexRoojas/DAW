/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estructurabasedatos;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * @author Usuario
 */
public class index extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet index</title>"); 
                out.println("<style>");
                    out.println("table,tr,td{border:1px solid black}");
                out.println("</style>");
            out.println("</head>");
            out.println("<body>");
           
        try{
            Connection con=establecerConexion("MySql","localhost","peliculas","servidores","servidores");
            
            
            if(con!=null){
                DatabaseMetaData metaDatos=(DatabaseMetaData) con.getMetaData();

                ResultSet rs=metaDatos.getCatalogs();

                out.println("<table>");
                out.println("<tr><th>Nombre de la BD</th></tr>");
                while(rs.next()){
                     out.println("<tr>");
                     out.println("<td>"+rs.getString(rs.getMetaData().getColumnCount())+"</td>");
                     out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br>");
                
                rs.close();
                
                rs=metaDatos.getTables(null,null,"peliculas",null);
                out.println("<table>");
                out.println("<tr><th>getColumns()</th></tr>");
                while (rs.next()) {
                     out.println("<tr>");
                        for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                         out.println("<td>"+rs.getString(i)+"</td>");
                        }
                     out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br>");
                
               rs.close();
               
               rs=metaDatos.getColumns("peliculas", null, null, null);
               out.println("<table>");
               out.println("<tr><th>getColumns()</th></tr>");
               while(rs.next()){
                   out.println("<tr>");
                        out.println("<td>"+rs.getString(4)+"</td><td>"+rs.getString(6)+"</td>");
                   out.println("</tr>");
               }
               out.println("</table>");
               out.println("<br>");
               
               rs.close();
               
               Statement sentencia=con.createStatement();
               rs=sentencia.executeQuery("select nombre,director,estreno from peliculas");
               
               out.println("<br>");
               out.println("<table>");
               out.println("<tr><th>SENTENCIA SELECT EJECUTADA: select nombre,director,estreno from peliculas</th></tr>");
               while(rs.next()){
                   out.println("<tr>");
                   for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                        out.println("<td>"+rs.getObject(i)+"</td>");
                   }
                    out.println("</tr>");
               }
                 out.println("</table>");
                
            }
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.println("</body>");
        out.println("</html>");
        
    }
    
    public static Connection establecerConexion(String tipoBD,String servidor,String nombreBD,String usuario,String contrasena){
        Connection con=null;
        String url="";
        try {
            if(tipoBD.equalsIgnoreCase("Oracle")){
              //  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                //url="jdbc:oracle:thin:@"+servidor+":1521:"+nombreBD;
            }else{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                url="jdbc:mysql://"+servidor+"/"+nombreBD;
            }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.daw.peliculasdaomanual.BD.ConexionBD;
import com.daw.peliculasdaomanual.BD.DatosConex;
import com.daw.peliculasdaomanual.DAO.PeliculaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 *
 * @author kete
 */
public class cargaBD extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        DatosConex dc=(DatosConex)session.getAttribute("datCon");
        PeliculaDAO peliculas= new PeliculaDAO(dc);
        
        ArrayList listaPelis = peliculas.consulta();
        
        
        
        session.setAttribute("miPeli",listaPelis);
        /*
        ServletContext contexto= getServletContext();
        DatosConex dc=(DatosConex)contexto.getAttribute("datCon");
        ConexionBD miConexion=new ConexionBD(dc);
        Connection con = miConexion.getConexion();
        
        try {
            Statement stm = con.createStatement();
            String sentencia = "select * from peliculas";
            ResultSet rs = stm.executeQuery(sentencia);
            Result r = ResultSupport.toResult(rs);
            
            request.setAttribute("miPeli", r);
           
        } catch (SQLException ex) {
            Logger.getLogger(cargaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
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

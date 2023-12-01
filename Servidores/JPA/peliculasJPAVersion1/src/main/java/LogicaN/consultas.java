/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaN;

import com.daw.peliculasjpaversion1.DAO.PeliculasJpaController;
import com.daw.peliculasjpaversion1.DTO.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class consultas extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet consult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet consult at " + request.getContextPath() + "</h1>");
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("peliculasJPAVersion1PU");
            PeliculasJpaController ctrlPeli = new PeliculasJpaController(emf);
            
            List <Peliculas> lista = ctrlPeli.peliculasPorGenero("DRAMA");
            for(Peliculas p:lista){
                
            }
            
            List <Peliculas> lista2 = ctrlPeli.peliculasPorGenEst("AVENTURAS",true);
            for(Peliculas p2:lista2){
                
            }
            
            List listaPeliDirector = ctrlPeli.peliculaDirector();
            for(Object o:listaPeliDirector){
                Object [] pObj = (Object[])o;
                out.println(pObj[0]+"---");
                out.println(pObj[1]+"<br>");
            }
            
            List generos = ctrlPeli.consultaNativa();
            
            
            out.println("</body>");
            out.println("</html>");
        
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

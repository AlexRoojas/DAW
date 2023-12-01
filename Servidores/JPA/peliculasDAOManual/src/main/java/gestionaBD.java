/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.daw.peliculasdaomanual.BD.DatosConex;
import com.daw.peliculasdaomanual.DAO.DirectorDAO;
import com.daw.peliculasdaomanual.DAO.GeneroDAO;
import com.daw.peliculasdaomanual.DAO.PeliculaDAO;
import com.daw.peliculasdaomanual.DTO.Directores;
import com.daw.peliculasdaomanual.DTO.Genero;
import com.daw.peliculasdaomanual.DTO.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        HttpSession session = request.getSession();
        DatosConex dc=(DatosConex)session.getAttribute("datCon");
        PeliculaDAO peliculas= new PeliculaDAO(dc);
        
        Peliculas nuevaPeli=(Peliculas) request.getAttribute("peli");
        String codPeli = request.getParameter("codigo_pelicula");
        
        DirectorDAO directores = new DirectorDAO(dc);
        Directores nuevoDirector = (Directores) request.getAttribute("misDirectores");
        String dni = request.getParameter("dni");
        
        String proce = request.getParameter("viene");
        
        
        GeneroDAO generos = new GeneroDAO(dc);
        Genero nuevoGen = (Genero) request.getAttribute("listaGeneros");
        
        
        String op = request.getParameter("op");
        if(proce.equals("direc")){
            if (op.equals("alta")) {
                directores.create(nuevoDirector);
            }else if(op.equals("borrar")){
                directores.delete(dni);
            }else if(op.equals("buscar")){
                directores.read(dni);
            }else{
                directores.update(nuevoDirector);
        }
        }else{
            if (op.equals("alta")) {
                peliculas.create(nuevaPeli);
                generos.create(nuevoGen);
                //out.println(nuevaPeli.getNombre());
            }else if(op.equals("borrar")){
                peliculas.delete(codPeli);
            }else{
                peliculas.update(nuevaPeli);
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

}

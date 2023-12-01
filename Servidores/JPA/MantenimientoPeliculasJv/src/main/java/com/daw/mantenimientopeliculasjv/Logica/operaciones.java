/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.mantenimientopeliculasjv.Logica;

import com.daw.mantenimientopeliculasjv.DAO.PeliculasJpaController;
import com.daw.mantenimientopeliculasjv.DAO.exceptions.NonexistentEntityException;
import com.daw.mantenimientopeliculasjv.DTO.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        response.setContentType("text/html;charset=UTF-8");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("peliculasJPU");
        PeliculasJpaController ctrlPelis = new PeliculasJpaController(emf);
        
        List cabeceras = ctrlPelis.obtenerCabeceras();//listado de los headers
        request.setAttribute("cabeceras", cabeceras);
        
        List listaPelis = ctrlPelis.findPeliculasEntities();//listado de la tabla de pelis
        request.setAttribute("listaPelis", listaPelis);
        
        Peliculas nuevaPeli=(Peliculas) request.getAttribute("mipeli");
        
        String op = request.getParameter("op");
        if(op!=null){
            switch (op){
            case "Borrar":
                 {
                    try {
                        ctrlPelis.destroy(Integer.parseInt(request.getParameter("codigoPelicula")));
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            break;
            case "Modificar":{
                try {
                    ctrlPelis.edit(nuevaPeli);
                } catch (Exception ex) {
                    Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Alta":{
                ctrlPelis.create(nuevaPeli);
            }
            break;
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

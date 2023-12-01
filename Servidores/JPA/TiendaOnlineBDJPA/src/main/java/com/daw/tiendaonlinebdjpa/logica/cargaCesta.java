/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.tiendaonlinebdjpa.logica;

import com.daw.tiendaonlinebdjpa.DAO.ArticuloJpaController;
import com.daw.tiendaonlinebdjpa.DAO.DetalleJpaController;
import com.daw.tiendaonlinebdjpa.DAO.VistadetalleJpaController;
import com.daw.tiendaonlinebdjpa.DTO.Articulo;
import com.daw.tiendaonlinebdjpa.DTO.Detalle;
import com.daw.tiendaonlinebdjpa.DTO.Factura;
import com.daw.tiendaonlinebdjpa.DTO.Vistadetalle;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kete
 */
public class cargaCesta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        HttpSession miSesion = request.getSession();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("juegos");
        VistadetalleJpaController ctrlVista = new VistadetalleJpaController(emf);
        
        String usuario = (String)miSesion.getAttribute("usuario");
        
        List listaVista = ctrlVista.verLista(usuario);
        request.setAttribute("listaVista", listaVista);
        
        
        
        
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

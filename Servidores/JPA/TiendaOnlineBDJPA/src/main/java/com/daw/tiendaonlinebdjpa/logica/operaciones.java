/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.tiendaonlinebdjpa.logica;

import com.daw.tiendaonlinebdjpa.DAO.ArticuloJpaController;
import com.daw.tiendaonlinebdjpa.DAO.DetalleJpaController;
import com.daw.tiendaonlinebdjpa.DTO.Articulo;
import com.daw.tiendaonlinebdjpa.DTO.Detalle;
import com.daw.tiendaonlinebdjpa.DTO.DetallePK;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author kete
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
            throws ServletException, IOException{
       
        HttpSession miSesion = request.getSession();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("juegos");
        ArticuloJpaController ctrlArticulo = new ArticuloJpaController(emf);
        DetalleJpaController ctrlDetalle = new DetalleJpaController(emf);
        
        Detalle miDetalle = (Detalle)request.getAttribute("miDetalle");
        //Detalle miDetalle = (Detalle)miSesion.getAttribute("miDetalle");
        
        String usuario = (String)miSesion.getAttribute("usuario");
        
        String op = request.getParameter("op");
        if(op!=null){//--------------------------------PARA LA CESTA----------------------------------------------------------
            int codArt = Integer.parseInt(request.getParameter("codArticulo"));
            Articulo miArt = ctrlArticulo.findArticulo(codArt);
        
            Detalle detalleEx = ctrlDetalle.findDetalle(new DetallePK(usuario,codArt));
            if(op.equalsIgnoreCase("mas")){
                if(detalleEx.getCantidad()<miArt.getExistencias()){
                    detalleEx.setCantidad(detalleEx.getCantidad()+1);
                    int nuevaExistencias = miArt.getExistencias()-1;
                    miArt.setExistencias(nuevaExistencias);

                }
            }else{
                if(op.equalsIgnoreCase("menos")){
                    if(detalleEx.getCantidad()<miArt.getExistencias()){
                        detalleEx.setCantidad(detalleEx.getCantidad()-1);
                        int nuevaExistencias = miArt.getExistencias()+1;
                        miArt.setExistencias(nuevaExistencias);
                    }
            }
            }
            
            try {
                    ctrlDetalle.edit(detalleEx); //actualizamos
                    ctrlArticulo.edit(miArt);
                } catch (Exception ex) {
                    Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        }else{
//------------------------------------------------PARA LA TIENDA ----------------------------------------------------------------
        if(request.getParameter("cantidad")!=null){
            int codArt = Integer.parseInt(request.getParameter("codArticulo"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            Articulo miArt = ctrlArticulo.findArticulo(codArt);
            
            if(cantidad <= miArt.getExistencias()){ //controlador para no comprar más de las existencias
                Detalle detalleEx = ctrlDetalle.findDetalle(miDetalle.getDetallePK());
                
                if(detalleEx!=null){//Comprobamos que exista
                    int cantidadActual = detalleEx.getCantidad()+cantidad; //sumamos las cantidades antiguas con las nuevas
                    detalleEx.setCantidad(cantidadActual); //añadimos
                    try {
                        ctrlDetalle.edit(detalleEx); //actualizamos
                    } catch (Exception ex) {
                        Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                    // si no existe, creamos la nueva fila
                    ctrlDetalle.create(miDetalle);
                    } catch (Exception ex) {
                        Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                int nuevaExistencias = miArt.getExistencias()-cantidad;
                miArt.setExistencias(nuevaExistencias);
                try {
                    ctrlArticulo.edit(miArt); //actualizamos las existencias que hay del articulo al comprar
                } catch (Exception ex) {
                    Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //ctrlArticulo.compraArt(codArt, cantidad); 
        }
        }//if
      
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.peliculasjpaversion1.LogicaN;

import com.daw.peliculasjpaversion1.DAO.GeneroJpaController;
import com.daw.peliculasjpaversion1.DAO.PeliculasJpaController;
import com.daw.peliculasjpaversion1.DTO.Genero;
import com.daw.peliculasjpaversion1.DTO.Peliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
 * @author usuario
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
            out.println("<title>Servlet consultas</title>");
            out.println("<style>");
            out.println("table{\n" +
"                border: 2px solid black ;\n" +
"                width:90%;\n" +
"                margin: 0 auto;\n" +
"                border-collapse: collapse;\n" +
"            }\n" +
"            tbody tr{\n" +
"                border-bottom:  solid lightgray 1px;\n" +
                    
"            }"
                    + "img{width:50px;heigth:60px}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet consultas at " + request.getContextPath() + "</h1>");
            EntityManagerFactory emf =Persistence.createEntityManagerFactory("peliculasJPAVersion1PU");
            PeliculasJpaController ctrPeliculas =new PeliculasJpaController(emf);
            GeneroJpaController ctrGeneros =new GeneroJpaController(emf);
            
            List<Peliculas> listaPelis = ctrPeliculas.findPeliculasEntities();
            //List<Genero> listaGenero = ctrGeneros.findGeneroEntities();
            Object[] cabeceras = ctrPeliculas.cabeceras();
            
            
            
            out.println("<table>");
            out.println("<tr>");
            for (Object cabe : cabeceras) {
            
                out.println("<th>"+cabe.toString()+"</th>");
            
            }
            out.println("</tr>");
            for (Peliculas lp : listaPelis) {
                out.println("<tr>");
                out.println("<form action=''>");
                out.println("<td>"+lp.getCodigoPelicula()+"</td>");
                out.println("<input type='hidden' value='"+lp.getCodigoPelicula()+"'>");
                out.println("<td>"+lp.getNombre()+"</td>");
                out.println("<td>"+lp.getDirector()+"</td>");
                out.println("<td>"+lp.getGenero()+"</td>");
                
                /*out.println("<td><select name='genero'></td>");
                
                for (Genero lg : listaGenero) {
                    if(lg.getGenero()==lp.getGenero()){
                        
                    }else{
                        out.println("<option vale='"+lg.getGenero()+"'>"+lp.getGenero()+"");
                    }
                }*/
                
                if(lp.getEstreno()==true){
                    out.println("<td><input type='checkbox' name='estreno' value='1' checked></td>");
                }else{
                    out.println("<td><input type='checkbox' name='estreno' value='0'></td>");
                }
                if(lp.getPublico()==true){
                    out.println("<td><input type='checkbox' name='public' value='1' checked></td>");
                }else{
                    out.println("<td><input type='checkbox' name='public' value='0'></td>");
                }
                out.println("<td>"+new SimpleDateFormat("dd-MM-yyyy").format(lp.getFechaInsercion())+"</td>");
                out.println("<td><img src='img/"+lp.getImagen()+"'></td>");
                out.println("</form>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            /*List <Peliculas> lista =  ctrPeliculas.peliculasPorGenero("drama");
            
            for (Peliculas p:lista){
                
            }
            List <Peliculas> lista2=ctrPeliculas.consultaMixta("aventuras", true);
            for (Peliculas p: lista2){
                
            }
            List ListaPeliDirector=  ctrPeliculas.peliculaDirector();
            for  (Object o:ListaPeliDirector){
               Object [] aObj=(Object [])o;
               out.println(aObj[0]+ "---");
                 out.println(aObj[1]+ "</br>");      
            }*/
            
          
                    
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

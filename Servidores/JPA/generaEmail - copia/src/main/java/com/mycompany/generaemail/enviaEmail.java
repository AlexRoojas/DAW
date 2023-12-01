/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generaemail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kete
 */
public class enviaEmail extends HttpServlet {

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
            out.println("<title>Servlet enviaEmail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet enviaEmail </h1>");
            
            //Creamos las propiedades del correo de gmail y tendremos que establecer las propiedades
            Properties propiedad = new Properties();
            propiedad.put("mail.smtp.host", "smtp.gmail.com");//host que quiero acceder 
            propiedad.put("mail.smtp.starttls.enable", true);//extensión a los protocolos de comunicación de texto plano (TLS)
            propiedad.put("mail.smtp.port", "587");//puerto que quiero acceder
            
            //Creamos la sesion
            Session sesion = Session.getDefaultInstance(propiedad);//con las propiedades me permitira conectarme a una cuenta de gmail
            
            
            //Establecemos el correo desde el que estamos enviando el correo (remitente)
            String userRemi = "correo@gmail.com";
            String contraRemi = "contraseña";
            
            //Obtenemos los parametros recibidos del formulario
            String nombre = request.getParameter("nombre"); 
            String email = request.getParameter("email");
            String asunto = request.getParameter("asunto");
            String mensaje = request.getParameter("mensaje");
            
            //Vamos a crear el objeto que tiene todas las propiedades creadas
            MimeMessage mail = new MimeMessage(sesion);
            
            try {
                mail.setFrom(new InternetAddress(userRemi)); //desde donde estamos enviando el correo
                //se puede usar addRecipent y setRecipent
                
                //hay varias opciones con el tipo (TO, CC, BCC)
                mail.setRecipients(Message.RecipientType.TO, email);
                mail.setSubject(asunto);//asunto
                String texto = "De: "+nombre+" , "+userRemi+".\n"+mensaje;
                mail.setText(texto);//mensaje
                
                //Para poder ejecutarlo necesitaremos el Transport
                
                Transport transporte = sesion.getTransport("smtp"); //smtp es el servidor de salida
                transporte.connect("smtp.gmail.com",userRemi,contraRemi);//hacemos la conexion
                transporte.sendMessage(mail, mail.getAllRecipients());//enviamos el mensaje y usamos el allrecipents para getear todos los tipos de envio de correo
                transporte.close();
                
                
                
            } catch (MessagingException ex) {
                Logger.getLogger(enviaEmail.class.getName()).log(Level.SEVERE, null, ex);
                out.println("<h1 style='color:red;'>Error al generar el email</h1>");
            }
            
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

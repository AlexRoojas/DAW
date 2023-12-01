package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class parametrosFormulario extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<link rel='stylesheet' href='estilo.css'/>");
		out.println("<title>Formulario</title>");
		out.println("</head>");
		
		
		out.println("<body> bgcolor='79C7B2'");
		
		String[] opcion=request.getParameterValues("opciones");
		
		out.println("<h1>Constructor de formularios</h1>");
		
			out.println("<form action='procesarFormulario'>");
		
		for(int i=0;i<opcion.length;i++){
			out.println("<label for="+opcion[i]+">"+opcion[i]+":</label>");
			out.println("<input type='text' name="+opcion[i]+"/>");
			<br>
			
		}
		
			out.println("<input type='submit' value='Montar XD'/>");
			out.println("</form>");
			
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
	
		proceso(request,response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		proceso(request,response);
	}
}
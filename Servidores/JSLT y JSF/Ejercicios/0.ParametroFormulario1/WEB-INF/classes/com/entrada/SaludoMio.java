package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class SaludoMio extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>App...</title>");
		out.println("</head>");
		
		out.println("<body>");
			
		String nombreR=request.getParameter("nombre");
		String apellidosR=request.getParameter("apellidos");
		String soR=request.getParameter("so");
		String idiomaR=request.getParameter("idioma");
		String deportesR=request.getParameter("deportes");
		
		out.println("Buenas tardes mi querido/a "+nombreR+" "+apellidosR+", tu sistema operativo es "+soR+" y tu idioma favorito es "+idiomaR+" y esta tarde vas a jugar al "+deportesR);
		

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
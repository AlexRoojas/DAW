package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Colores extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Colores</title>");
		
		out.println("<style>");
		out.println("#rojo{color:red} #amarillo{color:yellow} #morado{color:purple} #azul{color:blue}");
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body>");
			
		String nombreR=request.getParameter("nombre");
		String apellidosR=request.getParameter("apellidos");
		int edadR=Integer.parseInt(request.getParameter("edad"));
		
		String colores[]=request.getParameterValues("colores");
		
		out.println("<p>Buenas tardes mi querido/a "+nombreR+" "+apellidosR+" con edad "+edadR+"y tus colores favoritos son :</p>");
		
		for(int i=0;i<colores.length;i++){
			out.println("<span id='"+colores[i]+"'>"+colores[i]+"</span>");
		}
		
		

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
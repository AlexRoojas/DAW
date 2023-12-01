package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class procesarFormulario extends HttpServlet{
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
		
		
		out.println("<body bgcolor='#79C7B2'>");
		
		
		out.println("<h1>Formulario Dinamico</h1>");
		
		
		Enumeration resultado=request.getParameterNames();
		Enumeration resultado2=request.getParameterNames();
		
        while (resultado.hasMoreElements()) {
            String opcionElegida = (String)resultado.nextElement();
            out.println("<p>"+opcionElegida + " = " + request.getParameter(opcionElegida)+"</p>");
			
        }
		
		out.println("<h3>Listado de parametros y valores utilizando getParameterNames/getParameterValues</h3");
		while (resultado2.hasMoreElements()) {
            String name = (String)resultado2.nextElement();
            out.println("<p>"+name + " : "+request.getParameterValues(name)+" "+ request.getParameter(name)+"</p>");
			
        }
		
		out.println("<h3>Listado de parametros y valores utilizando getParameterMap/getParameter</h3");
		Map listaParam=request.getParameterMap();


			Iterator it=listaParam.keySet().iterator();
		
		while(it.hasNext()){
			String valorNombre=(String)it.next();
			out.println(valorNombre+": ");

			valoresParam= (String[]) listaParam.get(valorNombre);
			
		// 		valoresParam=request.getParameterValues(valorNombre)
 
			for(String valorP : valoresParam)
				{		
			
					out.println(valorP);			
				
				}
			}
			out.println("<br/>");
		
		

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
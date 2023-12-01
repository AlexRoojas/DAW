package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class procesarFormulario2 extends HttpServlet{
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
		
		out.println("<h1>get Parameter</h1>");
		
		Map mapaFormulario=request.getParameterMap();
		Iterator mapaIterable=mapaFormulario.keySet().iterator();
		
		String nombreFormulario="";
		String datosMapaFormulario[];
		
		
		while(mapaIterable.hasNext()){
			nombreFormulario=(String)mapaIterable.next();
			out.println(nombreFormulario+": "+request.getParameter(nombreFormulario));
			out.println("<br>");
		}
		
		
		out.println("<h1>Param Values</h1>");
		Enumeration  listaCampos=request.getParameterNames();
		
		String elemento="";
		String valoresElementos[];
		
		while(listaCampos.hasMoreElements()){
			
			 elemento=(String)listaCampos.nextElement(); 
			 valoresElementos=request.getParameterValues(elemento);
			 
			 for(int i=0;i<valoresElementos.length;i++){
				 out.println("<span>"+elemento+": "+valoresElementos[i]+"</span>");
			 }
			 out.println("<br>");
		}
		
		
		 mapaFormulario=request.getParameterMap();
		 mapaIterable=mapaFormulario.keySet().iterator();
		
		 nombreFormulario="";
		
		
		out.println("<h1>Parameter Map</h1>");//el mejor
		
		while(mapaIterable.hasNext()){
			
			nombreFormulario=(String)mapaIterable.next();
			datosMapaFormulario=(String[])mapaFormulario.get(nombreFormulario);
			
			out.println("<span>"+nombreFormulario+": </span>");
			for(int i=0;i<datosMapaFormulario.length;i++){
				out.println("<span>"+datosMapaFormulario[i]+"</span>");
			}
			
			out.println("<br>");
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
package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class parametrosFormulario2 extends HttpServlet{
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
		
		String[] opcion=request.getParameterValues("opciones");
		
		String nombreParam[] = request.getParameterValues("nombreParam");
		String valParam[] = request.getParameterValues("valParam");
		String tipoParam[] = request.getParameterValues("tipoParam");
		
		out.println("<form action='procesarFormulario2'>");
		
			for(int i=0;i<opcion.length;i++){
				out.println("<label for="+opcion[i]+">"+opcion[i]+":</label>");
				out.println("<input type='text' name="+opcion[i]+"/>");
				out.println("<br>");
				
			}
		out.println("<br>");
		for(int i = 0; i< nombreParam.length;i++ ) {
			
			
			String nombres = nombreParam[i];
			String valores = valParam[i];
			String tipos = tipoParam[i];
			
			if( nombres != "" && valores!=""){
				out.println(nombres + ": <br>");
				
				creaFormulario(nombres,valores,tipos,out);
			}
			
		}
		
		out.println("<input type='submit' value='Montar XD'/>");
		out.println("</form>");
		
		
		
	}
	public void  creaFormulario(String nombres, String valores, String tipos, PrintWriter out){
	
			out.println("<br>");
			String[]valParamSplit = valores.split(";");
			
				if(tipos.equals ("select") || tipos.equals("multiple")){
					out.println("<select size='"+valParamSplit.length+"' name='"+nombres+"' "+ tipos +">");
					for(String valor : valParamSplit){
						out.println("<option value='"+valor+"'>"+valor+"</option>");
					}
					out.println("</select>");
					out.println("<br>");
				}else{
					for(String valor : valParamSplit){
						out.println("<input type='"+tipos+"' name='"+nombres+"' value='"+valor+"'>");
						out.println("<label for="+nombres+">"+ valor +"</label><br>");
					}
					out.println("<br>");
				}
			
			
		
				
		
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
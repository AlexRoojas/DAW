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
		
		String nombre1 = request.getParameter("nombre1");
		String valores1 = request.getParameter("valores1");
		String[]valores1Split = valores1.split(";");
		String selcList1 = request.getParameter("selcList1");
		
		String nombre2 = request.getParameter("nombre2");
		String valores2 = request.getParameter("valores2");
		String[]valores2Split = valores2.split(";");
		String selcList2 = request.getParameter("selcList2");
		
		String nombre3 = request.getParameter("nombre3");
		String valores3 = request.getParameter("valores3");
		String[]valores3Split = valores3.split(";");
		String selcList3 = request.getParameter("selcList3");
		
		
		
		out.println("<h3>Rellene los siguientes campos</h3>");
		
			out.println("<form action='procesarFormulario2'>");
		
			for(int i=0;i<opcion.length;i++){
				out.println("<label for="+opcion[i]+">"+opcion[i]+":</label>");
				out.println("<input type='text' name="+opcion[i]+"/>");
				out.println("<br>");
				
			}
			
			out.println("<br>");
			
			/*if(nombre1!=""){
				out.println("<select size='"+valores1Split.length+"' name='"+nombre1+"' "+ selcList1 +">");
				for(String valor : valores1Split){
					out.println("<option value='"+valor+"'>"+valor+"</option>");
				}
				out.println("</select>");
				if(nombre2!=""){
					out.println("<select size='"+valores2Split.length+"' name='"+nombre2+"' "+ selcList2 +">");
				for(String valor2 : valores2Split){
					out.println("<option value='"+valor2+"'>"+valor2+"</option>");
				}
				out.println("</select>");
					if(nombre3!=""){
						out.println("<select size='"+valores3Split.length+"' name='"+nombre3+"' "+ selcList3 +">");
						for(String valor3 : valores3Split){
						out.println("<option value='"+valor3+"'>"+valor3+"</option>");
						}
						out.println("</select>");
					}
				}
					
			}*/
			
			if(nombre1!=""){
				if(selcList1.equals ("select") || selcList1.equals("multiple")){
					out.println("<select size='"+valores1Split.length+"' name='"+nombre1+"' "+ selcList1 +">");
					for(String valor : valores1Split){
						out.println("<option value='"+valor+"'>"+valor+"</option>");
					}
					out.println("</select>");
					out.println("<br>");
				}else{
					for(String valor : valores1Split){
						out.println("<input type='"+selcList1+"' name='"+nombre1+"' value='"+valor+"'>");
						out.println("<label for="+nombre1+">"+ valor +"</label><br>");
					}
					out.println("<br>");
				}if(nombre2!=""){
					if(selcList2.equals ("select") || selcList2.equals("multiple")){
					out.println("<select size='"+valores2Split.length+"' name='"+nombre2+"' "+ selcList2 +">");
					for(String valor2 : valores2Split){
						out.println("<option value='"+valor2+"'>"+valor2+"</option>");
					}
					out.println("</select>");
					out.println("<br>");
				}else{
					for(String valor2 : valores2Split){
						out.println("<input type='"+selcList2+"' name='"+nombre2+"' value='"+valor2+"'>");
						out.println("<label for="+nombre2+">"+ valor2 +"</label><br>");
					}
					out.println("<br>");
					}if(nombre3!=""){
						if(selcList3.equals ("select") || selcList3.equals("multiple")){
						out.println("<select size='"+valores3Split.length+"' name='"+nombre3+"' "+ selcList3 +">");
						for(String valor3 : valores3Split){
							out.println("<option value='"+valor3+"'>"+valor3+"</option>");
						}
						out.println("</select>");
						out.println("<br>");
					}else{
						for(String valor3 : valores3Split){
							out.println("<input type='"+selcList3+"' name='"+nombre3+"' value='"+valor3+"'>");
							out.println("<label for="+nombre3+">"+ valor3 +"</label><br>");
						}
						out.println("<br>");
					}
					}//if 3
				
				
				}//if 2
				
				
					
			}//if
			
		
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
package infCabecera;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class cabecera extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Formulario</title>");
		out.println("<style>");
		out.println("table, tr, td{border: solid black 1px;}");
		out.println("body{background-color: #79C7B2;}");
		out.println("</style>");
		out.println("</head>");
		
		
		out.println("<body bgcolor='#79C7B2'>");
		
		out.println("<h2>Relacion de metodos especificos para la lectura de cabecera</h2>");
		
		int tamanoContenido = request.getContentLength();
		out.println("<p>1.- Metotodo que devuelve la longitud del cuerpo de la petición: getContentLength() :"+tamanoContenido+"</p>");
		
		String tipoContenido = request.getContentType();
		out.println("<p>2.- Metotodo que devuelve los tipos de datos presentes en el cuerpo de la peticion: getContentType() :"+tipoContenido+"</p>");
		
		Locale lenguage =request.getLocale();
		out.println("<p>3.- Metotodo que devuelve el lenguaje preferido del navegador: getLocale() :"+lenguage+"</p>");
		
		Enumeration<Locale> paisesDisponibles =request.getLocales();
		out.println("<p>4.- Idioma aceptado por el navegador: getLocales() :"+paisesDisponibles+"</p>");
		
		out.println("<p>5.- Listado de idiomas:</p>");
		
		Locale valores;
		String idiomas[];
		
		out.println("<table>");
		
		while(paisesDisponibles.hasMoreElements()){
			valores=paisesDisponibles.nextElement();
			out.println("<tr>");
			
			out.println("<td>"+valores.getLanguage()+"</td>"); 
			out.println("<td>"+valores.getDisplayLanguage()+"</td>"); 
			out.println("<td>"+valores.getDisplayCountry()+"</td>"); 
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br>");
		
		Enumeration <String> cabeceras = request.getHeaderNames();
		String elementos = "";
		String tabla="";
		
		
		out.println("<table>");
		while(cabeceras.hasMoreElements()){
			elementos=cabeceras.nextElement();
			
			out.println("<tr>");
			out.println("<td>"+elementos+"</td>"); 
			out.println("<td>"+request.getHeader(elementos)+"</td>"); 
			out.println("</tr>");
		}
		
		
		out.println("</table>");
		
		out.println("<br>");
		out.println("<a href='index.html'>Volver</a>");
		out.println("<a href='sal?procedencia=cabecera'>Salir</a>");
		
		
		
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
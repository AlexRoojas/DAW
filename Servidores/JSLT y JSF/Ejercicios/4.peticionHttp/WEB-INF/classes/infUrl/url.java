package infUrl;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class url extends HttpServlet{
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
		out.println("Obtiene el nombre del servidor (getServerName): ");
		out.println(request.getServerName());
		out.println("<br>");
		out.println("Obtiene el puerto del servidor (getServerPort): ");
		out.println(request.getServerPort());
		out.println("<br>");
		out.println("Recibe el nombre de la aplicación en el servidor(getContextPath): ");
		out.println(request.getContextPath());
		out.println("<br>");
		out.println("Identifica el serverlet dentro de una aplicación (getServletPath): ");
		out.println(request.getServletPath());
		out.println("<br>");
		out.println("Devuelve el tipo de peticion http para contactar con el serverlet (getMethod): ");
		out.println(request.getMethod());
		out.println("<br>");
		out.println("Obtiene los parámetros pasados en la petición(getQueryString): ");
		out.println(request.getQueryString());
		out.println("<br>");
		out.println("Proporciona la URL completa usada para contactar con el serverlet(getRequestURL): ");
		out.println(request.getRequestURL());
		out.println("<br>");
		out.println("Retorna la dirección IP del servidor (getLocalAddr): ");
		out.println(request.getLocalAddr());
		out.println("<br>");
		out.println("Obtiene el nombre del servidor (getLocalName): ");
		out.println(request.getLocalName());
		out.println("<br>");
		out.println("Obtiene el numero del puerto TCP (getLocalPort): ");
		out.println(request.getLocalPort());
		out.println("<br>");
		out.println("Devuelve la dirección IP del cliente (getRemoteAddr): ");
		out.println(request.getRemoteAddr());
		out.println("<br>");
		out.println("Devuelve el FQDN del cliente y el nombre de la máquina cliente (getRemoteHost): ");
		out.println(request.getRemoteHost());
		out.println("<br>");
		
		out.println("<br>");
		out.println("<a href='index.html'>Volver</a>");
		out.println("<a href='salida?procedencia=url'>Salir</a>");
		
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
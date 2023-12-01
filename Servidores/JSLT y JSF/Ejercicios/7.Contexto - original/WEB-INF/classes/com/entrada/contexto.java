package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class contexto extends HttpServlet{
	
	/*@Override
	public void init(ServerletConfig config) throws ServerletException{
		super.init(config);
		getServerletContext().setAttribute("inicioServer",new GregorianCalendar());
	}*/
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		getServletContext().setAttribute("horaInicio", new GregorianCalendar());
		GregorianCalendar calendarioAplicacion=(GregorianCalendar)getServletContext().getAttribute("horaInicio");
		
		int mes=((GregorianCalendar)getServletContext().getAttribute("horaInicio")).get(Calendar.MONTH)+1;//+1 porque es un array y empieza en 0
		int dia=((GregorianCalendar)getServletContext().getAttribute("horaInicio")).get(Calendar.DAY_OF_MONTH);
		
		GregorianCalendar calendario=(GregorianCalendar)getServletContext().getAttribute("horaArranque");
		
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Formulario</title>");
		out.println("<style>");
		out.println("body{text-align:center;}");
		
					if((mes==3&&dia>20) || mes==4 || mes==5 ||(mes==6&&dia<21)){
						out.println("body{background: url(imagenes/primavera.jpg) no-repeat; background-size:cover;}");
					}else if((mes==6&&dia>20) || mes==7 || mes==8 ||(mes==9&&dia<21)){
						out.println("body{background: url(imagenes/verano.jpg) no-repeat; background-size:cover;}");
					}else if((mes==9&&dia>20)|| mes==10 || mes==11 ||(mes==12&&dia<21)){
						out.println("body{background: url(imagenes/otono.jpg) no-repeat; background-size:cover;}");
					}else{
						out.println("body{background: url(imagenes/invierno.jpg) no-repeat; background-size:cover;}");
					}
					
					out.println("div{margin:0;width: 400px;background: white;opacity: 0.9;spadding: 5px;}");
					out.println("table{margin:0;border: solid black 1px; width: 80%; text-align:center;}");
					out.println("th{ color:white; background-color:black; opacity: 0.9; text-align: center;}");
					out.println("td{ color:white; background-color:black; opacity: 0.9; text-align: center;overflow: auto;max-width: 400px;}");
					
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body bgcolor='#79C7B2'>");
			ServletContext servlet =getServletContext();
		out.println("<div>");
			out.println("<p>Hora de arranque: "+calendario.getTime()+"</p>");
			out.println("<p>Hora de conexion: "+calendarioAplicacion.getTime()+"</p>");
		out.println("</div>");
		out.println("<table>");
		out.println("<tr><th>Metodo</th><th>Salida</th><th>Descripcion</th></tr>");
		//out.println("<tr><td>getServletContext()</td><td>"+servlet.getServletContext()+"</td><td>Devuelve un objeto de ServletContext que corresponde a una url especifica del servidor</td></tr>");
		//out.println("<tr><td>getServletConfig()</td><td>"+servlet.getServletConfig()+"</td><td>Devuelve un objeto ServletConfig que contiene los parámetros de inicio para el servlet</td></tr>");
		out.println("<tr><td>getAttribute()</td><td>"+servlet.getAttribute("horaArranque")+"</td><td>Devuelve el valor del atributo de contexto del servlet</td></tr>");
		out.println("<tr><td>getAttributeNames()</td><td>"+servlet.getAttributeNames()+"</td><td>Devuelve un Enumeration que contiene los nombres de los atributos disponibles dentro del ServletContext</td></tr>");
		out.println("<tr><td>getContextPath()</td><td>"+servlet.getContextPath()+"</td><td>Devuelve la ruta de contexto de la aplicacion web</td></tr>");
		out.println("<tr><td>getEffectiveMajorVersion()</td><td>"+servlet.getEffectiveMajorVersion()+"</td><td>Obtiene la version principal de la especificacion de Servlet en la que se basa la aplicacion representada por este ServletContext</td></tr>");
		out.println("<tr><td>getEffectiveMinorVersion()</td><td>"+servlet.getEffectiveMinorVersion()+"</td><td>Este devuelve la secundaria de lo de antes</td></tr>");
		out.println("<tr><td>getMajorVersion()</td><td>"+servlet.getMajorVersion()+"</td><td>Devuelve la version principal de la API de servlet que admite este contenedor de servlet</td></tr>");
		out.println("<tr><td>getRequestCharacterEncoding()</td><td>"+servlet.getRequestCharacterEncoding()+"</td><td>Obtiene la codificacion de caracteres de solicitud que se admite de forma predeterminada para este ServletContext</td></tr>");
		out.println("<tr><td>getServerInfo()</td><td>"+servlet.getServerInfo()+"</td><td>Devuelve el nombre y la version del contenedor de servlet en el que se ejecuta el servlet</td></tr>");
		out.println("<tr><td>getSessionCookieConfig()</td><td>"+servlet.getSessionCookieConfig()+"</td><td>Obtiene el objeto SessionCookieConfig a través del cual se pueden configurar varias propiedades de las cookies de seguimiento de sesion creadas en nombre de este ServletContext</td></tr>");
		out.println("<tr><td>getSessionTimeout()</td><td>"+servlet.getSessionTimeout()+"</td><td>Obtiene el tiempo de espera de la sesion en minutos que se admite de forma predeterminada para este ServletContext</td></tr>");
		out.println("<tr><td>getFilterRegistrations()</td><td>"+servlet.getFilterRegistrations()+"</td><td>Obtiene un mapa (posiblemente vacio) de los objetos FilterRegistration (codificados por el nombre del filtro) correspondiente a todos los filtros registrados con este ServletContext. </td></tr>");
		out.println("</table>");
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
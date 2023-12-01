
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class creaCookies extends HttpServlet{
	
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
			
		
		String escuderias[] =request.getParameterValues("escuderia");
		
		ServletContext contexto = getServletContext();
		
		String nombre = (String)contexto.getAttribute("nomUsu");
		
		
		String stringEsc="";
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>El usuario "+nombre+" ha seleccionado los siguientes articulos:</h3>");
		
		out.println("<ul>");
		for(int i=0;i<escuderias.length;i++){
			out.println("<li>"+escuderias[i]+"</li>");
			stringEsc+= escuderias[i]+"_";
			
		}
		out.println("</ul>");
		
		stringEsc = stringEsc.substring(0,stringEsc.length()-1);
		nombre += "_art";
		
		Cookie c = new Cookie(nombre,stringEsc);
		c.setMaxAge(999999);
		c.setPath("/");
		
		response.addCookie(c);
		
		out.println("<form action='index' ><input type='submit' value='Volver'/></form>");
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

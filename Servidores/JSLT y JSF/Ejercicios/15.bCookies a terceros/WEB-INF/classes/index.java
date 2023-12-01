
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;



public class index extends HttpServlet{
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
			ServletContext contexto = getServletContext();
		
			String nombre = (String)contexto.getAttribute("nomUsu");
			
			if(nombre==null){
				nombre="";
			}
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='saludo' ");
			out.println("<label for='nomUsu'>Usuario");
			out.println("<input type='text' name='nomUsu' id='nomUsu'/ value='"+nombre+"'>");
			out.println("<label for='pass'>Password");
			out.println("<input type='password' name='pass' id='pass'/>");
			out.println("<input type='submit' value='Iniciar Sesion'/></form>");
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

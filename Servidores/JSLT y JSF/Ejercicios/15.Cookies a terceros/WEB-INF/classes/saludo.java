
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class saludo extends HttpServlet{
	
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
			
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		String nomUsu = request.getParameter("nomUsu");
		String pass = request.getParameter("pass");
		
		ServletContext contexto = getServletContext();
		
		contexto.setAttribute("nomUsu",nomUsu);
		
		Cookie [] cookies=request.getCookies();
		
		out.println("<h3>Bienvenido "+nomUsu+"</h3>");
		
		out.println("<p>Elige tu escuderia favorita</p>");
		out.println("<form action='creaCookies'>");
		out.println("<input type='hidden' name='nomUsu' value='"+nomUsu+"'>");
		String escuderias= contexto.getInitParameter("escuderias");
		String split[]= escuderias.split(";");
		for(int i=0;i<split.length;i++){
			out.println("<input type='checkbox' name='escuderia' value='"+split[i]+"' />"+split[i]+"</label>");
		}
		out.println("<br><input type='submit'/>Enviar</label>");
		
		out.println("</form>");
		
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

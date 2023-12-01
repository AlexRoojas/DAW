
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class salir extends HttpServlet{
	
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();
		ArrayList<String>listArtSel =(ArrayList<String>)sesion.getAttribute("artSel");
		
		Date inicio = (Date)sesion.getAttribute("hora");
		long msIni = inicio.getTime();
		
		Date fin = new Date();
		long msFin = fin.getTime();
		
		long tiempo = msFin-msIni;
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Hasta luego siempre nos veremos, has tardado "+tiempo/1000+" </h3>");
		
		out.println("<form action='index.html' ><input type='submit' value='Salir'/></form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		sesion.invalidate();
		
		
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


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
		ServletContext contexto = getServletContext();
			
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		
		String nomUsu = request.getParameter("nomUsu");
		nomUsu+="_art";
		String pass = request.getParameter("pass");
		
		Cookie [] vectorCookies=request.getCookies();
		
		contexto.setAttribute("nomUsu",nomUsu);
		
		
		out.println("<h3>Bienvenido "+nomUsu+"</h3>");
		
		String fotos="";
		
		for(int i=0;i<vectorCookies.length;i++){
			if(vectorCookies[i].getName().equals(nomUsu)){
				fotos = vectorCookies[i].getValue();
			}
		}
		
		String arrFot[] = fotos.split("_");
		
		for(int i=0; i<arrFot.length;i++){
			out.println("<img style='width:200px' src='images/"+arrFot[i]+".png'>");
		}
		
		
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


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class verCesta extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext contexto = getServletContext();
		
		String comida[] =request.getParameterValues("comida");
		HttpSession sesion = request.getSession();
		
		
		ArrayList<String>listArtSel =(ArrayList<String>)sesion.getAttribute("artSel");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Has seleccionado los siguientes articulos:</h3>");
		
		
		out.println("<h4>Articulos</h4>");
		out.println("<ul>");
		
		for(int i=0;i<comida.length;i++){
			listArtSel.add(comida[i]);
		}
		sesion.setAttribute("listArtSel",listArtSel);
		
		for(String com: listArtSel){
			out.println("<li>"+com+"</li>");
			sesion.setAttribute(""+com+"",com);
			
		}
		out.println("</ul>");
		
		sesion.setAttribute("listArtSel",listArtSel);
		
		out.println("<form action='listArt' ><input type='submit' value='Volver'/></form>");
		out.println("<form action='salir' ><input type='submit' value='Salir'/></form>");
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

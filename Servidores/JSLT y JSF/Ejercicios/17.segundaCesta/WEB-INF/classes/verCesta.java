
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;

import pojos.*;
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
		HttpSession sesion = request.getSession();
		
		String nombreUsu = (String)sesion.getAttribute("usu");
		
		ArrayList<Articulo>carrito =(ArrayList<Articulo>)sesion.getAttribute("carrito");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div>");
		out.println("<h3>"+nombreUsu+" has seleccionado los siguientes articulos:</h3>");
		out.println("<h4>Articulos</h4>");
		out.println("<ul>");
		
		for(int i=0;i<carrito.size();i++){
			out.println("<li><img src='"+carrito.get(i).getImagen()+"'>");
			out.println("<p>"+carrito.get(i).getNombre()+"</p></li>");
		}
		
		out.println("</ul>");
		
		out.println("<form action='listArt' ><input type='submit' value='Volver a comprar'></form>");
		
		out.println("</div>");
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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;


public class cerrarSesion extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	

			HttpSession miSesion = request.getSession();
			ServletContext contexto = getServletContext();

			HashMap<Integer,Integer> miCesta = (HashMap<Integer,Integer>)miSesion.getAttribute("miCesta"); // obtengo el ArrayList de la sesion
			HashMap<Integer,Articulo> mapaArticulos = (HashMap<Integer,Articulo>)contexto.getAttribute("mapaArticulos");			
	
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			
			long milisegundosIni = miSesion.getCreationTime();
			
			Date fechaFin = new Date();
			long milisegundosFin = fechaFin.getTime();
			
			long tiempoDuracion = milisegundosFin - milisegundosIni;
			
			out.println("<h2>Hasta la proxima. Has estado conectado " + tiempoDuracion/1000 + " segundos</h2>");
			
			for (int codArticulo : miCesta.keySet()) {
				mapaArticulos.get(codArticulo).incrementarNUnidades(miCesta.get(codArticulo));
			}
			
			miSesion.invalidate();
			
			out.println("<form action='index.html'>");
			out.println("<input type='submit' value='Salir'>");
			out.println("</form>");
			
			out.println("</body>");
			out.println("</html>");


	}
		
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		processRequest(request, response);
	}
}
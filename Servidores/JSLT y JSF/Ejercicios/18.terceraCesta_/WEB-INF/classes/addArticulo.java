import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;

public class addArticulo extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			PrintWriter out = response.getWriter();
			
			ServletContext contexto = getServletContext();
			HttpSession miSesion = request.getSession();
			
			HashMap<Integer,Articulo> mapaArticulos = (HashMap<Integer,Articulo>)contexto.getAttribute("mapaArticulos");
			HashMap<Integer,Integer> miCesta = (HashMap<Integer,Integer>)miSesion.getAttribute("miCesta"); 
	
			int articuloSeleccionado = Integer.parseInt(request.getParameter("articuloSeleccionado"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	
			mapaArticulos.get(articuloSeleccionado).decrementarNUnidades(cantidad);
			
			out.println(articuloSeleccionado);
			out.println(cantidad);
			
			if (miCesta.containsKey(articuloSeleccionado)) { // ya esta el articulo en la cesta
				miCesta.replace(articuloSeleccionado,miCesta.get(articuloSeleccionado)+cantidad);
			} else { // no estaba el articulo en la cesta
				miCesta.put(articuloSeleccionado,cantidad); 
			}
				
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
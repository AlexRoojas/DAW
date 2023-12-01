import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;

public class addArticulo extends HttpServlet{
	
	protected void proceso(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			PrintWriter out = response.getWriter();
			
			ServletContext contexto = getServletContext();
			HttpSession miSesion = request.getSession();
			
			TreeMap<Integer, Articulo> mapaArt = (TreeMap<Integer, Articulo>)contexto.getAttribute("mapaArt");
			HashMap<Integer,Integer> carrito = (HashMap<Integer,Integer>)miSesion.getAttribute("carrito"); 
	
			int articuloSeleccionado = Integer.parseInt(request.getParameter("articuloSeleccionado"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	
			mapaArt.get(articuloSeleccionado).decrementarNUnidades(cantidad);
			
			if (carrito.containsKey(articuloSeleccionado)) { // ya esta el articulo en la cesta
				carrito.replace(articuloSeleccionado,carrito.get(articuloSeleccionado)+cantidad);
			} else { // no estaba el articulo en la cesta
				carrito.put(articuloSeleccionado,cantidad); 
			}
	}
		
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		proceso(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		proceso(request, response);
	}
}
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import pojos.*;

public class verCesta extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			HttpSession miSesion = request.getSession();
			ServletContext contexto = getServletContext();
			
			String nombreCliente = (String)miSesion.getAttribute("nombreCliente"); // obtengo el nombre de la sesion
			HashMap<Integer,Integer> miCesta = (HashMap<Integer,Integer>)miSesion.getAttribute("miCesta"); // obtengo el ArrayList de la sesion
			HashMap<Integer,Articulo> mapaArticulos = (HashMap<Integer,Articulo>)contexto.getAttribute("mapaArticulos");
			String mensaje = (String)miSesion.getAttribute("mensaje");
			//int articuloDeseleccionado;
			
	
			if (request.getParameter("articuloDeseleccionado") != null) {
				
				int articuloDeseleccionado = Integer.parseInt(request.getParameter("articuloDeseleccionado"));
				mapaArticulos.get(articuloDeseleccionado).incrementarUnidad();
				miCesta.replace(articuloDeseleccionado,miCesta.get(articuloDeseleccionado)-1);
				
				if (miCesta.get(articuloDeseleccionado) == 0) {
					miCesta.remove(articuloDeseleccionado);
				}
				
			}
	
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("table, th, td {border: 1px solid black; border-collapse: collapse;}");
			out.println("</style>");
			out.println("</head>");
			
			out.println("<body>");
			
			out.println("<h2>Carrito de "+nombreCliente+"</h2>");
			
			out.println("<table>");
			
			for (int codArticulo : miCesta.keySet()) {
				out.println("<form action='verCesta'>");
				out.println("<tr>");
				out.println("<td>");
				out.println(mapaArticulos.get(codArticulo).getNombreArticulo());
				out.println("</td>");
				out.println("<td>");
				out.println("<img src='"+mapaArticulos.get(codArticulo).getImagenArticulo()+"'>");
				out.println("</td>");
				out.println("<td>");
				out.println(miCesta.get(codArticulo));
				out.println("</td>");
				out.println("<td>");
				out.println("<input type='submit' value='Quitar de la cesta'>");
				out.println("</td>");
				out.println("<input type='hidden' name='articuloDeseleccionado' value='"+codArticulo+"'>");
				
				out.println("</tr>");
				out.println("</form>");
			}
			
			out.println("</table>");
			
			out.println("<form action='listaArticulos'>");
			out.println("<input type='submit' value='Seguir Comprando'>");
			out.println("</form>");
			
			out.println("<form action='confirmarPedido'>");
			out.println("<input type='submit' value='Confirmar Pedido'>");
			out.println("</form>");
			
			out.println("<form action='cerrarSesion'>");
			out.println("<input type='submit' value='Cerrar Sesion'>");
			out.println("</form>");
						
			out.println("</body>");
			out.println("</html>");
			
			mensaje = "";
			
			miSesion.setAttribute("mensaje",mensaje);
			
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
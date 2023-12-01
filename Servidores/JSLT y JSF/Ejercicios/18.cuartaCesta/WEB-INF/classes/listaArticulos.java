import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;

public class listaArticulos extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext contexto = getServletContext();
		
		String stringTodosArticulos = getInitParameter("articulos"); // pokeball:20;pocion:15
		String stringArticulosIndependientes[] = stringTodosArticulos.split(";"); // {pokeball:20},{pocion:15}
		HashMap<Integer,Articulo> mapaArticulos = new HashMap<Integer,Articulo>();
		
		for (int i = 0; i < stringArticulosIndependientes.length; i++) {
			String articuloIndependiente[] = stringArticulosIndependientes[i].split(":"); // {pokeball}{20}
			Articulo nuevoArticulo = new Articulo(i,articuloIndependiente[0],Integer.parseInt(articuloIndependiente[1]),Double.parseDouble(articuloIndependiente[2]));
			mapaArticulos.put(i,nuevoArticulo);
		}
		
		contexto.setAttribute("mapaArticulos", mapaArticulos);
	}
	
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			ServletContext contexto = getServletContext();

			boolean seAgrega = false;
			
			HttpSession miSesion = request.getSession();
			Date fechaInicioSesion = new Date(miSesion.getCreationTime());
			HashMap<Integer,Articulo> mapaArticulos = (HashMap<Integer,Articulo>)contexto.getAttribute("mapaArticulos");
			String nombreCliente = (String)miSesion.getAttribute("nombreCliente"); // resto de veces obtengo el nombre de la sesion
			String mensaje;
			
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("body {background: url('imagenes/fondo.jpg') no-repeat;}");
			out.println("body {background-size: cover;}");
			out.println("div {margin: 0 auto; padding: 20px; border: 1px solid black; width: 50%; background-color: white;}");
			out.println("h1, h2, h3 {text-align: center;}");
			out.println("</style>");
			out.println("</head>");
			
			out.println("<body>");
			
			// ---------- Compruebo si es la primera vez que se entra ----------
			
			if (miSesion.isNew()) {
				out.println("Es nuevo");
				
				HashMap<Integer,Integer> miCesta = new HashMap<Integer,Integer>(); // <codigoArticulo,cantidad>
				miSesion.setAttribute("miCesta",miCesta); // subo el ArrayList cesta a la sesion
				
				nombreCliente = request.getParameter("nombreCliente");
				miSesion.setAttribute("nombreCliente",nombreCliente); // primera vez subo el nombre a la sesion
				
				mensaje = "";
				miSesion.setAttribute("mensaje",mensaje);
			} else {
				out.println("No es nuevo");
				mensaje = (String)miSesion.getAttribute("mensaje");
				
				if (request.getParameter("cantidad") != null) {
					int cantidad = Integer.parseInt(request.getParameter("cantidad"));
					int articuloSeleccionado = Integer.parseInt(request.getParameter("articuloSeleccionado"));
					
					if (cantidad <= mapaArticulos.get(articuloSeleccionado).getUnidadesArticulo()) {
						
						if (cantidad == 0) {
							mensaje = "No has seleccionado ninguna unidad de este articulo";
						} else {
							RequestDispatcher rd = null;
							rd = contexto.getRequestDispatcher("/addArticulo");
							rd.include(request, response);
							
							mensaje = "Se ha aniadido el articulo correctamente";
						}
						
					} else {
						mensaje = "No hay suficientes existencias";
					}
				}
		
			}
			
			// -----------------------------------------------------------------
			
			// ---------- Muestro los articulos con su stock diponible ----------
			
			out.println("<h2>Hola "+nombreCliente+". Bienvenid@ a nuestra tienda</h2><br>" + 
						"<h3> Te has conectado a las " + fechaInicioSesion + "</h2>");
			
			out.println("<div>");
			out.println("<h4>Sesion de "+nombreCliente+"</h4>");
			
			out.println("<table>");
			for (int i = 0; i < mapaArticulos.size(); i++) {
				out.println("<form action='listaArticulos'>");
				out.println("<tr>"); // fila
				out.println("<td>"); // casilla 1
				out.println(mapaArticulos.get(i).getNombreArticulo());
				out.println("</td>");
				out.println("<td>"); // casilla 2
				out.println("<img src='"+mapaArticulos.get(i).getImagenArticulo()+"'>");
				out.println("</td>");
				out.println("<td>"); // casilla 3
				out.println("<input type='number' name='cantidad' value='0'>");
				out.println("</td>");
				out.println("<td>"); // casilla 3
				out.println(mapaArticulos.get(i).getPrecioArticulo());
				out.println("</td>");
				if (mapaArticulos.get(i).getUnidadesArticulo() > 0) { // hay stock
					out.println("<td>"); // casilla 3
					out.println("Unidades en stock: " + mapaArticulos.get(i).getUnidadesArticulo());
					out.println("</td>");
					out.println("<td>"); // casilla 5
					out.println("<input type='submit' value='Agregar'>");
					out.println("</td>");
				} else { // no hay stock
					out.println("<td>"); // casilla 3
					out.println("No hay stock");
					out.println("</td>");	
					out.println("<td>"); // casilla 5
					out.println("<input type='submit' value='Agregar' disabled>");
					out.println("</td>");
				}
				out.println("<td>"); // casilla 6
				out.println("<input type='hidden' name='articuloSeleccionado' value='"+i+"'>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</form>");
				
			}
			out.println("</table>");
			
			
			out.println("<p>"+mensaje+"</p>");
			
			
			out.println("<form action='verCesta'>");
			out.println("<input type='submit' value='Ver Cesta'>");
			out.println("</form>");
			
			out.println("<form action='cerrarSesion'>");
			out.println("<input type='submit' value='Cerrar Sesion'>");
			out.println("</form>");
			
			out.println("</div>");
			
			out.println("</body>");
			out.println("</html>");
			
			// ------------------------------------------------------------------
			
			
			
			


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
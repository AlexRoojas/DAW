
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

import pojos.*;

public class listArt extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext contexto = getServletContext();
		contexto.setAttribute("horaArranque", new GregorianCalendar());
		
		String articulo= contexto.getInitParameter("articulos");
		String splitArt[]= articulo.split(";");
		
		TreeMap<Integer,Articulo> mapaArt = new TreeMap<Integer,Articulo>();
		
		for(int i=0;i<splitArt.length;i++){
			String splitEntero[]=splitArt[i].split(":");
			
			Articulo art=new Articulo(i,splitEntero[0],Integer.parseInt(splitEntero[1]),Double.parseDouble(splitEntero[2]));
			mapaArt.put(i,art);
		}
		contexto.setAttribute("mapaArt",mapaArt);
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext contexto = getServletContext();
		HttpSession sesion = request.getSession();
		//-----------------------------------------------
		
		
		TreeMap<Integer, Articulo> mapaArt = (TreeMap<Integer, Articulo>)contexto.getAttribute("mapaArt");
		String mensaje;
		
		
		//----------------------------------------------------
		if(sesion.isNew()){
			Date hora = new Date(sesion.getCreationTime());
			sesion.setAttribute("hora",hora);
		
			HashMap<Integer,Integer> carrito = new HashMap<Integer,Integer>();
			sesion.setAttribute("carrito",carrito);
			
			String usu=request.getParameter("nombre");
			sesion.setAttribute("usu",usu);
			
			mensaje = "";
			sesion.setAttribute("mensaje",mensaje);
		}else{
			
			mensaje = (String)sesion.getAttribute("mensaje");
			
			if(request.getParameter("cantidad")!=null){
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));
				int articuloSeleccionado = Integer.parseInt(request.getParameter("articuloSeleccionado"));
					
				if (cantidad <= mapaArt.get(articuloSeleccionado).getUnidades()) {
						
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
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<h3>Bienvenido "+sesion.getAttribute("usu")+" son las "+sesion.getAttribute("hora")+" </h3>");
		
		
		
		out.println("<table>");
		for(int i=0;i<mapaArt.size();i++){
			out.println("<form action='listArt'>");
			out.println("<tr>"); // fila
			out.println("<td>"); // casilla 1
			out.println(mapaArt.get(i).getNombre());
			out.println("</td>");
			out.println("<td>"); // casilla 2
			out.println("<img src='"+mapaArt.get(i).getImagen()+"'>");
			out.println("</td>");
			out.println("<td>"); // casilla 3
			out.println("<input type='number' name='cantidad' value='0'>");
			out.println("</td>");
			out.println("<td>"); // casilla 4
			out.println(mapaArt.get(i).getPrecio());
			out.println("</td>");
			if(mapaArt.get(i).getUnidades()>0){
					out.println("<td>"); // casilla 3
					out.println("Unidades en stock: " + mapaArt.get(i).getUnidades());
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
		
		out.println("<form action='salir'>");
		out.println("<input type='submit' value='Cerrar Sesion'>");
		out.println("</form>");
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

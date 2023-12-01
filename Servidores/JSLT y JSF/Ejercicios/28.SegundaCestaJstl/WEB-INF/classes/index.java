import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;

public class index extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ServletContext contexto = getServletContext();
		contexto.setAttribute("horaArranque", new GregorianCalendar());
		
		String stringTodosArticulos = getInitParameter("articulos");
		String stringArticulosIndependientes[] = stringTodosArticulos.split(";"); 
		HashMap<Integer,Articulo> mapaArticulos = new HashMap<Integer,Articulo>();
		
		for (int i = 0; i < stringArticulosIndependientes.length; i++) {
			String articuloIndependiente[] = stringArticulosIndependientes[i].split(":"); 
			Articulo nuevoArticulo = new Articulo(i,articuloIndependiente[0],Integer.parseInt(articuloIndependiente[1]));
			mapaArticulos.put(i,nuevoArticulo);
		}
	//	contexto.setAttribute("mapaArticulos", mapaArticulos);
		Tienda miTienda=new Tienda();
		miTienda.setNombreTienda("Gucci");
		miTienda.setListaArticulos(mapaArticulos);
		contexto.setAttribute("miTienda", miTienda);
	}
	
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			
			out.println("<body>");
			
			
			out.println("<h1>Inicio de sesión</h1>");
			
			out.println("<form action='Tienda.jsp'>");
			
			out.println("<label>Nombre: </label>");
			out.println("<input type='text' name='nombreUsuario'><br><br>");
			
			out.println("<label>Contraseña: </label>");
			out.println("<input type='password' name='contraseniaUsuario'><br><br>");
			
			out.println("<input type='submit' value='Enviar'>");
			
			out.println("</form>");
			
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
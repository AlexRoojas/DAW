import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;


public class confirmarPedido extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	

			HttpSession sesion = request.getSession();
			ServletContext contexto = getServletContext();

			TreeMap<Integer, Articulo> mapaArt = (TreeMap<Integer, Articulo>)contexto.getAttribute("mapaArt");
			HashMap<Integer,Integer> carrito = (HashMap<Integer,Integer>)sesion.getAttribute("carrito"); 
		
			double totalTicket = 0, totalTicketConIVA = 0, totalArticulo = 0;
	
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h2>Ticket de compra</h2>");
			out.println("<div>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>Articulo</td><td>Cantidad</td><td>Precio</td><td>Total Articulo</td>");
			out.println("</tr>");
			
			for (int codArticulo : carrito.keySet()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(mapaArt.get(codArticulo).getNombre());
				out.println("</td>");
				out.println("<td>");
				out.println(carrito.get(codArticulo));
				out.println("</td>");
				out.println("<td>");
				out.println(mapaArt.get(codArticulo).getPrecio());
				out.println("</td>");
				out.println("<td>");
				totalArticulo = mapaArt.get(codArticulo).getPrecio() * carrito.get(codArticulo);
				totalTicket += totalArticulo;
				out.println(totalArticulo);
				out.println("</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("</div>");
			out.println("<p>Total ticket: "+ totalTicket + "</p>");
			out.println("<p>IVA: " + totalTicket*0.21 + "</p>");
			out.println("<p>Total (IVA incluido): " + totalTicket*1.21 + "</p>");
			
			sesion.invalidate();
			
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
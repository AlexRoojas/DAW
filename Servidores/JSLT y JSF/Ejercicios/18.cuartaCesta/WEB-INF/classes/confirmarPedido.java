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

			HttpSession miSesion = request.getSession();
			ServletContext contexto = getServletContext();

			HashMap<Integer,Integer> miCesta = (HashMap<Integer,Integer>)miSesion.getAttribute("miCesta"); // obtengo el ArrayList de la sesion
			HashMap<Integer,Articulo> mapaArticulos = (HashMap<Integer,Articulo>)contexto.getAttribute("mapaArticulos");	

			double totalTicket = 0, totalTicketConIVA = 0, totalArticulo = 0;
	
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h2>Ticket nº: 2321</h2>");
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>Articulo</td><td>Cantidad</td><td>Precio</td><td>Total Articulo</td>");
			out.println("</tr>");
			
			for (int codArticulo : miCesta.keySet()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(mapaArticulos.get(codArticulo).getNombreArticulo());
				out.println("</td>");
				out.println("<td>");
				out.println(miCesta.get(codArticulo));
				out.println("</td>");
				out.println("<td>");
				out.println(mapaArticulos.get(codArticulo).getPrecioArticulo());
				out.println("</td>");
				out.println("<td>");
				totalArticulo = mapaArticulos.get(codArticulo).getPrecioArticulo() * miCesta.get(codArticulo);
				totalTicket += totalArticulo;
				out.println(totalArticulo);
				out.println("</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			out.println("<p>Total ticket: "+ totalTicket + "</p>");
			out.println("<p>IVA: " + totalTicket*0.21 + "</p>");
			out.println("<p>Total (IVA incluido): " + totalTicket*1.21 + "</p>");
			
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
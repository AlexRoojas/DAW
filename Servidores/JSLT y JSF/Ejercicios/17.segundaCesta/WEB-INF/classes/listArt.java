
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
			
			Articulo art=new Articulo(i,splitEntero[0],Integer.parseInt(splitEntero[1]));
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
		
		
		
		//----------------------------------------------------
		if(sesion.isNew()){
			Date hora = new Date(sesion.getCreationTime());
			sesion.setAttribute("hora",hora);
		
			ArrayList<Articulo> carrito = new ArrayList<>();
			sesion.setAttribute("carrito",carrito);
			
			String usu=request.getParameter("nombre");
			sesion.setAttribute("usu",usu);
		}
		
		String seleccion[]= request.getParameterValues("artSelect");
		ArrayList<Articulo> carrito = (ArrayList<Articulo>)sesion.getAttribute("carrito");
		
		//al añadir a la cesta restamos el stock
		if(seleccion!=null){
			for(Articulo articuloMap:mapaArt.values()){
				for(String codigo: seleccion){
					
					if(articuloMap.getNombre().equals(codigo)){
						int resto =articuloMap.getUnidades();
						if(resto>0){
							resto--;
							articuloMap.setUnidades(resto);
							carrito.add(articuloMap);
						}
						
						
					}
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
		
		
		out.println("<form action='listArt'>");
		out.println("<table>");
		for(int i=0;i<mapaArt.size();i++){
			if(mapaArt.get(i).getUnidades()>0){
				out.println("<tr><td><input type='checkbox' name='artSelect' value='"+mapaArt.get(i).getNombre()+"'> </td>");
			} else{
				out.println("<tr><td><input type='checkbox' name='artSelect' value='"+mapaArt.get(i).getNombre()+"' disabled> </td>");
			}
			out.println("<td><img src='"+mapaArt.get(i).getImagen()+"'></td>");
			out.println("<td>"+mapaArt.get(i).getNombre()+"</td>");
			out.println("<td>"+mapaArt.get(i).getUnidades()+"</td></tr>");
		}
		
		
		out.println("</table>");
		out.println("<input type='submit' value='Anadir Articulo'>");
		out.println("</form>");
		out.println("<form action='verCesta'>");
		out.println("<input type='submit' value='Ver Cesta'>");
		out.println("</form>");
		out.println("<form action='index.html'>");
		out.println("<input type='submit' value='Ver Cesta'>");
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

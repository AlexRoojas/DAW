import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import pojos.*;

public class gestionaCesta extends HttpServlet{
	
	protected void proceso(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
			PrintWriter out = response.getWriter();
			
			ServletContext contexto = getServletContext();
			HttpSession miSesion = request.getSession();
			
			TreeMap<Integer, Articulo> mapaArt = (TreeMap<Integer, Articulo>)contexto.getAttribute("mapaArt");
			HashMap<Integer,Integer> carrito = (HashMap<Integer,Integer>)miSesion.getAttribute("carrito"); 
	
			String opSel = (String)request.getParameter("opcion");
			int artSel2 = Integer.parseInt(request.getParameter("artSel2"));
			
			switch(opSel){
				case "sumar":
					if(mapaArt.get(artSel2).getUnidades()>0){
						mapaArt.get(artSel2).quitarUnidad();
						carrito.replace(artSel2,carrito.get(artSel2)+1);
					}
				break;
				case "quitar":
					mapaArt.get(artSel2).sumarUnidad();
					carrito.replace(artSel2,carrito.get(artSel2)-1);
					
					if(carrito.get(artSel2) == 0){
						carrito.remove(artSel2);
					}
					
				break;
				case "borrar":
					mapaArt.get(artSel2).setUnidades(carrito.get(artSel2)+mapaArt.get(artSel2).getUnidades());
                    carrito.remove(artSel2);
				break;
				
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
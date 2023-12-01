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
			HttpSession sesion = request.getSession();
			
			Tienda tienda = (Tienda) contexto.getAttribute("tienda");
			Cesta cesta = (Cesta) contexto.getAttribute("cesta");
			
			String artSel[] = request.getParameterValues("artSel");
			
			for(int i=0; i<artSel.length;i++){
				int codigo = Integer.parseInt(artSel[i]);
				
				cesta.setAddArticulo(codigo);
				tienda.getObtenerArticulo(codigo).setRestaUnidades();
				
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
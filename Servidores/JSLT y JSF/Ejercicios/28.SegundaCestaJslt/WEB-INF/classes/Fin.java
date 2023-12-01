import pojos.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class Fin extends HttpServlet{
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);	
	}
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context=getServletContext();	
		HttpSession sesion = request.getSession();

		Cesta cestaTienda = (Cesta)sesion.getAttribute("cestaTienda");
		Tienda infoTienda = (Tienda)context.getAttribute("infoTienda");	
		
		String procedencia = request.getParameter("procedencia");
		
		if(procedencia!=null){
			for(int codigo: cestaTienda.getCestaCompra().keySet()){
				int unidadesAnadir=cestaTienda.getCestaCompra().get(codigo);
				infoTienda.getListaArticulos().get(codigo).anadeExistencias(unidadesAnadir);
			}
		}

		sesion.invalidate();
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
import pojos.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class modificaExistencias extends HttpServlet{
	
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
		
		String codArticuloSelect=request.getParameter("codArticuloSelect");
		String codArticuloElm=request.getParameter("codArticuloElm");
		
		if(codArticuloSelect!=null || codArticuloElm!=null){
			//------------AÑADIR ARTICULO DESDE TIENDA.JSP---------------
			if(codArticuloSelect!=null ){
				int numeroUnidades=Integer.parseInt(request.getParameter("cantidad"));
				int codArtDef=Integer.parseInt(codArticuloSelect);
				int existenciasTienda=infoTienda.getListaArticulos().get(codArtDef).getExistencias();
					if(existenciasTienda>=numeroUnidades){
						cestaTienda.anadirArticulo(codArtDef,numeroUnidades);
						infoTienda.getListaArticulos().get(codArtDef).decrementaExistencias(numeroUnidades);
					}
			}else{
			//------------AÑADIR/QUITAR ARTICULO DESDE CESTA.JSP---------------	
				int codArtDef=Integer.parseInt(codArticuloElm);
				String opcionSubmit=request.getParameter("opcionArticulo");
				switch(opcionSubmit){
					case "Anadir":
						int existenciasTienda=infoTienda.getListaArticulos().get(codArtDef).getExistencias();
						if(existenciasTienda>0){
							cestaTienda.anadirArticulo(codArtDef,1);
							infoTienda.getListaArticulos().get(codArtDef).decrementaExistencias(1);
						}
					break;	
					case "Quitar":
						if(cestaTienda.getCestaCompra().get(codArtDef)>0){
							infoTienda.getListaArticulos().get(codArtDef).anadeExistencias(1);
							cestaTienda.getCestaCompra().replace(codArtDef,cestaTienda.getCestaCompra().get(codArtDef)-1);
						}
						if(cestaTienda.getCestaCompra().get(codArtDef)==0){
							cestaTienda.getCestaCompra().remove(codArtDef);
						}

					break;
					case "Eliminar":
						infoTienda.getListaArticulos().get(codArtDef).anadeExistencias(cestaTienda.getCestaCompra().get(codArtDef));
						cestaTienda.getCestaCompra().remove(codArtDef);
					break;
				}
				
			}	
		}
	
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
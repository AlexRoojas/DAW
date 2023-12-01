import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import pojos.*;

public class conexion extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int puestoConexion=0; //Objeto
		
		HashMap<String,Usuario> listaUsus = new HashMap<>();
		
		getServletContext().setAttribute("listaUsus", listaUsus);
		getServletContext().setAttribute("puestoConexion", puestoConexion);
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		ServletContext contexto = getServletContext();
		RequestDispatcher rd=null;
		
		String nombre=request.getParameter("nombre");
		
		
		
		
		contexto.setAttribute("hora", new GregorianCalendar());
		request.setAttribute("nombre", nombre);
		
		Usuario usu = new Usuario(nombre,new GregorianCalendar(),((int)contexto.getAttribute("puestoConexion")));
		HashMap<String,Usuario>mapaUsuarios = (HashMap<String,Usuario>)contexto.getAttribute("listaUsus");
		
		request.setAttribute("procedencia", "entrada");//para pintar
		
		if(mapaUsuarios.get(nombre)!=null){
			String repetido = "Y";
			request.setAttribute("repetido",repetido);
			rd=contexto.getRequestDispatcher("/pinta");
			
			rd.forward(request, response);
		}else{
			String repetido = "N";
			request.setAttribute("repetido",repetido);
			
			mapaUsuarios.put(nombre,usu);
			
			int puestoConexion=(int)contexto.getAttribute("puestoConexion");
			puestoConexion++;
			contexto.setAttribute("puestoConexion",puestoConexion);
			
			
			String todosUsuarios="";
			for(Usuario uwu:mapaUsuarios.values()){
				todosUsuarios+=uwu+"<br>";
			}
			request.setAttribute("todosUsuarios", todosUsuarios);
			rd=contexto.getRequestDispatcher("/pinta");
			rd.forward(request, response);
		}
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

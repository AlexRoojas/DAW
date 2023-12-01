
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import pojos.*;

public class salida extends HttpServlet{
	
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		
		ServletContext contexto = getServletContext();
		
		HashMap<String,Usuario>mapaUsuarios = (HashMap<String,Usuario>)contexto.getAttribute("listaUsus");
		String nombreDesc=request.getParameter("usuarioDesconectado");
		
		mapaUsuarios.remove(nombreDesc);
		
		String todosUsuarios="";
		for(Usuario uwu:mapaUsuarios.values()){
			todosUsuarios+=uwu+"<br>";
		}
		request.setAttribute("todosUsuarios", todosUsuarios);
		request.setAttribute("procedencia", "salida");
		request.setAttribute("nombre", nombreDesc);
		
		RequestDispatcher rd=null;
		rd=contexto.getRequestDispatcher("/pinta");
		rd.forward(request, response);
		
		
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

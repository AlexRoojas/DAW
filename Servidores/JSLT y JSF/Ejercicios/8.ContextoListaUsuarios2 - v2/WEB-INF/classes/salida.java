
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
		String txt="";
		for(Usuario uwu:mapaUsuarios.values()){
			txt+=uwu+"<br>";
		}
		
		
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Formulario</title>");
		out.println("<link rel='stylesheet' type='text/css' href='estilo.css'/>");
		out.println("<style>");
		out.println("body{text-align:center; background: url("+contexto.getInitParameter("fondo")+") no-repeat; background-size:cover; background-color:white; width: 40%;margin: 10% auto; }"); 
		out.println("p {color:"+getInitParameter("cambiaColor")+" }");
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body>");	
		out.println("<div>");
		out.println("<h3>Se ha desconectado el usuario "+nombreDesc+"</h3>");
		out.println("<p>Usuarios Restantes</p>");
		out.println("<p>"+txt+"</p>");
		out.println("<form action='index.html'>");
		out.println("<input type=submit value='Volver'>");
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

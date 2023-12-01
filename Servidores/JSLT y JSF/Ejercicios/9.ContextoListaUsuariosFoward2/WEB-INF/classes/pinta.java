import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import pojos.*;

public class pinta extends HttpServlet{
	
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		ServletContext contexto = getServletContext();
		
		String repetido= (String)request.getAttribute("repetido");
		String procedencia =(String)request.getAttribute("procedencia");
		String todosUsuarios= (String)request.getAttribute("todosUsuarios");
		
		
		String nombre =(String)request.getAttribute("nombre");
		GregorianCalendar hora = new GregorianCalendar();
		int puestoConexion=(int)contexto.getAttribute("puestoConexion");
		
		
		Usuario usu = new Usuario(nombre, hora,puestoConexion);
		
		HashMap<String,Usuario>mapaUsuarios = (HashMap<String,Usuario>)contexto.getAttribute("mapaUsuarios");
		
		

		
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
		if(procedencia.equals("entrada")){
			
			if(repetido.equals("Y")){
				out.println("<h3>Ya existe "+nombre+" , intentalo con otro nombre</h3>");
				
			}else{
				out.println("<h3>"+usu.toStringLargo()+"</h3>");
				out.println(listarUsuarios(mapaUsuarios));
				out.println("<form action='salida'>");
				out.println("<input type='hidden' value='"+nombre+"' name='usuarioDesconectado'>");
				out.println("<input type='submit' value='Desconectar'>");
				out.println("</form>");	
				
			}
		}else if(procedencia.equals("salida")){
			out.println("<h3>Usuario: "+nombre+" desconectado</h3>");
			out.println("<p>Ultimos usuarios conectados:</p>");
			out.println(listarUsuarios(mapaUsuarios));
		}
		out.println("<form action='index.html'>");
		out.println("<input type=submit value='Volver'>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	public String listarUsuarios(HashMap <String,Usuario> mapaUsuarios){
		String txt="";
		for(Usuario uwu:mapaUsuarios.values()){
							txt+="<p>"+uwu+"</p>";
						}
		return txt;
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

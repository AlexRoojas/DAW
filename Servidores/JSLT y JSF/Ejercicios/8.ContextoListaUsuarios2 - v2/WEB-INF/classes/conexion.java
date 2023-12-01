
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
		
		HashMap<String,Usuario> listaUsuarios = new HashMap<>();
		
		getServletContext().setAttribute("listaUsus", listaUsuarios);
		getServletContext().setAttribute("puestoConexion", puestoConexion);
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		
		ServletContext contexto = getServletContext();
		
		/*getServletContext().setAttribute("horaInicio", new GregorianCalendar());
		GregorianCalendar calendarioAplicacion=(GregorianCalendar)contexto.getAttribute("horaInicio");*/
		
		
		String nombre = request.getParameter("nombre");
		GregorianCalendar hora = new GregorianCalendar();
		int puestoConexion=(int)contexto.getAttribute("puestoConexion");
		contexto.setAttribute("puestoConexion",puestoConexion);
		puestoConexion++;
		
		HashMap<String,Usuario>mapaUsuarios = (HashMap<String,Usuario>)contexto.getAttribute("listaUsus");
		
		//SimpleDateFormat
		
		Usuario usu = new Usuario(nombre, hora,puestoConexion);
		
		//----------------------------------------------------------------------------------------
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
		
		out.println("h3 {color:"+getInitParameter("cambiaColor")+" }");
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body>");
		if(mapaUsuarios.get(nombre)!=null){
			out.println("<h3>Ya existe este usuario, intentalo con otro nombre</h3>");
			out.println("<a href='index.html'>Volver</a>");
		}else{
			out.println("<div>");
		out.println("<h3>"+usu.toStringLargo()+"</h3>");
		out.println("<p>Ultimos usuarios conectados:</p>");
				HashMap<String,Usuario> listaUsuarios = (HashMap<String,Usuario>)contexto.getAttribute("listaUsus");
				listaUsuarios.put(usu.getNombre(),usu);
				
				for(Usuario nUsu : listaUsuarios.values()){
					out.println("<p>"+nUsu+"</p>");
				}
				contexto.setAttribute("listaUsus",listaUsuarios);
				getServletContext().setAttribute("puestoConexion", puestoConexion);
				
				
			
		out.println("<form action='index.html'>");
		out.println("<input type=submit value='Volver'>");
		out.println("</form>");
		out.println("<form action='salida'>");
		out.println("<input type=submit value='Desconectar'>");
		out.println("<input type=hidden value='"+usu.getNombre()+"' name='usuarioDesconectado'>");
		out.println("</form>");
		out.println("</div>");
		}
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

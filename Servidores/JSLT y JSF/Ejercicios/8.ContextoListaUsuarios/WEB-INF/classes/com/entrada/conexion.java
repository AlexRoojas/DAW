package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class conexion extends HttpServlet{
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int puestoConexion=0; //Objeto
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		
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
		out.println("<style>");
		//out.println("body{text-align:center;}");
		out.println("body{text-align:center; background: url("+contexto.getInitParameter("imgPrim")+") no-repeat; background-size:cover; background-color:white; width: 40%;margin: 10% auto; }"); 
		
		
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body bgcolor='#79C7B2'>");
		out.println("<h3>"+usu.toStringLargo()+"</h3>");
		out.println("<p>Ultimos usuarios conectados:</p>");
				ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>)contexto.getAttribute("listaUsus");
				listaUsuarios.add(usu);
				
				for(Usuario nUsu : listaUsuarios){
					out.println("<p>"+nUsu+"</p>");
				}
				contexto.setAttribute("listaUsus",listaUsuarios);
				getServletContext().setAttribute("puestoConexion", puestoConexion);
				
				
		out.println("<form action='salida'>");
		out.println("<input type=button value='Desconectar'>");
		out.println("<input type=hidden value="+nombre+" name=usuarioConectado>");
		out.println("</form>");		
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

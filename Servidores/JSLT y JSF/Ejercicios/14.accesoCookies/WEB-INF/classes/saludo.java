
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class saludo extends HttpServlet{
	
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		GregorianCalendar horaConexion= new GregorianCalendar();
            Date horaConexionD=horaConexion.getTime();
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatoDeHora = new SimpleDateFormat("HH:mm:ss");
            String d=formatoDeFecha.format(horaConexionD);
            String h=formatoDeHora.format(horaConexionD);
			
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		String nomUsu = request.getParameter("nomUsu");
		String pass = request.getParameter("pass");
		
		ServletContext contexto = getServletContext();
		
		contexto.setAttribute("nomUsu",nomUsu);
		
		Cookie [] cookies=request.getCookies();
		
		out.println("<h3>Bienvenido "+nomUsu+"</h3>");
		if(cookies!=null){
			
			out.println("<h3>El ultimo usuario conectado fue "+cookies[cookies.length-1].getName()+" a las "+h+" del "+d+"</h3>");
		}else{
			
			out.println("<h3>El ultimo usuario conectado fue "+nomUsu+" a las "+h+" del "+d+"</h3>");
		}
		out.println("<form action='index' ><input type='submit' value='Volver'/></form>");
		out.println("</body>");
		out.println("</html>");
		
		
		Cookie c=new Cookie (nomUsu,pass);
		response.addCookie(c);
		
		
		
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

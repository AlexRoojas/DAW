
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;



public class creaCookie extends HttpServlet{
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	
	
			out.println("<html>");
			out.println("<head>");
			String nombre=request.getParameter("nombre");
			String valor=request.getParameter("valor");
			
			valor=URLEncoder.encode(valor,"UTF-8");
			out.println(URLDecoder.decode(valor));
			
			int tiempo=Integer.parseInt(request.getParameter("tiempo"));
			String ruta=request.getParameter("ruta");
			
			
			if(request.getParameter("tiempo") != ""){
			if (nombre!=null && valor!=null && ruta!=null ){
				Cookie c=new Cookie (nombre,valor);
				
				c.setMaxAge(tiempo);
				c.setPath(ruta);
				
				response.addCookie(c);
				
				out.println("La cookie se ha creado correctamente");
			}
			else{
				out.println("No  hemos crado la cookie por falta de datos");
			}
			}
			
			out.println("<form action='verCookies' ><input type='submit' value='ver Cookies'/></form>");
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

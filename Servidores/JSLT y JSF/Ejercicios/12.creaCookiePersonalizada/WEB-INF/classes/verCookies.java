
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

public class verCookies extends HttpServlet{
	
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
			
		Cookie [] vectorCookies=request.getCookies();
		if (vectorCookies!=null){
			out.println("<h3>La cookies creadas hasta el momento son <h3>");
			for (Cookie c:vectorCookies){
				out.println(c.getName()+ "    "+c.getValue()+"</br>");
				
			}
			}else{
				out.println("<h3>lo senitmos pero de momento no  se ha creado cookies<h3>");
				out.println("<form action='index.html' ><input type='submit' value='volver'/></form>");				
				out.println("</body>");
				out.println("</html>");
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

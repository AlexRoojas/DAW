
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
			
		String newNameCookie=request.getParameter("newNameCookie");
		String newValor=request.getParameter("newValor");
			
		out.println("<html>");
		out.println("<head>");
			
		Cookie [] vectorCookies=request.getCookies();
		if (vectorCookies!=null){
			out.println("<h3>La cookies creadas hasta el momento son </h3>");
			out.println("<table><tr><th>Nombre</th><th>Valor</th><th>Tipo Vida</th><th>Ruta</th></tr>");
			for (Cookie c:vectorCookies){
				out.println("<tr><td>"+c.getName()+"</td><td>"+c.getValue()+"</td><td>"+c.getMaxAge()+"</td><td>"+c.getPath()+"</td></tr>");
				//out.println(c.getName()+ "    "+c.getValue()+"</br>");
				
			}
			out.println("Cookie a modificar (nombre) : ");
			out.println("<form action='verCookies'>");
			
			out.println("<select name='newNameCookie'>");
			for (Cookie c:vectorCookies){
				out.println("<option value='"+c.getName()+"'>"+c.getName()+"</option>");
			}
			out.println("</select>");
			
			out.println("Nuevo Valor:");
			out.println("<input type='text' name='newValor' >");
			out.println("<input type='submit' value='Modificar'/>");
			out.println("</form>");
			
			if(newNameCookie!=null && newValor!=null){
				
				for(Cookie c: vectorCookies){
					if(c.getName().equals(newNameCookie)){
						c.setMaxAge(0);
						c.setValue(null);
						response.addCookie(c);
					}
				}
				
				Cookie newCookie = new Cookie(newNameCookie,newValor);
				response.addCookie(newCookie);
				
			}
			
			}else{
				out.println("<h3>lo senitmos pero de momento no  se ha creado cookies</h3>");
				
			}
			
			out.println("<form action='index.html' ><input type='submit' value='Volver'/></form>");				
			out.println("</table>");
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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class context extends HttpServlet{
	
	@Override//modificamos el init
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());// le metemos un atributo horaArranque y le damos el valor del equipo-->GregorianCalendar() 
		
	}
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	
	
			out.println("<html>");
			out.println("<head>");
			
			Cookie [] vectorCookies=request.getCookies();
			for (Cookie c:vectorCookies)
			{
				out.println(c.getValue()+"</br>");
			}
			
			out.println("</body>");
			out.println("</html>");
			

				}
		
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		processRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		processRequest(request, response);
	}
}
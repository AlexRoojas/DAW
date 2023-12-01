import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class crearCookies extends HttpServlet{
	
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
			out.println("algo");
			String nomCook=request.getParameter("nombreCookie");
			String valCook=request.getParameter("valorCookie");
			if (nomCook!=null && valCook!=null)
			{
			Cookie c=new Cookie (nomCook,valCook);
			response.addCookie(c);
			out.println("La cookie se ha creado correctamente");
			}
			else
			{
				out.println("No  hemos crado la cookie por falta de datos");
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
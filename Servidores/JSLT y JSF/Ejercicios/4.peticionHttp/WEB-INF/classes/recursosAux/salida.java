package recursosAux;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class salida extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<link rel='stylesheet' href='estilo.css'/>");
		out.println("<title>Formulario</title>");
		out.println("<style>");
		out.println("body{background-color: #79C7B2;}");
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body>");
		String salida = request.getParameter("procedencia");
		
		out.println("<h1>Usted ha salido de la aplicacion desde "+salida+" .</h1>");
		out.println("<form action='index.html'>");
		out.println("<input type='submit' value='Volver a la aplicacion'/>");
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
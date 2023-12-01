
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class listArt extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().setAttribute("horaArranque", new GregorianCalendar());
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		HttpSession sesion = request.getSession();
		if(sesion.isNew()){
			Date hora = new Date(sesion.getCreationTime());
			sesion.setAttribute("hora",hora);
			
			ArrayList<String> artSel = new ArrayList<>();
			sesion.setAttribute("artSel",artSel);
		}
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3>Buenas tardes que pasa son las "+sesion.getAttribute("hora")+" </h3>");
		
		out.println("<p>Elige tu comida</p>");
		out.println("<form action='verCesta'>");
		
		
		String comida= getInitParameter("comida");
		String split[]= comida.split(";");
		
		
		
		for(int i=0;i<split.length;i++){
			out.println("<input type='checkbox' name='comida' value='"+split[i]+"' />"+split[i]+"</label><br>");
		}
		out.println("<br><input type='submit' value='Enviar'/></label>");
		
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

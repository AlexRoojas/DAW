import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class login extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext contexto = getServletContext();
		contexto.setAttribute("horaArranque", new GregorianCalendar());
		
		String codigos= contexto.getInitParameter("codigos");
		String splitCod[]= codigos.split(";");
		
		HashMap<String,String> mapaLogin = new HashMap<String,String>();
		ArrayList<String> codLibre = new ArrayList<>();
		
		for(int i=0;i<splitCod.length;i++){
			String splitEntero[]=splitCod[i].split(":");
			
			codLibre.add(splitEntero[0]);
			
			
		}
		contexto.setAttribute("codLibre",codLibre);
		contexto.setAttribute("mapaLogin",mapaLogin);
		
		contexto.getInitParameter("combiGana");
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext contexto = getServletContext();
		
		HashMap<String,String> mapaLogin = (HashMap<String,String>)contexto.getAttribute("mapaLogin");
		ArrayList<String> codLibre = (ArrayList<String>)contexto.getAttribute("codLibre");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<form action='comprueba'>");
		
		out.println("<label>Codigo</label>");
		out.println("<input type='text' name='cod'/>");
		
		out.println("<label>Usuario</label>");
		out.println("<input type='text' name='usu'/>");
		
		
		out.println("<br><input type='submit' value='Comprobar'/></label>");
		
		out.println("</form>");
		
		out.println("<form action='obtenerCod'>");
		out.println("Obtener codigo");
		out.println("<label>Usuario</label>");
		out.println("<br><input type='text' name='nomUsu'/>");
		out.println("<br><input type='submit' value='Obtener'/></label>");
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

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class obtenerCod extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext contexto = getServletContext();
		HttpSession sesion = request.getSession();
		
		HashMap<String,String> mapaLogin = (HashMap<String,String>)contexto.getAttribute("mapaLogin");
		ArrayList<String> codLibre = (ArrayList<String>)contexto.getAttribute("codLibre");
		
		String nomUsu = request.getParameter("nomUsu");
		
		String codigoAsignado = codLibre.get(0);
		
		mapaLogin.put(codigoAsignado,nomUsu);
		codLibre.remove(0);
		
		out.println("<form action='login'>");
		out.println("Bienvenido "+nomUsu+" , tu codigo es :"+codigoAsignado);
		out.println("<input type='submit' value='Volver'>");
		out.println("</form>");
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

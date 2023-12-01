import pojos.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class ingresarPalabras extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);	
		
	}
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext contexto=getServletContext();
		HttpSession sesion=request.getSession();
		

		Usuario usuario=(Usuario)sesion.getAttribute("usuario");
		
		String frases=request.getParameter("fraseT");
		String frasesOriginales=request.getParameter("fraseO");
		
		usuario.setAniadirFrasesTraducidas(frases,frasesOriginales);
		usuario.setBonos(usuario.getBonos()-1);
		
		response.sendRedirect("Traductor.jsp");
		
		
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
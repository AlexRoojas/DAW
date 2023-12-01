import pojos.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class crearCookie extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);	
		
	}
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext contexto=getServletContext();
		HttpSession sesion=request.getSession();
		

		String nombre=request.getParameter("usu");
		//-----------------CREACION DE COOKIE----------------------//
		Cookie galletita=new Cookie("ult_Usu",nombre);
		response.addCookie(galletita);
		//---------------------------------------------------------//
		
		sesion.invalidate();
		response.sendRedirect("index.jsp");
		
		
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
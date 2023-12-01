import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class Jugar extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession sesion = request.getSession();
		ServletContext contexto = getServletContext();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		
		
		for(int i=0;i<3;i++){
			out.println("<table>");
			out.println("Apuesta n:"+(i+1));
			out.println("<form action='Jugar'>");
			for(int j=0;j<10;j++){
				
				out.println(j+1);
				out.println("<input type ='checkbox' name='apuesta"+i+"' value='"+j+"'>");
				
			}
			out.println("<input type ='submit' value='Apostar'>");
			out.println("</form>");
			out.println("</table>");
		}
		
		out.println("</div>");
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

package com.entrada;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class holaMundo extends HttpServlet{
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Formulario</title>");
		out.println("<style>");
		out.println("table, tr, td{border: solid black 1px;}");
		out.println("body{background-color: #79C7B2;}");
		out.println("</style>");
		out.println("</head>");
		
		
		
		response.setStatus(301);//mensaje normal
		//response.setStatus(HttpServletResponse.MOVED_PERMANENTLY);//segunda forma
		
		//response.setError();//mensaje personalizado
		
		
		response.sendRedirect("twitter.com");
		
		
		out.println("<body bgcolor='#79C7B2'>");
		out.println("<p>Illo weli</p>");
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

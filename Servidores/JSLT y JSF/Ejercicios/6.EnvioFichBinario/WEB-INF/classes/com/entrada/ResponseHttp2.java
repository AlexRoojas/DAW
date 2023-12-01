package com.entrada;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ResponseHttp2 extends HttpServlet{
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException
		{
		response.sendRedirect("monki.jpg");
		}
		
	@Override
		protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
		{
		processRequest(request, response);
		}
	@Override
		protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
		{
		processRequest(request, response);
		}
	}
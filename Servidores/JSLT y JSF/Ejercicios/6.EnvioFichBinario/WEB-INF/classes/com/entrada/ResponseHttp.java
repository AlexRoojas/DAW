package com.entrada;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseHttp extends HttpServlet{
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		ServletOutputStream out = null;
		
		response.setContentType("image/jpg");
		//línea que se modifica
		response.setBufferSize(2000);
		RandomAccessFile raf = new RandomAccessFile(new
		File(getServletContext().getRealPath("monki.jpg")), "r" );
		response.setContentLength( (int) raf.length() );
		out = response.getOutputStream();
		
		int b;
		while ( (b=raf.read( )) !=-1 ){
			out.write( (byte)b );
		}
		
		// la línea siguiente puede colocarse en
		// el interior del bucle
		
		response.flushBuffer();
		
	}
	@Override
		protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
			processRequest(request, response);
	}
	@Override
		protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
			processRequest(request, response);
		}
}
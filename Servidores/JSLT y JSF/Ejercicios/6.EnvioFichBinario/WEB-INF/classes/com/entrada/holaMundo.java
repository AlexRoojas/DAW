package com.entrada;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class holaMundo extends HttpServlet{
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
	ServletOutputStream out = null;
	try {
		response.setContentType("image/jpg");
		RandomAccessFile raf = new RandomAccessFile(new
		File(getServletContext().getRealPath("monki.jpg")), "r" );
		response.setContentLength( (int) raf.length() );
		out = response.getOutputStream();
		byte [] datas = new byte [ (int) raf.length() ];
	while ( (raf.read( datas )) > 0 ){
		out.write( datas );}
		out.flush();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
	
		processRequest(request,response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		processRequest(request,response);
	}
}

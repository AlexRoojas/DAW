
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import pojos.*;

public class alta extends HttpServlet{
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		ServletContext sc=getServletContext();
		HashMap<Integer,Alumno> mapaAlumnos=(HashMap<Integer,Alumno>)sc.getAttribute("mapa");
		
		int nif=Integer.parseInt(request.getParameter("nif"));
		String nombre=request.getParameter("nombre");
		String ape1=request.getParameter("ape1");
		String ape2=request.getParameter("ape2");
		int edad=Integer.parseInt(request.getParameter("edad"));
		String curso=request.getParameter("curso");
		String poblacion=request.getParameter("poblacion");
		String CP=request.getParameter("CP");
		int numHerm=Integer.parseInt(request.getParameter("numHer"));
		
		Alumno al=new Alumno(nif,nombre,ape1,ape2,edad,numHerm,curso,poblacion,CP);
		
		mapaAlumnos.put(nif,al);
		
		sc.setAttribute("mapa",mapaAlumnos);
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

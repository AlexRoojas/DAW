
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class pintaCalcula extends HttpServlet{
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		
		//----------------------------------------------------------------------------------------
		response.setContentType ("text/html");
		PrintWriter out =response.getWriter();
		
		
		int periocidad = Integer.parseInt(request.getParameter("periocidad"));
		int anios = Integer.parseInt(request.getParameter("anios"));
		
		double tabla[][]=new double[(anios*periocidad)][4];
		tabla=(double[][])request.getAttribute("tabla");
		
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Calculadora</title>");
		out.println("<link rel='stylesheet' type='text/css' href='estiloTabla.css'/>");
		out.println("</head>");	
		
		
		out.println("<body>");
		out.println("<table>");
		out.println("<caption>Resultado del préstamo</caption>");
		int sumaInteres=0;
		int sumaCapital=0;
		int contador=0;
		for(int k=1;k<=anios;k++)
		{
			out.println("<tr>");
			out.println("<th>Recibo</th>");
			out.println("<th>Interes Pagado</th>");
			out.println("<th>Capital Amortizado</th>");
			out.println("<th>Capital pendiente</th>");
			out.println("</tr>");
			for(int l=0;l<periocidad;l++)
			{
				out.println("<tr>");
				out.println("<td>"+df.format(tabla[contador][0])+"</td>");
				out.println("<td>"+df.format(tabla[contador][1])+"</td>");
				out.println("<td>"+df.format(tabla[contador][2])+"</td>");
				out.println("<td>"+df.format(tabla[contador][3])+"</td>");
				out.println("</tr>");
				sumaInteres+=tabla[l*k][1];
				sumaCapital+=tabla[l*k][2];
				contador++;
			}
			out.println("<tr><td colspan='4' class='pie'>Interes pagado total: "+df.format(sumaInteres)+" ________    Capital pagado total: "+df.format(sumaCapital)+"<br/>Anio: "+k+"</td></tr>");
			sumaInteres=0;
			sumaCapital=0;
		}
		out.println("</table>");
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

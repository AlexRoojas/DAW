
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class calcula extends HttpServlet{
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		
		double capital = Integer.parseInt(request.getParameter("capital"));
		double interes = Integer.parseInt(request.getParameter("interes"));
		int anios = Integer.parseInt(request.getParameter("anios"));
		int periocidad=Integer.parseInt(request.getParameter("periocidad"));
		
		double i= interes/100/periocidad;
		int numPlazos=anios*periocidad;
		double capitalPendiente=capital;
		
		double cuota = capital*(i*Math.pow((1+i),numPlazos))/(Math.pow((1+i),numPlazos)-1);
		
		double tabla[][]=new double[numPlazos][4];
		
		
		for(int a=0; a<numPlazos;a++){
			
			double interesCuota=capitalPendiente*i;
			double capitalAmortizado =cuota-interesCuota;
			capitalPendiente-=capitalAmortizado;
			
			tabla[a][0]=a+1;
			tabla[a][1]=interesCuota;
			tabla[a][2]=capitalAmortizado;
			tabla[a][3]=capitalPendiente;
		}
		
		request.setAttribute("tabla",tabla);
		
		RequestDispatcher rd=null;
		rd=getServletContext().getRequestDispatcher("/pinta.jsp");
		rd.forward(request,response);
		
		//----------------------------------------------------------------------------------------
		
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

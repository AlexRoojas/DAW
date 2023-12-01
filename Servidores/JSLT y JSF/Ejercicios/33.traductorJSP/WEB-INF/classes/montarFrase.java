import pojos.*;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class montarFrase extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);	
		
	}
	
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext contexto=getServletContext();
		HttpSession sesion=request.getSession();

		if(request.getParameter("palabraInglesaSelect")!=""){
			if(sesion.getAttribute("frase")==null){
				String frase="";
				frase=frase+" "+request.getParameter("palabraIngles");
				sesion.setAttribute("frase",frase);
				
				String fraseOriginal="";
				fraseOriginal=fraseOriginal+" "+request.getParameter("select");
				sesion.setAttribute("fraseOriginal",fraseOriginal);

			}else{
				
				String frase=(String)sesion.getAttribute("frase");
				frase=frase+" "+request.getParameter("palabraIngles");
				sesion.setAttribute("frase",frase);
				
				String fraseOriginal=(String)sesion.getAttribute("fraseOriginal");
				fraseOriginal=fraseOriginal+" "+request.getParameter("select");
				sesion.setAttribute("fraseOriginal",fraseOriginal);
				
			}
		}
		
		request.setAttribute("palabraInglesaSelect","");
		
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
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import java.net.URLEncoder;
import java.net.URLDecoder;

import java.text.*;
public class comprueba extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}
	
	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession sesion = request.getSession();
		ServletContext contexto = getServletContext();
		
		HashMap<String,String> mapaLogin = (HashMap<String,String>)contexto.getAttribute("mapaLogin");
		
		
		String cod = request.getParameter("cod");
		String usu = request.getParameter("usu");
		
		String mensaje="";
		
		if(cod!=null && usu!=null){
			
			
			
			if(!mapaLogin.containsKey(cod)){
				mensaje="Este codigo no esta usado";
			}else{
				String usuCodigo = mapaLogin.get(cod);
				if(mapaLogin.equals("usado")){
						mensaje="Codigo usado";
					}else{
						if(mapaLogin.equals(usu)){
							mensaje="Todo correcto para jugar, haz click para jugar";
						}else{
							mensaje="Este codigo ya pertenece a un usuario";
						}
					}
			}
			
		}else{
			
		}
		
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

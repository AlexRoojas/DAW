
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class FiltroEstadistica implements Filter {
	private int contador;
	public void init(FilterConfig fConfig) throws ServletException {
		contador=0;
	}
	public void destroy() {
	 // TODO Auto-generated method stub
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 // TODO Auto-generated method stub
	 // place your code here
	 
		HttpServletRequest peticion= (HttpServletRequest)request;
		ServletContext contexto= request.getServletContext();
		
		contador++;
		
	}
	 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	 
 
}
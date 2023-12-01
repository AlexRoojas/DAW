import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.URLDecoder;
import pojos.*;


public class index extends HttpServlet{

	public void init(ServletConfig config)throws ServletException {
		super.init(config);
		ServletContext contexto = getServletContext();
		
		String articulo= getInitParameter("Parametros");
		String splitArt[]= articulo.split(";");
		
		HashMap<Integer,Articulo> mapaArt = new HashMap<Integer,Articulo>();
		
		for(int i=0;i<splitArt.length;i++){
			String splitEntero[]=splitArt[i].split(":");
			
			Articulo art=new Articulo(i,splitEntero[0],Integer.parseInt(splitEntero[1]),Double.parseDouble(splitEntero[2]));
			mapaArt.put(i,art);
		}
		contexto.setAttribute("mapaArt",mapaArt);

	}

	public void proceso (HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType ("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tienda</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");

		out.println("<form action='Tienda.jsp'>");
	  
        out.println("<h1>Cesta</h1>");
		
        
       out.println("Nombre: <input type='text' name='usuario' /> <br />");
	
		
        out.println("<br /><input type='submit' value='Enviar' />");

		out.println("</div>");
		out.println("</body>");
		out.println("</center>");
		out.println("</html>");
	}

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		proceso(request,response);

	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		proceso(req,res);
	}
}
<%@page import="java.util.Date"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" import="mi2daw.*" import="javax.servlet.jsp.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>JSP Page</title>
		<style>
			p{color:darkblue; font-size:20px}
			caption {font-size:20px;font-wheight:bold}
			table{width:900px; border-collapse:collapse}
			table, th, td{ border:1px solid; padding:4px }
			td + td {width:70%}
			
		
		</style>
    </head>
    <body>
	<div style="width:400px; margin:auto">
	<form  action="pruebasEL.jsp">
       <label for="usuario">Usuario</label> <input type="text" name="usuario" value="maria"/>   <br/>  <br/>       
       Opcion
                        <select name="opciones" multiple >
                              <option value="Informatica">Informatica</option>
                              <option value="Cine">Cine</option>
                              <option value="Literatura">Literatura</option>
							     <option value="Musica">Música</option>
                        </select> <br/><br/>
        <input type="submit" name="boton" value="Acceder"/>   
        </form>
	</div>	
    
      <%if(request.getParameter("usuario")!= null)
      {%>  
   
			<jsp:useBean id="usuNuevo" scope="request" class="mi2daw.Cliente">
				<jsp:setProperty name="usuNuevo" property="*"/>           
			</jsp:useBean>  
		  
			<jsp:useBean id="usuNuevo1" scope="session" class="mi2daw.Cliente">
				<jsp:setProperty name="usuNuevo1" property="*"/>           
			</jsp:useBean>  
         

		<h3> 	Prueba de expresiones El's: </h3>
		<p style=>Hemos creado dos beans a partir de la clase mi2Daw.Cliente llamados <b>usuNuevo</b>,
		con escope request, y otro <b>usuNuevo1</b> con scope session. Los datos son tomados del formulario  </p>
	
		<table>
		<caption> Parametros </caption>
		<tr><th>expresión</th><th>Valor</th></tr>
        <tr> <td>\${param["usuario"]} </td><td> ${param["usuario"]}</td></tr>  
		<tr> <td>\${param.usuario}</td><td> ${param.usuario} </td></tr>
		</table>	
		<br>
		<table>
		<caption> Atributos - Atributo UsuNuevo (request) </caption>
		<tr><th>expresión</th><th>Valor</th></tr>
        <tr><td>\${requestScope["usuNuevo"].usuario} </td><td>"${requestScope["usuNuevo"].usuario}"</td></tr>
		<tr><td>\${request["usuNuevo"].usuario} </td><td> "${request["usuNuevo"].usuario}"" </td></tr>
		<tr><td>\${requestScope.usuNuevo} </td><td> ${requestScope.usuNuevo} </td></tr>
        <tr><td>\${requestScope.usuNuevo.usuario}</td><td> ${requestScope.usuNuevo.usuario} </td></tr>
        <tr><td>\${request.usuNuevo.usuario}</td><td>${request.usuNuevo.usuario}</td></tr>
        <tr><td>\${usuNuevo.usuario}</td><td>${usuNuevo.usuario}</td></tr>
		<tr><td>\${usuNuevo1.usuario}</td><td>${usuNuevo1.usuario}</td></tr>
		<tr><td>\${usuNuevo1.usuario}</td><td>${usuNuevo1.usuario}</td></tr>
		</table>
        <br>
		
		<table>
		<caption>Datos Genéricos </caption>
		<tr><th>expresión</th><th>Valor</th></tr>
        <tr><td>\${cookie["JSESSIONID"]} </td><td>${cookie["JSESSIONID"]}</td></tr>
		<tr><td>\${cookie.JSESSIONID} </td><td>${cookie.JSESSIONID}</td></tr>
		
		<tr><td>\${cookie.JSESSIONID.value} </td><td> ${cookie.JSESSIONID.value} </td></tr>
		<tr><td>\${paramValues.opciones}</td><td>${paramValues.opciones}</td></tr>
		<tr><td colspan="2"> \${ParamValues} </td>
		<c:forEach var="pa" items="${paramValues}">
			<tr>
				<td> ${pa.key}</td>
				<td>
						${valor}- 
					
				</td>
			</tr> 
		</c:forEach>
		<tr><td>\${ header["use-agent"]} </td><td> ${header["user-agent"]} </td></tr>
        <tr><td>\${ header.host}</td><td> ${header.host} </td></tr>
       
       	</table>
        
     
     <%  }%>       
	 
	 
		<c:forTokens  items="Mi jaca cabalga y corta el caminito de jerez" delims=" "  varStatus="pasada">
			${pasada.count}	  (index= ${pasada.index}) -- ${pasada.current} <br/>
			
		</c:forTokens>

<h2>Mi buscador de Google</h2>
<form> 
			<input type="text" name="query" >
			<input type="submit" value="voy a tener suerte"/>

</form>
<c:if  test="${!empty param.query}">
		<c:redirect url="http://www.google.es/search" >
		<c:param name="q" value="${param.query}" />
		</c:redirect>
</c:if>
        </body>
</html>

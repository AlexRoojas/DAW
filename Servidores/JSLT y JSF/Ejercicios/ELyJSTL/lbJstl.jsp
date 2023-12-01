<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" import="mi2daw.*" 
import="javax.servlet.jsp.*"%>

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
	<div style="width:500px; margin:40px">
	<form  action="lbJstl.jsp">
       <label for="usuario">Usuario</label> <input type="text" name="usuario" />   <br/>  <br/>       
       Opcion
                        <select name="opciones" multiple >
                              <option value="Cine">Cine</option>
                              <option value="Informatica">Informatica</option>
                              <option value="Literatura">Literatura</option>
							  <option value="Musica">Música</option>
                        </select> <br/><br/>
        <input type="submit" name="boton" value="Acceder"/>   
        </form>
	
	<c:if test="${!empty param.usuario}">
	
			<jsp:useBean id="usuNuevo" scope="request" class="mi2daw.Cliente">
				<jsp:setProperty name="usuNuevo" property="*"/>           
			</jsp:useBean>  
		<h4> Utilizacion de c:forEach con varStatus </h4>   
			<c:forEach var='i' items='${paramValues.opciones}' varStatus="j">
				${j.index} . ${j.count}  <c:out value='${i}' />   <br> 
					<c:if test="${j.last}">
						solo ha elegido ${j.count} afición/es
					</c:if>
			</c:forEach>   
		<h4> Utilizacion de c:choose </h4>	  
			<c:choose>
				<c:when test="${param.opciones=='Informatica'}">
				  Ha elegido  entre otras informatica - Seguimos con lo mismo ¡¡
				</c:when> 
				<c:otherwise>
				   Menos mal que ha elegido otra cosa ¡¡
				</c:otherwise>    
			</c:choose>
        
		<h4> c: out- probando  el   escapeXml   &lt;a href='index.html'&gt; ir  &lt;a&gt;  </h4>
			<c:out  value="<a href='index.html'>ir </a>" escapeXml="true" />		
		<h4> Utilizacion de c:set.</h4> Creacion variable "normal"
		
			<c:set var="numero" scope="request" value="3.5" />
		<br>
			<c:out value="la variable creada se llama numero  y vale ${numero}" />
		        
    	<h4> Utilizacion de c:set.</h4> Vamos a modificar  el objeto  usuNuevo cambiandole el nombre por Juan <br>	
		Su nombre actual 
			<c:out value="${requestScope.usuNuevo.usuario}" /><br>
			<c:set var="usu"  scope="request" target="${usuNuevo}" property="usuario" value="Juan" /> 
		
		Con el nombre cambiado y tirando de la variable recien creada, queda :
			<c:out value="${requestScope.usu}"  default="no se ha creado  variable auxiliar"/><br>
		
		Y  el nombre en  el  objeto  es: 
			<c:out value="${requestScope.usuNuevo.usuario}" />
		
	  
	 </c:if>
	 </div>	
   </body>
</html>
	
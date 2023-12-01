<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>

<head>
	
</head>

<body>


	<c:if test="${param.proceso ne null}">
		<c:choose>
		
			<c:when test="${param.proceso eq 'alta'}">
			
				<jsp:include page="Alta.jsp"/>
								
			</c:when>
			
			<c:otherwise><!--PARA ACCEDER AL TRADUCTOR JSP TIENES QUE ESTAR COMO USUARIO-->
					<c:choose>
						<c:when test="${listaUsuarios ne null}"><!--SI EL MAPA CONTIENE USUARIOS, ENTONCES VOY A COMPROBAR SI TIENE EL USUARIO QUE ME HAS INGRESADO-->
								
								<c:choose>
									<c:when test="${(listaUsuarios.get(param.nombre).getNombreUsuario() eq param.nombre) and (listaUsuarios.get(param.nombre).getBonos() gt 0)}"><!--COMPROBACION DE QUE ESTE EN EL MAPA-->										
										
										<jsp:useBean id="miDiccionario" scope="session" class="pojos.Diccionario">
											<jsp:setProperty name="miDiccionario" property="idiomasDiccionario" value="Español-Ingles"/>
										</jsp:useBean>
										
										<jsp:forward page="Traductor.jsp"/>
										
									</c:when>
									
									<c:when test="${(listaUsuarios.get(param.nombre).getNombreUsuario() eq param.nombre) and (listaUsuarios.get(param.nombre).getBonos() eq 0)}"><!--EL USUARIO GASTO TODOS SUS BONOS GRATUITOS-->
										<h1>EL USUARIO ESTA CREADO Y NO TIENE BONOS</h1>
									</c:when>
									
									<c:when test="${listaUsuarios.get(param.nombre) eq null}">
										<h2>NO ESTA EL USUARIO EN EL MAPA</h2>
									</c:when>
									
								</c:choose>
								
						</c:when>
						
						<c:otherwise><!--EL MAPA NO CONTIENE NADA-->
							<h1>Se debe dar de alta para acceder al traductor</h1>
						</c:otherwise>
					</c:choose>
			</c:otherwise>
			
		</c:choose>
	</c:if>
	

	
	<form action="index.jsp">	
		<label>Usuario: </label><input type="text" name="nombre" value="${cookie.ult_Usu.value}">
		<input type="submit" name="proceso" value="entrar"><br>
		<input type="submit" name="proceso" value="alta">
	</form>
	

</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8" import="pojos.*" import="javax.servlet.jsp.*" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel='stylesheet' href='styles.css'>
	</head>
	
	<body>
	<div>
	
	<jsp:useBean id="miChat" scope="application" class="pojos.Chat"/>
	<jsp:useBean id="usuario" scope="session" class="pojos.Usuario"/>
	
		
		
	<c:set var="objSala" scope="page" value="${miChat.getObtenerSala(param.salaSel)}"/>
	
	${objSala.setAddUsuario(usuario)}
	
	
	<c:choose>
		<c:when test="${not empty param.mensajeXD}">
			<jsp:useBean id="mensaje" scope="page" class="pojos.Mensajes">
				<jsp:setProperty name="mensaje" property="nick" value='${sessionScope.usuario.nick}'/>
				<jsp:setProperty name="mensaje" property="color" value='${sessionScope.usuario.color}'/>
				<jsp:setProperty name="mensaje" property="texto" value='${param.mensajeXD}'/>
				
			</jsp:useBean>
			${objSala.setAddMensaje(mensaje)}
			
		</c:when>
	</c:choose>
	
	
	
	<h1>${usuario.nick} bienvenido a ${param.salaSel}</h1>
	<div>
		<c:forEach var="men" items="${objSala.listaMensajes}">
			<p style="color:${men.color}">${men}</p>
		</c:forEach>
	</div>
	<div class="conectados">
		<p>Usuarios conectados:</p>
		<c:forEach var="usuCon" items="${objSala.usuariosConectados}">
			<p style="color:${usuCon.value.color}">${usuCon.key}</p>
		</c:forEach>
	</div>
	<form action="chat.jsp">
		<input type="text" name="mensajeXD"/>
		<input type="submit" value="Enviar">
		<input type="hidden" name="salaSel" value="${param.salaSel}">
	</form>
	<br>
	<form action="salaChat.jsp">
		<input type="submit" value="Volver">
		<input type="hidden" name="eliminar" value="${param.salaSel}">
	</form>
	<br>
	<form action="salir.jsp">
		<input type="submit" value="Desconectar">
		
	</form>
	
	</div>
	</body>
</html>
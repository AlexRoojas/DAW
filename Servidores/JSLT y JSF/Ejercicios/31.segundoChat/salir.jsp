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
		<h1>Usuario ${usuario.nick} desconectado</h1>
		<c:set var="eliminado" scope="page" value="${miChat.getObtenerSala(param.eliminar)}"/>
		${eliminado.setEliminaUsu(usuario)}
		
		<%session.invalidate();%>
		
		<form action="index.html">
		<input type="submit" value="Volver al menu principal">
	</form>
	</div>
	</body>
</html>
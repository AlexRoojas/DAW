<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="estilo.css">
</head>

<body>


	<c:choose>
		<c:when test="${param.procedencia eq 'pierdes'}">
			<h1>Adios ${miPartida.nombreJugador}, HAS PERDIDO</h1>
		</c:when>
		<c:otherwise>
			<h1>Adios ${miPartida.nombreJugador}, HAS CERRADO EL JUEGO</h1>
		</c:otherwise>
	</c:choose>
	
	
	<%session.invalidate();%>
	
	<form action="index.jsp">
		<input type="submit" value="Volver">
	</form>
	
	
	
</body>
</html>
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
	
	

	<jsp:useBean id="miCesta"  scope="session" class="pojos.Cesta"/>
	<jsp:getProperty  name="miCesta" property="nombreUsuario"/>
	
	<jsp:include page='salir' />
	
	<div class="container">
			<h1>Adios ${miCesta.nombreUsuario}</h1>
			<form action="index.html">
			<input type="submit" value="Volver a comprar">
			</form>
	</div>
	</body>
</html>
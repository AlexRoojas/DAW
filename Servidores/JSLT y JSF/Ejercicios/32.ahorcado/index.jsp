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
	<h1>Buenas tardes</h1>
	<form action="ahorcado.jsp">
		<label for="nom">Nombre:</label>
		<input type="text" name="nombre" id="nom">
		<br>
		<label for="ps">Contraseña:</label>
		<input type="password" name="contrasena" id="ps">
		<br>
		
		<input type="submit" value="Entrar"/>
	</form>
	</div>
	</body>
</html>
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
	
	
	<jsp:useBean id="general" scope="application" class="pojos.Sala">
		<jsp:setProperty name="general" property="nombreSala" value='general'/>	
	</jsp:useBean>
	
	<jsp:useBean id="cdc" scope="application" class="pojos.Sala">
		<jsp:setProperty name="cdc" property="nombreSala" value='cdc'/>	
	</jsp:useBean>
	
	<jsp:useBean id="miChat" scope="application" class="pojos.Chat">
		<jsp:setProperty name="miChat" property="nombreChat" value='Chat De Pago'/>	
		<jsp:setProperty name="miChat" property="addListaSalas" value="${general}"/>	
		<jsp:setProperty name="miChat" property="addListaSalas" value="${cdc}"/>	
	</jsp:useBean>
	
	
	
	<jsp:useBean id="usuario" scope="session" class="pojos.Usuario">
		<jsp:setProperty name="usuario" property="nick" value='${param.nick}'/>	
		<jsp:setProperty name="usuario" property="color" value='${param.color}'/>	
	</jsp:useBean>
	<h1>Seleccione la sala que quieras, <jsp:getProperty name='usuario' property='nick'/></h1>
	<form action="chat.jsp">
		<input type="radio" id="s1" name="salaSel" value="general"><label for="s1"><jsp:getProperty name='general' property='nombreSala'/></label>
		<input type="radio" id="s2" name="salaSel" value="cdc"><label for="s2"><jsp:getProperty name='cdc' property='nombreSala'/></label>
		<br> 
		<input type="submit" value="Entrar">
	</form>
	</div>
	</body>
</html>
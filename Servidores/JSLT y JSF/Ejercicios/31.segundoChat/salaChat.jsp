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
	
	<c:set var="nomSala" scope="page" value="${param.nomSala}"/>
	
	<c:if test="${not empty nomSala}">
		<jsp:useBean id="nuevaSala" scope="page" class="pojos.Sala">
			<jsp:setProperty name="nuevaSala" property="nombreSala" value="${nomSala}"/>
		</jsp:useBean>
		<jsp:setProperty name="miChat" property="addListaSalas" value="${nuevaSala}"/>
	</c:if>
	
	
	<c:set var="eliminar" scope="page" value="${param.eliminar}"/>
	<c:if test="${not empty param.eliminar}">
		<c:set var="eliSala" scope="page" value="${miChat.getObtenerSala(param.eliminar)}"/>
		${eliSala.setEliminaUsu(usuario)}
		borra
	</c:if>
	<h1>Seleccione la sala que quieras, <jsp:getProperty name='usuario' property='nick'/></h1>
	<form action="chat.jsp">
		<c:forEach var="inpu" items="${miChat.salas}">
			<p style="color:${usuCon.value.color}">${usuCon.key}</p>
			<input type="radio" name="salaSel" value="${inpu.key}"><label>${inpu.key}</label>
		</c:forEach>
		
		<br><br>
		<input type="submit" value="Entrar">
	</form>
	<br>
	<form action="salaChat.jsp">
		<input type="input" id="s3" name="nomSala"><input type="submit" value="Crear Nueva Sala">
	</form>
	</div>
	</body>
</html>
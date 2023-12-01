<%@page contentType="text/html" pageEncoding="UTF-8" import="pojos.*" import="javax.servlet.jsp.*" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Ahorcao</title>
		<link rel='stylesheet' href='styles.css'>
	</head>
	
	<body>
	<div>
	<!--Crear los beans-->
	<jsp:useBean id="juegoAhorcado" scope="application" class="pojos.Lista">
		<jsp:setProperty name="juegoAhorcado" property="cargarPalabras" value="${initParam.palabras}"/>	
	</jsp:useBean>
	
	
	<jsp:useBean id="miPartida" scope="session" class="pojos.Partida">
		<jsp:setProperty name="miPartida" property="usuario" value="${param.nombre}"/>	
		<jsp:setProperty name="miPartida" property="puntos" value="${requestScope.puntuacion}"/>
		<jsp:setProperty name="miPartida" property="cambiarPalabra" value="${juegoAhorcado.palabras}"/>
	</jsp:useBean>
	
	
	<c:if test="${!empty param.letraIntroducida}">
		<jsp:include page="/ComprobarLetra"/>
	</c:if>
	
	<!--Cambia palabra-->
	<c:if test="${!empty param.reiniciar}">
		<jsp:setProperty name="miPartida" property="cambiarPalabra" value="${juegoAhorcado.palabras}"/>
	</c:if>
	
	
	
	<h1>Juega al ahorcado XD</h1>
	Pista -> ${miPartida.palabraAcertada}
	<div id="stats">
		<h2>Estadísticas</h2>
		<p>Nombre: ${sessionScope.miPartida.usuario}</p>
		<p>Aciertos: ${sessionScope.miPartida.aciertos}</p>
		<p>Fallos: ${sessionScope.miPartida.fallos}</p>
		<p>Puntos: ${sessionScope.miPartida.puntos}</p>
	</div>
	
	<div class="palabra">
		<c:forEach var="letra" items="${sessionScope.miPartida.palabraAcertada}" >
			<p>${letra}</p>
		</c:forEach>
	</div>
	<c:set var="listCar" scope="session" value="${juegoAhorcado.getDividirCaracteres(initParam.caracteres)}"/>	
	<div id="letras">
		<c:forEach var="pal" items="${listCar}">
			<form action="ahorcado.jsp">
				<input type="hidden" name="letraIntroducida" value="${pal}"/>
				<c:if test="${sessionScope.miPartida.letrasUsadas.contains(pal)}">
					<input type="submit" name="letraT" value="${pal}" disabled />
				</c:if>
				<c:if test="${!sessionScope.miPartida.letrasUsadas.contains(pal)}">
					<input type="submit" name="letraT" value="${pal}" />
				</c:if>
			</form>
		</c:forEach>
		
	</div>
	<img src="img/${miPartida.fallos}.jpg">
	<c:if test="${sessionScope.miPartida.fallos eq 5}">
		<h2>Has muerto,ayps</h2>
		<form action="Terminar.jsp">
				<input type="submit" value="Cerrar Sesión"/>
		</form>
	</c:if>
	
	
	<c:if test="${miPartida.aciertos eq miPartida.getAciertosMax()}">
			<jsp:setProperty name="miPartida" property="aciertos" value="${0}"/>
			<jsp:setProperty name="miPartida" property="fallos" value="${0}"/>
			
			<h2>Vaya triplaso enhorabuena</h2>
			<form action="Terminar.jsp">
				<input type="submit" value="Desconectar"/>
			</form>
			<form action="Ahorcado.jsp">
				<input type="hidden" name="reiniciar" value="si"/>
				<input type="submit" value="Volver a jugar"/>
			</form>
	</c:if>
	</div>
	</body>
</html>
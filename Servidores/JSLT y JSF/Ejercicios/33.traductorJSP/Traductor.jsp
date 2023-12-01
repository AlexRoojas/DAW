<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>

<head>
	<style>
	
		.formu{
			margin-top:10px;
		}
	
		.fraseAConstruir{
			display:inline;
			heigth:70px;
			width:100px;
			border:1px solid black;
			
		}
	</style>
</head>

<body>

	<c:if test="${param.palabraIngles ne null}">
		<jsp:include page="montarFrase"/>
		<c:set var="frases" scope="session" value="${sessionScope.frase}"/>
		<c:set var="frasesOriginales" scope="session" value="${sessionScope.fraseOriginal}"/>
	</c:if>
	
	<h2>Traductor ${miDiccionario.idiomasDiccionario}</h2>	

	<h1>Bienvenido al traductor ${usuario.nombreUsuario} le quedan ${usuario.bonos} bonos</h1>

	<h3>Frases ya traducidas: </h3>
	
	<c:forEach var="traduccion" items="${usuario.listaFrasesTraducidas}">
		<span>${traduccion}</span><br>
	</c:forEach>
	
	
	<c:choose>
	
		<c:when test="${usuario.getBonos() gt 0}">
			<label>Seleccione la palabra: </label>
		
			<form action="Traductor.jsp">
			
				<select name="select">
					<c:forEach var="palabra" items="${miDiccionario.palabras}">
						<option  value="${palabra.key}" selected>${palabra.key}</option>
					</c:forEach>
				</select>
				
				<input type="submit" name="verSelect" value="ver">	
				<input type="hidden" name="cargaSelect" value="si">
				
				<select name="palabraIngles">
					<c:if test="${param.cargaSelect ne null}">	
					
						<c:choose>
							<c:when test="${param.palabraInglesaSelect eq null}">
								<c:forEach var="palabra" items="${miDiccionario.palabras}">
									 <c:if test="${palabra.key eq param.select}">
											<c:forEach var="palabraIngles" items="${palabra.value}">
												<option value="${palabraIngles}">${palabraIngles}</option>
											</c:forEach>
									 </c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
					</c:if>
				</select>
				
				
			  <input type="submit" name="palabraInglesaSelect" value="seleccionar">
					
			</form>
			
			</c:when>
			
			<c:otherwise>
				<h1>HAS AGOTADO TODOS LOS BONOS</h1>
			</c:otherwise>
			
	</c:choose>
	

	<form action="Traductor.jsp" class="formu">
	
		<div class="fraseAConstruir">
			${frases}		
		</div>
		
		<input type="submit" name="opcionFrase" value="limpiar">
		<input type="submit" name="opcionFrase" value="ok">
		<input type="submit" name="opcionFrase" value="finalizar">
		
	</form>
		
		
	<c:choose>
		<c:when test="${param.opcionFrase eq 'limpiar'}">
			<c:remove var="frases" scope="session"/>
			<c:remove var="frase" scope="session"/>
			
			<c:remove var="frasesOriginales" scope="session"/>
			<c:remove var="fraseOriginal" scope="session"/>
		</c:when>
		
		<c:when test="${param.opcionFrase eq 'ok'}">
			<c:if test="${usuario.getBonos() gt 0}">
				<jsp:forward page="ingresarPalabras">
					<jsp:param name="fraseT" value="${frases}"/>
					<jsp:param name="fraseO" value="${frasesOriginales}"/>
				</jsp:forward>
			</c:if>
		</c:when>
		
		<c:when test="">
		
		</c:when>
	</c:choose>

	
	<br><br>
	
	<form action="AltaPalabras.jsp">
		<input type="submit" value="alta de palabras nuevas">
	</form>
	
	<form action="crearCookie">
		<input type="submit" value="desconectar">
		<input type="hidden" name="usu" value="${usuario.nombreUsuario}">
	</form>

</body>
</html>
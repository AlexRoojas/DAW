<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel='stylesheet' href='estiloTabla.css'>
	</head>
	<link rel="stylesheet" href="estilo.css">
	<style>
	img{
		width: 194px;
		height: 159px;
	}
	input[type="submit"]{
		margin-top: 20px;
			padding: 10px;
			width: 80%;
			font-size: 130%;
			border: solid green 1px;
			background: white;
			border-radius: 2px;
			cursor: pointer;
			background-image: linear-gradient(to bottom,#fefefe,#eeeeee);
			box-shadow: inset 0 -1px rgba(0,0,0,0.1), 4px 4px rgba(0,0,0,0.1);
	}
	</style>
	<jsp:useBean id="cesta" scope="session" class="pojos.Cesta">
		<jsp:setProperty name="cesta" property="usuario" value="${param['usuario']}"/>
 	</jsp:useBean>
	
	
	<c:set target="${sessionScope.cesta}" property="usuario" value="requestScope.usuario"/>
	
	
	<jsp:useBean id="tienda" scope="application" class="pojos.Tienda">
		<jsp:setProperty name="tienda" property="*" />
 	</jsp:useBean>
	
	
	
	<jsp:setProperty name="tienda" property="nombreTienda" value="Gucci"/>
	<jsp:setProperty name="tienda" property="listaArticulo" value="${applicationScope.mapaArt}"/>
	
	
	<body>
	<h1>Bienvenido a tu tienda ${param["usuario"]}</h1>
	<div>
		<form action="addArticulo">
		<table>
			<c:forEach var="art" items="${tienda.listaArticulo}">
				<tr>
					<td>Cod :${art.value.codigo}</td>
					<td>Articulo: ${art.value.nombre}</td>
					<td><img src="${art.value.imagen}"></td>
					<td>${art.value.unidades} unidades</td>
					<td><input type="checkbox" name="artSel" value="${art.value.codigo}"></td>
				</tr>
			</c:forEach>	
		</table>
		<input type="submit" value="Añadir Articulos uwu">
		</form>
	</div>
	</body>
</html>
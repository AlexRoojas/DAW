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
	
	Cesta de ${miCesta.nombreUsuario}

	<jsp:useBean id="miCesta"  scope="session" class="pojos.Cesta"/>
	<jsp:getProperty  name="miCesta" property="nombreUsuario"/>
	
	<div class="container">
			<form action="Tienda.jsp">
			<table>
			<tr>
				<th>Imagen</th>
				<th>Nombre</th>
				<th>Cantidad</th>
			</tr>
			<c:forEach var="articuloCesta" items="${miCesta.carrito}">
			<c:set var="objArticulo" scope="page" value="${miTienda.getObtenerArticulo(articuloCesta.key)}"/>
			<tr>
				<td><img src="imagenes/${objArticulo.imagenArticulo}.png"></td>
				<td>${objArticulo.nombreArticulo}</td>
				<td>${objArticulo.precioArticulo}</td>
				<td>${articuloCesta.value}</td>
				<td>
				<form action='verCesta.jsp'>
					<input type="submit" value="Eliminar" name="opArt">
					<input type="submit" value="Añadir" name="opArt">
					<input type="submit" value="Quitar" name="opArt">
					<input type="hidden" name="artSel2" value="${objArticulo.codigoArticulo}">
				</form>
				</td>
			</tr> 
				</c:forEach>
				
			</table>
			</form>
			
			
			<form action="confirmarPedido.jsp">
			<input type="submit" value="Confirmar Pedido">
			</form>
			
			<form action="Tienda.jsp">
			<input type="submit" value="Volver a comprar">
			</form>
			
			<form action="Salir">
			<input type="submit" value="Salir sin comprar">
			</form>
			
		</div>
	</body>
</html>
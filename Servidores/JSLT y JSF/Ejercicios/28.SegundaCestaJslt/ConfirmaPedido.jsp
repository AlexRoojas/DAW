<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="estilo.css"/>
	</head>
	
	<jsp:useBean id="cestaTienda" scope="session" class="pojos.Cesta"/>

	<jsp:useBean id="infoTienda" scope="application" class="pojos.Tienda"/>

	
	<body>
		<header>
			<h1>Hasta luego ${cestaTienda.usuario}</h1>
			<h2>Datos de la factura:</h2>
		</header>
		
		
		<table class='tablaArt'>
			<tr>
				<th>Articulo comprado</th>
				<th>Unidades compradas</th>
				<th>Precio</th>
				<th>total</th>
			</tr>
			<c:set var="precioTotal" scope="page" value="0"/>
			<c:forEach var="Art" items="${cestaTienda.cestaCompra}">
				<c:set var="codArt" scope="page" value="${Art.key}"/>
				<c:set var="unidadesComprada" scope="page" value="${cestaTienda.cestaCompra.get(codArt)}"/>
				<c:set var="precioUnidades" scope="page" value="${infoTienda.listaArticulos.get(codArt).precio}"/>
				<c:set var="totalUnidad" scope="page" value="${precioUnidades*unidadesComprada}"/>
				<tr><td>${infoTienda.listaArticulos.get(codArt).nombre}</td>
				<td>${cestaTienda.cestaCompra.get(codArt)}</td>
				<td>${infoTienda.listaArticulos.get(codArt).precio}</td>
				<td>${totalUnidad}</td>
				<c:set var="precioTotal" scope="page" value="${totalUnidad+precioTotal}"/>
				</tr>
			</c:forEach>
		</table>
		
		
		<table class='tablaArt'>
			<th>Total</th><th>Precio total</th>
			<tr><td>Total ticket: </td><td>${precioTotal}</td></tr>
			<c:set var="IVA" scope="page" value="${precioTotal*0.21}"/>
			<tr><td>Iva(21%) </td><td>${IVA}</td></tr>
			<c:set var="totalIva" scope="page" value="${precioTotal*1.21}"/>
			<tr><td>Total IVA: </td><td>${totalIva}</td></tr>
		</table>
		
		<jsp:include page='/Fin'/>
		
		<form action='index.html'>
			<input type='submit' value='Volver a comprar' class='enviar'>
		</form>
	</body>
</html>
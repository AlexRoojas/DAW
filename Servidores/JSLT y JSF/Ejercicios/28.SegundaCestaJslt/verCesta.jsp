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

	<jsp:useBean id="cestaTienda" scope="session" class="pojos.Cesta">
 	</jsp:useBean>
	
	<jsp:useBean id="infoTienda" scope="application" class="pojos.Tienda">
 	</jsp:useBean>


	<jsp:include page='/modificaExistencias'/>
	
	<body>
		<header>
			<h1>Los articulos que llevas hasta el momento son: </h1>
		</header>
		
		<table class='tablaArt'>
		<tr>
			<th colspan=2>Articulos</th>
			<th >Unidades</th>
			<th>
			</th>
		</tr>
		<c:forEach var="Articulo" items="${cestaTienda.cestaCompra}">
			<c:set var="objArticulo" scope="page" value="${infoTienda.getObtenerArticulo(Articulo.key)}"/>
			<tr>
				<td>${objArticulo.nombre}</td>
				<td><img src="imagenes/${objArticulo.img}.jpg"></td>
				<td>${Articulo.value}</td>
				<td>
					<form action='verCesta.jsp'>
						<input type='hidden' name='codArticuloElm' value="${Articulo.key}"/>
						<input type='submit' value='Eliminar' name='opcionArticulo'><br>
						<input type='submit' value='Anadir' name='opcionArticulo' class='botonCesta'>
						<input type='submit' value='Quitar' name='opcionArticulo' class='botonCesta'>
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
		<form action='Tienda.jsp'>
			<input type='submit' value='Seguir comprando' class='enviar'>
		</form>
		<form action='ConfirmaPedido.jsp'>
			<input type='submit' value='Confirmar Pedido' class='enviar'>
		</form>
		<form action='Salir.jsp'>
			<input type='hidden' name='procedencia' value="si"/>
			<input type='submit' value='Salir sin Comprar' class='enviar'>
		</form>
	</body>
	
</html>
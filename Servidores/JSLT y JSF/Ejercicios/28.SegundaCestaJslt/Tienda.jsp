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
		<jsp:setProperty name="cestaTienda" property="usuario" value="${param['nombre']}" />
 	</jsp:useBean>
	
	<jsp:useBean id="infoTienda" scope="application" class="pojos.Tienda">
		<jsp:setProperty name="infoTienda" property="nombreTienda" value="Decarthon"/>
		<jsp:setProperty name="infoTienda" property="anadirArticulosTiendas" value="${initParam['Parametros']}"/>
 	</jsp:useBean>
	
	<jsp:include page='/modificaExistencias'/>
	

	

	<body>
		<header>
			<h1>hola ${cestaTienda.usuario}</h1>
			<h2>Bienvenido a ${infoTienda.nombreTienda}</h2>
		</header>
		
		<table>
			<th colspan=2>Lista de articulos disponibles</th>
			<th>Unidades</th>
			<th>Precio</th>
			<th colspan=2> Unidades para Comprar</th>
				<c:forEach var="Articulo" items="${infoTienda.listaArticulos}">
					<form action="Tienda.jsp">
						<tr>
							<td><img src="imagenes/${Articulo.value.img}.jpg"></td>
							<td>${Articulo.value.nombre}</td>
							<c:choose>
								<c:when test="${Articulo.value.existencias ne 0}">
									<td>${Articulo.value.existencias}</td>
								</c:when>
								<c:otherwise>
									<td><p style="color:red">No hay existencias disponibles</p></td>
								</c:otherwise>
							</c:choose>
							<td>${Articulo.value.precio} €</td>
							<td><input type='number' class='numero' name='cantidad' value='0'></td>
							<td><input type='submit' value='enviar' class='enviar2'></td></tr>
							<input type='hidden' name='codArticuloSelect' value="${Articulo.value.codigo}"/>
						</tr>				
					</form>				
				</c:forEach>
		</table>	
		<form action='verCesta.jsp'>
			<input type='submit' value='ver cesta' class='enviar'>
		</form>

	</body>
</html>
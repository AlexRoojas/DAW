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
	
	<jsp:include page='/Fin'/>
	
	<body>
		<header>
			<h1>Hasta luego ${cestaTienda.usuario}</h1>
		</header>
		
		
		<main>
			<p>Los articulos han sido vaciados en la cesta correctamente</p>
			<form action='index.html'>
				<input type='submit' value='Volver a comprar' class='enviar'>
			</form>
		</main>
	</body>
</html>
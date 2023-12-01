<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>

<head>
	
</head>

<body>
	
	<jsp:useBean id="usuario" scope="session" class="pojos.Usuario"/>
	<jsp:setProperty name="usuario" property="nombreUsuario" value="${param.nombre}"/>
	
	<jsp:useBean id="listaUsuarios" scope="application" class="java.util.HashMap" type="HashMap<String,Usuario>"></jsp:useBean>
	
	${listaUsuarios.put(usuario.getNombreUsuario(),usuario)}
		
</body>
</html>
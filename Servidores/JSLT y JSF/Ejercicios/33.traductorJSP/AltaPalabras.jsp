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

	 <c:if test="${param.darAlta ne null}">
		${miDiccionario.setAddPalabras(param.palabraEspaniol,param.palabrasIngles.split(";"))}
	 </c:if>

		
	  <form action="AltaPalabras.jsp">
			<input type="text" name="palabraEspaniol">
			<input type="text" name="palabrasIngles">
			<input type="submit" name="darAlta" value="Alta Nueva Palabra">
	  </form>
	  
	  <form action="Traductor.jsp">
			<input type="submit" value="volver traductor">
	  </form>
		
</body>
</html>
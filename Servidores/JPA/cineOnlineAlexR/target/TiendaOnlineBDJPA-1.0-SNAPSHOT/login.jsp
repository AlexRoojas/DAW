<%-- 
    Document   : login
    Created on : 15 ene. 2022, 19:19:43
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <form action="login.jsp">
            <label for="nombre">Usuario</label>
            <input type="text" name="nombre"/>
            <label>Contraseña</label>
            <input type="password" name="contra"/>
            <input type="submit" value="Entrar">
        </form>
        
        <c:if test="${!empty param.nombre}">
            <jsp:include page="compruebaUsu"/>
            
            <c:choose>
            <c:when test="${!empty sessionScope.usuario}">
                <jsp:forward page="index.jsp"/>
            </c:when>
            <c:otherwise>
                <h1 id="error" style="color:red;">Usuario / Contraseña incorrecta</h1>
            </c:otherwise>
        </c:choose>
        </c:if>
        
    </body>
</html>

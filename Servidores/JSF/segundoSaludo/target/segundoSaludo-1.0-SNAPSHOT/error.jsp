<%-- 
    Document   : error
    Created on : 3 feb. 2022, 19:41:54
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h3>CONTRASEÑA INCORRECTA</h3>
            <h:outputLink value="entrar.jsp">Volver a intentarlo</h:outputLink>
        </body>
    </html>
</f:view>

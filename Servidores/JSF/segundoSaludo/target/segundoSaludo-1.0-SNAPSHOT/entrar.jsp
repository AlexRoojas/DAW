<%-- 
    Document   : entrar
    Created on : 3 feb. 2022, 14:09:52
    Author     : Usuario
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
            <h1><h:outputText value="Mayichi Guardameta"/></h1>
            <h:form>
                Nombre:
                <h:inputText value="#{saludo.usuario}"/>
                <br>
                Contraseña:
                <h:inputSecret value="#{saludo.contra}"/>
                
                <br>
                <h:commandButton action="#{saludo.validarClave}" value="Entrar"/>
                
            </h:form>
        </body>
    </html>
</f:view>

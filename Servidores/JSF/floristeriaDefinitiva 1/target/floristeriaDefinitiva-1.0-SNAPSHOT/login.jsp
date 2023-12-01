<%-- 
    Document   : login
    Created on : 22 feb. 2022, 18:18:03
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
            <style>
                body{
                    text-align: center;
                }
            </style>
        </head>
        <body>
            <h:form>
            <h1><h:outputText value="Nombre"/></h1>
            <h:inputText value="#{beanLog.usuario}"/>
            <h1><h:outputText value="Contraseña"/></h1>
            <h:inputSecret value="#{beanLog.contra}"/>
            <h:commandButton value="Entrar" action="#{beanLog.compruebaUsu()}"/>
            </h:form>
            
            <h2><h:outputText value="#{beanLog.error}" /></h2>
        </body>
    </html>
</f:view>

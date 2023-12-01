<%-- 
    Document   : index
    Created on : 10 feb. 2022, 14:03:48
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
            
            <h:form>
                <h:outputText value="Nombre"/>
                <h:inputText value="#{formuGenerico.nombre}">
                </h:inputText>
                <h:outputText value="Apellidos"/>
                <h:inputText value="#{formuGenerico.apellido}">
                </h:inputText>
                <h:outputText value="Edad"/>
                <h:inputText value="#{formuGenerico.edad}">
                </h:inputText>
                <h:outputText value="Email"/>
                <h:inputText value="#{formuGenerico.email}">
                    <f:converter converterId="converterEmail"/>
                </h:inputText>
                <h:outputText value="Nif"/>
                <h:inputText value="#{formuGenerico.nif}">
                    <f:converter converterId="converterNif"/>
                </h:inputText>
                <h:commandButton value="Mostrar" action="ir"/>
            </h:form>
        </body>
    </html>
</f:view>

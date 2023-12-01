<%-- 
    Document   : index
    Created on : 7 feb. 2022, 14:35:20
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
            <title>Alta Persona</title>
        </head>
        <body>
            <h1>Alta de humano</h1>
            <h:form>
                <h:outputLabel value="Nombre"/>
                <h:inputText value="#{datos.nombre}"/>
                <br>
                <h:outputLabel value="Apellidos"/>
                <h:inputText value="#{datos.apellidos}"/>
                <br>
                <h:outputLabel value="Fecha Nacimiento"/>
                <h:inputText value="#{datos.fnacimiento}">
                    <f:convertDateTime pattern="dd-MM-yyyy"/>
                </h:inputText>
                <br>
                <h:outputLabel value="Observaciones"/>
                <h:inputTextarea value="#{datos.observaciones}"/>
                <br>
                
                <h:commandButton value="Alta" actionListener="#{datos.altaPersona()}" action="ir"/>
            </h:form>
                <h:form>
                    <h:commandButton value="Mostrar" action="ir"/>
                </h:form>
        </body>
    </html>
</f:view>

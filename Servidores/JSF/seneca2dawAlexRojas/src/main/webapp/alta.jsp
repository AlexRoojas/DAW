<%-- 
    Document   : alta
    Created on : 25 feb. 2022, 13:30:40
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
            <h:form enctype="multipart/form-data">
                <h3><h:outputText value="DNI"/></h3>
              
            <h:inputText value="#{beanAlta.dni}">
               <f:validator validatorId="validadorNif"/> 
            </h:inputText>
                
            <h3><h:outputText value="Nombre Y Apellidos"/></h3>
            <h:inputText value="#{beanAlta.nomApe}"/>
            <h3><h:outputText value="Localidad"/></h3>
            <h:inputText value="#{beanAlta.localidad}"/>
            
            <h3><h:outputText value="Curso"/></h3>
            <h:selectOneMenu value="#{beanAlta.idCurso}">
                <f:selectItems value="#{beanFlore.listaCursos()}"/>
            </h:selectOneMenu>
            
            <h:inputFile value="#{beanAlta.archivo[0]}" />
            
            
            <h:commandButton value="Crear" action="#{beanAlta.altaAlum()}" />
            </h:form>
        </body>
    </html>
</f:view>

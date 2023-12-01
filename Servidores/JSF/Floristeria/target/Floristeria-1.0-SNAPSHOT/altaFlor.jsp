<%-- 
    Document   : altaFlor
    Created on : 21 feb. 2022, 13:20:06
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
            <h3><h:outputText value="Nombre Común"/></h3>
            <h:inputText value="#{beanFlores.nombreCom}"/>
            <h3><h:outputText value="Nombre Científico"/></h3>
            <h:inputText value="#{beanFlores.nombreCi}"/>
            <h3><h:outputText value="Tipo Luz - Agua"/></h3>
            <h:selectOneMenu value="#{beanFlores.codLuzSel2}">
                <f:selectItems value="#{beanFlores.listaLuz()}"/>
            </h:selectOneMenu>
            <h3><h:outputText value="Precio"/></h3>
            <h:inputText value="#{beanFlores.precio}"/>
            <h3><h:outputText value="Unidades Vendidas"/></h3>
            <h:inputText value="#{beanFlores.uniVendidas}"/>
            
            
            <h:commandButton value="Crear" action="#{beanFlores.altaFlor()}" />
            </h:form>
        </body>
    </html>
</f:view>

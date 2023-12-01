<%-- 
    Document   : altaFlor
    Created on : 22 feb. 2022, 18:17:43
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
            <h:form enctype="multipart/form-data">
            <h3><h:outputText value="Nombre Común"/></h3>
            <h:inputText value="#{beanAlta.nombreCom}"/>
            <h3><h:outputText value="Nombre Científico"/></h3>
            <h:inputText value="#{beanAlta.nombreCi}"/>
            <h3><h:outputText value="Tipo Luz - Agua"/></h3>
            <h:selectOneMenu value="#{beanAlta.codLuzSel2}">
                <f:selectItems value="#{beanFlore.listaLuz()}"/>
            </h:selectOneMenu>
            <h3><h:outputText value="Precio"/></h3>
            <h:inputText value="#{beanAlta.precio}"/>
            <h3><h:outputText value="Unidades Vendidas"/></h3>
            <h:inputText value="#{beanAlta.uniVendidas}"/>
            
            <h:inputFile value="#{beanAlta.archivo[0]}" />
            
            
            <h:commandButton value="Crear" action="#{beanAlta.altaFlor()}" />
            </h:form>
        </body>
    </html>
</f:view>

<%-- 
    Document   : index
    Created on : 15 feb. 2022, 9:52:19
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
            <f:loadBundle basename="mensajes" var="mens"/>
            <title><h:outputText value="#{mens.titulo}"/></title>
        </head>
        <style>
            .peq{
                width:5%;
            }
            h1{
                color: #8c50e3;
            }
        </style>
        <body>
            <h2><h:outputText value="#{mens.traductor}" /></h2>
            
            <h:form>
                <h:commandButton image="img/esp.png" value="es" actionListener="#{beanTraductor.esss()}" styleClass="peq"/>
                <h:commandButton image="img/usa.png" value="usa" actionListener="#{beanTraductor.ingle()}" styleClass="peq"/>
            </h:form>  
            
            <h:form>    
                <h3><h:outputText value="#{mens.frases}" /></h3>
                
                <p><h:outputText value="#{mens.palabra}" /></p>
                
                <h:selectOneMenu value="#{beanTraductor.codPalES}" onchange="submit()" valueChangeListener="#{beanTraductor.listaPalEng}">
                    <f:selectItems value="#{beanTraductor.listaPalabras()}"/>
                </h:selectOneMenu>
                
                <h:selectOneListbox value="#{beanTraductor.codPalEN}" onchange="submit()" valueChangeListener="#{beanTraductor.addPalabra}">
                    <f:selectItems value="#{beanTraductor.listaPalabrasInglesSel}"/>
                </h:selectOneListbox>
                
                <br>
                <h1><h:outputText value="#{beanTraductor.palabraEntera}" /></h1>
                <h1><h:outputText value="#{beanTraductor.fraseEspa}" /></h1>
            </h:form>
            <h:form>
                <h:commandButton value="#{mens.limpiar}" actionListener="#{beanTraductor.limpiaUltimo()}" />
            </h:form>
                <h:messages/>
        </body>
    </html>
</f:view>

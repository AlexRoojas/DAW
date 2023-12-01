<%-- 
    Document   : index
    Created on : 9 feb. 2022, 9:47:45
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
            <style>
                .centro{
                    text-align: center;
                }
            </style>
        </head>
        <body>
            <h2><h:outputText value="#{mens.portada}" /></h2>
            
            <h:form>
                
                <h:panelGrid columns="3" style="border:solid black 1px">
                    <h:outputText value="#{mens.cantidad}"/>
                    
                    <h:panelGroup>
                        <h:inputText id="capital" value="#{pago.dcapital}" size="11">
                            <f:convertNumber minIntegerDigits="4"/>
                        </h:inputText>
                        €
                    </h:panelGroup>
                    
                    <h:panelGroup styleClass="centro">
                        <h:outputText value="#{mens.frecuencia_pago}" />
                        <h:selectOneRadio value="#{pago.periocidad}">
                            <f:selectItem itemValue="mes" itemLabel="#{mens.mensual}"/>
                            <f:selectItem itemValue="ano" itemLabel="#{mens.anual}"/>
                        </h:selectOneRadio>
                    </h:panelGroup>
                     
                    
                    <h:outputText value="#{mens.tae}"/>
                    
                     <h:panelGroup>   
                        <h:inputText value="#{pago.dtae}" size="4">
                            <f:convertNumber maxFractionDigits="3"/>
                        </h:inputText>
                        %    
                    </h:panelGroup>
                        
                    <h:panelGroup>
                        <h:outputText value="#{mens.periodos}"/>
                        
                        <h:inputText value="#{pago.inper}" size="7">
                            <f:convertNumber minIntegerDigits="1"/>
                        </h:inputText>
                    </h:panelGroup>
                    
                </h:panelGrid>
                
                <br><br>
                        
                <h:commandButton value="#{mens.calcular}" actionListener="#{pago.calculoCuota()}"/>
                
                <br><br>
                
                <h:panelGrid columns="2" style="border:solid green 1px">
                    <h:outputText value="#{mens.cuota}"/>
                    
                    <h:outputText value="#{pago.dcuota}" >
                        <f:convertNumber type="currency"/>
                    </h:outputText>
                </h:panelGrid>
                
            </h:form>    
        </body>
    </html>
    <h:messages/>
</f:view>

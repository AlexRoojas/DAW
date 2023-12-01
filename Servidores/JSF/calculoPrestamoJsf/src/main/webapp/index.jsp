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
                .verde{
                    background-color: green;
                }
            </style>
        </head>
        <body>
            <h2><h:outputText value="#{mens.portada}" /></h2>
            
            <h:form>
                
                <h:panelGrid columns="3" style="border:solid black 1px">
                    
                    
                    <h:panelGroup>
                        <h:outputText value="#{mens.idioma}"/>

                        <h:selectOneMenu value="#{pago.idioma}" onchange="submit()" valueChangeListener="#{pago.cambioIdioma}">
                            <f:selectItems value="#{pago.listaIdiomas}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>

                    <h:outputText value="#{mens.cantidad}"/>
                    
                    <h:panelGroup>
                        <h:inputText id="capital" value="#{pago.dcapital}" size="11">
                            <f:convertNumber type="currency"/>
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
                        
                <h:commandButton value="#{mens.calcular}" actionListener="#{pago.calculoCuota()}" />
                
                <br><br>
                
                <h:panelGrid columns="2" style="border:solid green 1px">
                    <h:outputText value="#{mens.cuota}"/>
                    
                    <h:outputText value="#{pago.dcuota}" >
                        <f:convertNumber type="currency"/>
                    </h:outputText>
                </h:panelGrid>
                
                
                
                <h:commandButton id="b" value="#{mens.cuadro}" actionListener="#{pago.calculaCuadro()}"  binding="#{pago.respaldoBoton}" />
                <h:message for="b"/>
                
                <h:dataTable value="#{pago.cuadro}" var="columna" border="10" bgcolor="#F1F1F1"
                             style="text-align: center" cellpadding="5" cellspacing="3" width="25%" frame="hsides" >
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Pago"/>
                        </f:facet>
                        <h:outputText value="#{columna[0]}">
                            <f:convertNumber type="number"/>
                        </h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Intereses"/>
                        </f:facet>
                        <h:outputText value="#{columna[1]}">
                            <f:convertNumber type="currency"/>
                        </h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Capital"/>
                        </f:facet>
                        <h:outputText value="#{columna[2]}">
                            <f:convertNumber type="currency"/>
                        </h:outputText>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Restante"/>
                        </f:facet>
                        <h:outputText value="#{columna[3]}">
                            <f:convertNumber type="currency"/>
                        </h:outputText>
                    </h:column>
                </h:dataTable>
                
            </h:form>    
                
                
        </body>
    </html>
    <h:messages/>
</f:view>

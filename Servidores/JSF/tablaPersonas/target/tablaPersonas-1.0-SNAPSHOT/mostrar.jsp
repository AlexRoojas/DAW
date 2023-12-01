<%-- 
    Document   : mostrar
    Created on : 7 feb. 2022, 16:46:23
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
            <h1><h:outputText value="Tabla de Personas"/></h1>
            <h:form>
                <h:dataTable value="#{cargaPersonas.listaPersona}"  var="columna" binding="#{cargaPersonas.respaldoTabla}" border="10"
                         style="text-align: center" >
                <f:facet name="header">
                    <h:outputText value="Tabla del Personas"/>
                </f:facet>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:inputText value="#{columna.nombre}"/>
                    
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Apellidos"/>
                    </f:facet>
                    <h:inputText value="#{columna.apellidos}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Fecha Nacimiento"/>
                    </f:facet>
                    <h:inputText value="#{columna.fnacimiento}">
                        <f:convertDateTime pattern="dd-MM-yyyy"/>
                    </h:inputText>
                    
                </h:column>
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Observaciones"/>
                    </f:facet>
                    <h:inputText value="#{columna.observaciones}"/>
                </h:column>
                <h:column>
                    <h:commandButton value="Modificar" actionListener="#{cargaPersonas.editaPersona()}"/>
                </h:column>
                <h:column>
                    <h:commandButton value="Borrar" actionListener="#{cargaPersonas.eliminaPersona()}"/>
                </h:column>
                <h:column>
                    <h:commandButton value="Ver" actionListener="#{cargaPersonas.verPersona()}"/>
                </h:column>
            </h:dataTable>
            
                
                
            <h:outputText value="#{cargaPersonas.filaSelc}"/>
            <br>
            <h:outputText value="#{cargaPersonas.listaPersonasTabla.get(cargaPersonas.filaSelc)}"/>
            <br>
            <h:outputText value="#{cargaPersonas.personaSelc.nombre}"/>
            </h:form>
            
            <h:form>
                <h:commandButton value="Volver" action="volver"/>
            </h:form>
        </body>
    </html>
    <h:messages/>
</f:view>

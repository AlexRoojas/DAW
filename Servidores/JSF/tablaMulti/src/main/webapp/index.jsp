<%-- 
    Document   : index
    Created on : 7 feb. 2022, 12:33:30
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
            <title>Tabla Multiplicar</title>
        </head>
        <body>
            <h1>Cálculo de la Tabla de Multiplicar</h1>
            
            <h:form>
                <p>
                    Introduce Nº Tabla: <h:inputText size="1" value="#{calcultaTabla.numero}"/>
                    <br>
                    <h:commandButton value="Mostrar" action="mostrar"/>
                </p>
            </h:form>
                <h:dataTable value="#{calcultaTabla.resultado}" var="resultado">
                    <h:column>
                        <f:facet name="header">
                            Resultado
                        </f:facet>
                        <h:outputText value="#{resultado[0]}"/>
                    </h:column>
                </h:dataTable>
            
        </body>
    </html>
</f:view>

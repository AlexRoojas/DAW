<%-- 
    Document   : index2
    Created on : 7 feb. 2022, 12:50:41
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
            <style>
                .r1{
                    background-color: #99ff99;
                }
                .r2{
                    background-color: #99ff33;
                }
            </style>
        </head>
        <body>
            <h:form>
                <p>
                    Introduce Nº Tabla: <h:inputText size="1" value="#{calculo.numTabla}"/>
                    <br>
                    <h:commandButton value="Mostrar" action="mostrar"/>
                </p>
            </h:form>
                
                <h:dataTable rendered="#{calculo.numTabla ne 0}" value="#{calculo.stabla}"  var="columna" border="10" bgcolor="#F1F1F1"
                         style="text-align: center" cellpadding="5" cellspacing="3" width="25%" frame="hsides" rowClasses="r1,r2">
                <f:facet name="header">
                    <h:outputText value="Tabla del #{calculo.numTabla}"/>
                </f:facet>
                <h:column>
                    <h:outputText value="#{columna[0]}"/>
                </h:column>
                <h:column>
                    <h:outputText value="#{columna[1]}"/>
                </h:column>
                <h:column>
                    <h:outputText value="#{columna[2]}"/>
                </h:column>
            </h:dataTable>
                
            
        </body>
    </html>
</f:view>

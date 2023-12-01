<%-- 
    Document   : cesta
    Created on : 21 feb. 2022, 19:18:30
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
        <style>
            .r1{
                background-color: #99ff99;
            }
            .r2{
                background-color: #99ff33;
            }
            .foto{
                width: 300px;
            }
            </style>
        <body>
            <h:dataTable value="#{beanFlores.cargaDetalle()}" var="det" border="10" bgcolor="#F1F1F1" style="text-align: center" cellpadding="5" cellspacing="3" width="50%" frame="hsides" rowClasses="r1,r2">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Nombre Común"/>
                    </f:facet>
                    <h:outputText value="#{det.nombreComun}"/>
                </h:column>
                        
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Imagen"/>
                    </f:facet>
                    <h:graphicImage url="flores/#{det.imagen}" styleClass="foto"/>
                </h:column>
                        
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Unidades"/>
                    </f:facet>
                    <h:outputText value="#{det.unidades}"/>
                </h:column>   
                        
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Total Precio"/>
                    </f:facet>
                    <h:outputText value="#{det.totalprecio}"/>
                </h:column> 
                        
                
            </h:dataTable>
        </body>
    </html>
</f:view>

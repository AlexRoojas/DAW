<%-- 
    Document   : index
    Created on : 22 feb. 2022, 18:11:31
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
            <title><h:outputText value="#{beanRespaldo.saludadcioasd()}"/></title>
            <style>
                h3,p{
                    text-align: center;
                }
                .foto{
                    width: 300px;
                }
                .flecha{
                    width: 80px;
                }
                .boton{
                    width: 80px;
                }
            </style>
        </head>
        <body>
            <h3><h:outputText value="Hola #{beanRespaldo.miUsu.nombreusuario}"/></h3>
            <h3><h:outputText value="Luz --- Agua"/></h3>
            
            <p><h:form>
                <h:selectOneMenu value="#{beanFlor.codLuzSel}" onchange="submit()" valueChangeListener="#{beanFlor.cambiaFlores}">
                <f:selectItems value="#{beanFlor.listaLuz()}"/>
            </h:selectOneMenu>
            </h:form>
            </p>
            
            <h3><h:outputText value="#{beanFlor.florDetalle}"/></h3>
            
            <h:form>
            <h:panelGrid columns="3">
                <h:panelGroup>
                    <h:commandButton image="img/izq.png" styleClass="flecha"  actionListener="#{beanFlor.retrocede()}"/>
                    <h:graphicImage url="flores/#{beanFlor.miImagen}" styleClass="foto" binding="#{beanFlor.laFoto}"/>
                    <h:commandButton image="img/der.png" styleClass="flecha" actionListener="#{beanFlor.avanza()}"/>   
                </h:panelGroup> 
                
                
            </h:panelGrid>
            
            
            <h:panelGrid columns="5">
                
                <h:panelGroup>
                    <h:commandButton image="img/zoom.png" styleClass="boton"  actionListener="#{beanFlor.menoszoom()}" rendered="#{beanFlor.mostrarMenosZoom eq true}"/>
                    <h:commandButton image="img/rest.png" styleClass="boton"  actionListener="#{beanFlor.rest()}"/>
                    <h:commandButton image="img/menos.png" styleClass="boton"  actionListener="#{beanFlor.maszoom()}" rendered="#{beanFlor.mostrarZoom eq true}"/>
                    <h:commandButton image="img/borrar.png" styleClass="boton"  actionListener="#{beanFlor.borrarImagen()}"/>
                    <h:commandButton image="img/info.png" styleClass="boton"  actionListener="#{beanFlor.info()}"/>
                    <h:commandButton image="img/carrito.png" styleClass="boton"  actionListener="#{beanFlor.alcarro()}"/>
                </h:panelGroup>
                
                <h:panelGroup>
                    <h:outputText value="#{beanFlor.infoFlor}"/>    
                </h:panelGroup>
                
            </h:panelGrid>
             </h:form>
            <br>
            <h:form>
                <h:commandButton value="Alta Flor" action="crear"/>
                <h:commandButton value="Ver Detalles" action="detalles"/>
            </h:form>
        </body>
    </html>
</f:view>


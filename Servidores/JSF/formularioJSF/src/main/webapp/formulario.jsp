<%-- 
    Document   : formulario
    Created on : 18 feb. 2022, 18:03:25
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
                <h:outputText value="Nif"/>
                
                <h:inputText value="#{formularioresplado.nif}">
                     <f:converter converterId="convertidorNif"/>    
                </h:inputText>
                
                
                <h:outputText value="Email"/>
                
                <h:inputText id="Email" value="#{formularioresplado.email}" required="true">
                   <f:validator validatorId="autentia.nifValidator"/>
                </h:inputText>
              

                <h:commandButton value="ir" action="vamos"/>
            </h:form>

        </body>
    </html>
    <h:messages/>
</f:view>

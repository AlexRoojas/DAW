<%-- 
    Document   : evaluar
    Created on : 25 feb. 2022, 10:33:12
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
        <style>
            .boton{
                    width: 80px;
                }
                .rojo{
                    color: red;
                }
        </style>
        <body>
            <h3><h:outputText value="Bienvenido #{beanRespaldo.profe.nombreProfesor} "/></h3>
            
            <h:panelGrid columns="10">
                <h:panelGroup>
                    <h:form>
                        <h:selectOneMenu value="#{beanEvalua.evaSel}" onchange="submit()" valueChangeListener="#{beanEvalua.ensena}">
                            <f:selectItems value="#{beanEvalua.listaEva}"/>
                        </h:selectOneMenu>
                    </h:form>
                </h:panelGroup>    
                <h:panelGroup>
                    <h:outputText value="Curso a Evaluar "/>
                    <br>
                    <h:form>
                        <h:selectOneMenu value="#{beanEvalua.cursoSel}" onchange="submit()" valueChangeListener="#{beanEvalua.cambiaAsig}">
                            <f:selectItems value="#{beanEvalua.listaCurso()}"/>
                        </h:selectOneMenu>
                    </h:form>
                    </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Asignatura a Evaluar "/>
                    <br>
                    <h:form>
                        <h:selectOneMenu value="#{beanEvalua.asigSel}" onchange="submit()" valueChangeListener="#{beanEvalua.cargaTabla}">
                            <f:selectItems value="#{beanEvalua.listaAs}"/>
                        </h:selectOneMenu>
                    </h:form>
                </h:panelGroup>
                    
                    
            
            </h:panelGrid>
            <h:panelGrid>
                <h:panelGroup>
                    <h:form>
                        <h:dataTable value="#{beanEvalua.listaNotas}"  var="columna" binding="#{beanEvalua.respaldoTabla}" border="10" style="text-align: center" >
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Alumno"/>
                                </f:facet>
                                <h:outputText value="#{columna.nomAlumno}"/>

                            </h:column>
                            
                            <h:column rendered="#{beanEvalua.prim eq false}">
                                <f:facet name="header">
                                    <h:outputText value="Notas 1 Eval"/>
                                </f:facet>
                                <h:selectOneMenu value="#{columna.nota1}" >
                                    <f:selectItems value="#{beanEvalua.nota}"/>
                                </h:selectOneMenu>
                                
                            </h:column>
                            
                            <h:column rendered="#{beanEvalua.sec eq true}">
                                <f:facet name="header">
                                    <h:outputText value="Notas 2 Eval"/>
                                </f:facet>
                                <h:selectOneMenu value="#{columna.nota2}" >
                                    <f:selectItems value="#{beanEvalua.nota}"/>
                                </h:selectOneMenu>
                            </h:column>
                            
                            <h:column rendered="#{beanEvalua.ter eq true}">
                                <f:facet name="header">
                                    <h:outputText value="Notas 3 Eval"/>
                                </f:facet>
                                <h:selectOneMenu value="#{columna.nota3}" >
                                    <f:selectItems value="#{beanEvalua.nota}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:dataTable>
                        
                        <h:commandButton  image="imagenesSeneca2daw/ok.png" styleClass="boton" actionListener="#{beanEvalua.cargaCompleta}"/>
                    </h:form>
                    
                    </h:panelGroup>
                    <h:panelGroup>
                    <h:form>
                        <h:dataTable value="#{beanEvalua.listaNotas2}"  var="columna"  border="10" style="text-align: center" rendered="#{beanEvalua.carga eq true}">
                            
                            
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value=" "/>
                                </f:facet>  
                                <h:commandButton  image="imagenesSeneca2daw/#{columna.imagen}" styleClass="boton" actionListener="#{beanEvalua.verPersona()}"/>
                            </h:column>
                            
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value=" Alumno"/>
                                </f:facet>
                                <h:outputText value="#{columna.nomAlumno}"/>
                            </h:column>
                            
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Primera"/>
                                </f:facet>
                                <h:panelGrid rendered="#{columna.nota1 gt 4}">
                                    <h:outputText value="#{columna.nota1}" />
                                </h:panelGrid>
                                <h:panelGrid rendered="#{columna.nota1 lt 5}">
                                    <h:outputText value="#{columna.nota1}" styleClass="rojo"/>
                                </h:panelGrid>
                                
                            </h:column>
                            
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Segunda"/>
                                </f:facet>
                                <h:panelGrid rendered="#{columna.nota2 gt 4}">
                                    <h:outputText value="#{columna.nota2}" />
                                </h:panelGrid>
                                <h:panelGrid rendered="#{columna.nota2 lt 5}">
                                    <h:outputText value="#{columna.nota2}" styleClass="rojo"/>
                                </h:panelGrid>
                            </h:column>
                            
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Tercera"/>
                                </f:facet>
                                <h:panelGrid rendered="#{columna.nota3 gt 4}">
                                    <h:outputText value="#{columna.nota3}" />
                                </h:panelGrid>
                                <h:panelGrid rendered="#{columna.nota3 lt 5}">
                                    <h:outputText value="#{columna.nota3}" styleClass="rojo"/>
                                </h:panelGrid>
                            </h:column>
                            
                        </h:dataTable>
                    </h:form>
                </h:panelGroup>
                        <h:outputText value="#{beanEvalua.info}"/>
            </h:panelGrid>
                    
                    <h:form>
                <h:commandButton value="Alta Alumno" action="crear"/>
            </h:form>
        </body>
    </html>
</f:view>

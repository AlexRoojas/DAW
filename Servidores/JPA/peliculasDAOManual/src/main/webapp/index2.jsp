<%-- 
    Document   : index2
    Created on : 16 dic. 2021, 19:37:03
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="misDirectores" scope="request" class="com.daw.peliculasdaomanual.DTO.Directores">
            <jsp:setProperty name="misDirectores" property="*"/>
        </jsp:useBean>
        
        <jsp:useBean id="direSel" scope="request" class="com.daw.peliculasdaomanual.DTO.Directores">
            <jsp:setProperty name="direSel" property="*"/>
        </jsp:useBean>
        
        <jsp:useBean id="datCon" scope="session" class="com.daw.peliculasdaomanual.BD.DatosConex">
            <jsp:setProperty name="datCon" property="completa" value="${initParam.conCompleta}" />
        </jsp:useBean>
        
        <c:if test="${not empty param.op}" > 
            <jsp:include page="gestionaBD"/>
        </c:if>
    
        
        <jsp:include page="cargaDir"/>
        
        <form action="index2.jsp">
            <h3>Busca a un director por DNI</h3>
            <input type="text" name="dni" value="Inserte el DNI">
            <input type="submit" name="op" value="buscar">
        </form>
        <table>
            <c:forEach var="colm" items="${direSel}">
                
            </c:forEach>
        </table>
        
        <table>
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Nacionaldad</th>
            </tr>
            
            <form action="index2.jsp">
                <tr>
                    <td><input type="text" name="dni"></td>
                    <td><input type="text" name="nombre"></td>
                    <td><input type="text" name="nacionalidad"></td>
               
                    <td><input type="submit" name="op" value="alta"></td>
                </tr>

            </form>
            <tbody>
            <c:forEach var="colm" items="${misDirectores}">
                <tr>
                    <form action="index.jsp">
                    <input type="hidden" name="dni" value="${colm.dni}">
                    <input type="hidden" name="nombre" value="${colm.nombre}">
                    <input type="hidden" name="nacionalidad" value="${colm.nacionalidad}">
                    <input type="hidden" name="proce" value="direc">
                    <td>${colm.dni}</td>
                    <td>${colm.nombre}</td>
                    <td><input type="text" name="genero" value="${colm.nacionalidad}"></td>
                    
                    <td><input type="submit" name="op" value="modif"></td>
                    <td><input type="submit" name="op" value="borrar"></td>
                    </form>
                </tr>
                
            </c:forEach>
                </tbody>
        </table>
    </body>
</html>

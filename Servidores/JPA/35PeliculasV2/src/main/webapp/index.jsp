<%-- 
    Document   : index
    Created on : 13 dic. 2021, 17:13:01
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
        <style>
            table{
                border: 1px solid black ;
                width:1000px;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="peli" scope="request" class="pojos.Peliculas">
            <jsp:setProperty name="peli" property="*"/>
        </jsp:useBean>
        
        <c:if test="${not empty param.op}" > 
            <jsp:include page="gestionaBD"/>
        </c:if>
    
        <jsp:include page="carga"/>
        
        <table>
            <tr>
                <c:forEach var="cabecera" items="${miPeli.getColumnNames()}">
                    <th>${cabecera}</th>
                </c:forEach>
            </tr>
            <form action="index.jsp">
                <tr>
                    <td><input type="text" name="codPeli"></td>
                    <td><input type="text" name="nombre"></td>
                    <td><input type="text" name="director"></td>
                    <td><input type="text" name="genero"></td>
                    <td><input type="checkBox" name="estreno" value="1"></td>
                    <td><input type="checkBox" name="publico" value="1"></td>
                    <td><input type="date" name="fecha"> </td>
                    <td><input type="text" name="imagen"></td>
               
                    <td><input type="submit" name="op" value="alta"></td>
                </tr>

            </form>
            
            <c:forEach var="colm" items="${miPeli.rows}">
                
                <tr>
                <form action="index.jsp">
                    <input type="hidden" name="codigo_pelicula" value="${colm.codigo_pelicula}">
                    <td>${colm.codigo_pelicula}</td>
                    <td>${colm.nombre}</td>
                    
                    <td>${colm.director}</td>
                    
                    <td><input type="text" name="genero" value="${colm.genero}"></td>
                        <td>
                            <c:choose>
                                <c:when test="${colm.estreno}">
                                    <input type="checkBox" name="estreno" value="1" checked>
                                </c:when>    
                                <c:otherwise>
                                    <input type="checkBox" name="estreno" value="0">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${colm.publico}">
                                    <input type="checkBox" name="publico" value="1" checked>
                                </c:when>    
                                <c:otherwise>
                                    <input type="checkBox" name="publico" value="0">
                                </c:otherwise>
                            </c:choose>
                            
                        </td>
                        <td>${colm.fecha_insercion}</td>
                        
                     
                        <td><img src="${colm.imagen}"></td>
                        
                        <td><input type="submit" name="op" value="modif"></td>
                        <td><input type="submit" name="op" value="borrar"></td>
                </form>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

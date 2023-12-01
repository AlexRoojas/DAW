<%-- 
    Document   : index
    Created on : 10 ene. 2022, 14:40:53
    Author     : Alex.R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <style>
           
            table{
                border: 2px solid black ;
                width:90%;
                margin: 0 auto;
                border-collapse: collapse;
            }
            tbody tr{
                border-bottom:  solid lightgray 1px;
            }
            img{
                width: 100px;
            }
        </style>
    </head>
    <body>
        
        <c:if test="${param.op ne null}">

            <jsp:useBean id="mipeli" scope="request" class="com.daw.mantenimientopeliculasjv.DTO.Peliculas">
                <jsp:setProperty name="mipeli" property="*"/>
            </jsp:useBean>

        </c:if>
        
        <jsp:include page="operaciones" />
        <h1>Listado Peliculas</h1>
        
        <table>
           
        </table>
        
        
        
        
        <table border="1">
            <c:forEach items="${requestScope.cabeceras}" var="cab" begin="0" varStatus="i">
                   <th>${cab[0]}</th>
            </c:forEach>
                   
                   
            <form action="index.jsp">
                <tr>
                    <td><input type="text" name="codPeli"></td>
                    <td><input type="text" name="nombre"></td>
                    <td><input type="text" name="director"></td>
                    <td><input type="text" name="genero"></td>
                    <td><input type="checkBox" name="estreno" value="1"></td>
                    <td><input type="checkBox" name="publico" value="1"></td>
                    <td><input type="date" name="fecha_insercion"> </td>
                    <td><input type="text" name="imagen"></td>
               
                    <td><input type="submit" name="op" value="Alta"></td>
                </tr>

            </form>
            
            
            
            <c:forEach items="${requestScope.listaPelis}" var="peli">
                <form action="index.jsp">
               <tr>
                <input type="hidden" name="codigoPelicula" value="${peli.codigoPelicula}">
                <input type="hidden" name="director" value="${peli.director}">
                <input type="hidden" name="fecha" value="${peli.fechaInsercion}">
                <input type="hidden" name="nombre" value="${peli.nombre}">
                    <td>${peli.codigoPelicula}</td>
                    <td>${peli.nombre}</td>
                    <td>${peli.director}</td>
                    <td><input type="text" name="genero" value="${peli.genero}"></td>
                    <td>
                        <c:choose>
                            <c:when test="${peli.estreno eq '1'}">
                                <input type="checkBox" name="estreno" checked>
                            </c:when>    
                            <c:otherwise>
                                <input type="checkBox" name="estreno" >
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:choose>
                            <c:when test="${peli.publico eq '1'}">
                                <input type="checkBox" name="publico" checked>
                            </c:when>    
                            <c:otherwise>
                                <input type="checkBox" name="publico" >
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><fmt:formatDate value="${peli.fechaInsercion}" pattern="dd-MM-yyyy"/><td>
                        <img src="img/${peli.imagen}">
                    <td><input type="submit" name="op" value="Borrar"></td>
                    <td><input type="submit" name="op" value="Modificar"></td>
                </tr>
                </form>
            </c:forEach>
            
        </table>
        
    </body>
</html>

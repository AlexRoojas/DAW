<%-- 
    Document   : index
    Created on : 15 dic. 2021, 17:16:39
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla Peliculas</title>
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
        </style>
    </head>
    <body>
        
        <jsp:useBean id="peli" scope="request" class="com.daw.peliculasdaomanual.DTO.Peliculas">
            <jsp:setProperty name="peli" property="*"/>
        </jsp:useBean>
        
        <jsp:useBean id="dire" scope="request" class="com.daw.peliculasdaomanual.DTO.Directores">
            <jsp:setProperty name="dire" property="*"/>
        </jsp:useBean>
        
        <jsp:useBean id="genee" scope="request" class="com.daw.peliculasdaomanual.DTO.Genero">
            <jsp:setProperty name="genee" property="*"/>
        </jsp:useBean>
        
        <jsp:useBean id="datCon" scope="session" class="com.daw.peliculasdaomanual.BD.DatosConex">
            <jsp:setProperty name="datCon" property="completa" value="${initParam.conCompleta}" />
        </jsp:useBean>
        
        <c:if test="${not empty param.op}" > 
            <jsp:include page="gestionaBD"/>
        </c:if>
    
        
        <jsp:include page="cargaBD"/>
        <jsp:include page="cargaDir"/>
        <jsp:include page="cargaGen"/>
        
        <table>
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Nacionaldad</th>
            </tr>
            
            <form action="index.jsp">
                <tr>
                    <td><input type="text" name="dni"></td>
                    <td><input type="text" name="nombre"></td>
                    <td><input type="text" name="nacionalidad"></td>
               
                    <td><input type="submit" name="op" value="alta"></td>
                </tr>

            </form>
            
                <tr>
                    <form action="index.jsp">
                    <input type="hidden" name="dni" value="${colu.dni}">
                    <input type="hidden" name="nombre" value="${colu.nombre}">
                    <input type="hidden" name="nacionalidad" value="${colu.nacionalidad}">
                    <input type="hidden" name="viene" value="direc">
                    <td>${colu.dni}</td>
                    <td>${colu.nombre}</td>
                    <td><input type="text" name="genero" value="${colu.nacionalidad}"></td>
                    
                    <td><input type="submit" name="op" value="modif"></td>
                    <td><input type="submit" name="op" value="borrar"></td>
                    </form>
                </tr>
                
            
        </table>
        
        
        
        <table>
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Director</th>
                <th>Genero</th>
                <th>Estreno</th>
                <th>Pubico</th>
                <th>Fecha</th>
                <th>Imagen</th>
            </tr>
            
            <form action="index.jsp">
                <tr>
                    <td><input type="text" name="codPeli"></td>
                    <td><input type="text" name="nombre"></td>
                    <td>
                        <select name="director">
                        <c:forEach var="dires" items="${misDirectores}">
                             <option value="${dires.nombre}">${dires.nombre}</option>
                        </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="genero">
                        <c:forEach var="genes" items="${listaGeneros}">
                             <option value="${genes.nomGen}">${genes.nomGen}</option>
                        </c:forEach>
                        </select>
                    </td>
                    <td><input type="checkBox" name="estreno" value="1"></td>
                    <td><input type="checkBox" name="publico" value="1"></td>
                    <td><input type="date" name="fecha_insercion"> </td>
                    <td><input type="text" name="imagen"></td>
               
                    <td><input type="submit" name="op" value="alta"></td>
                </tr>

            </form>
            <tbody>
            <c:forEach var="colm" items="${miPeli}">
                <tr>
                    <form action="index.jsp">
                    <input type="hidden" name="codigo_pelicula" value="${colm.codigo_pelicula}">
                    <input type="hidden" name="director" value="${colm.director}">
                    <input type="hidden" name="fecha_insercion" value="${colm.fecha_insercion}">
                    <input type="hidden" name="nombre" value="${colm.nombre}">
                    <td>${colm.codigo_pelicula}</td>
                    <td>${colm.nombre}</td>
                    <td>${colm.director}</td>
                    <td><input type="text" name="genero" value="${colm.genero}"></td>
                    <td>
                        <c:choose>
                            <c:when test="${colm.estreno eq 1}">
                                <input type="checkBox" name="estreno" checked>
                            </c:when>    
                            <c:otherwise>
                                <input type="checkBox" name="estreno" >
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:choose>
                            <c:when test="${colm.publico eq 1}">
                                <input type="checkBox" name="publico" checked>
                            </c:when>    
                            <c:otherwise>
                                <input type="checkBox" name="publico" >
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${colm.fecha_insercion}</td>
                    <td>${colm.imagen}</td>
                    
                    
                    <td><input type="submit" name="op" value="modif"></td>
                    <td><input type="submit" name="op" value="borrar"></td>
                    </form>
                </tr>
                
            </c:forEach>
                </tbody>
        </table>
        
        
    </body>
</html>

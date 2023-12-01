   

  
<%-- 
    Document   : index.jsp
    Created on : 19-ene-2016, 21:54:22
    Author     : lola
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"  import="java.util.*"%>
<%@page import="bean.*"%>


<%@page import="java.util.*"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel='stylesheet' href='css/miestilo.css' type='text/css'/>
    </head>
    <body> 
        
        <jsp:useBean id="peli" scope="request" class="bean.cPeliculas">
            <jsp:setProperty name="peli" property="*"/>
        </jsp:useBean>
        
        <% if (request.getParameter("operacion")!=null){%>            
                <jsp:include page="operaciones"/>
         <%}%>
         
        <jsp:include page="consulta"/>
        <table width="900px">
            <tr>
                <c:forEach var="cab" items="${consultaPelis.getColumnNames()}" varStatus="i">
                    <c:if test="${i.count!=1}">
                        <th>${cab}</th>
                        </c:if>

                </c:forEach>
                       
                        <th>Operacion</th>
                        <th>Operacion</th>                                              
               
                        
            </tr>
            <form action="index.jsp" method="post">
                <tr> <td><input type="text" name="nombre" value=""></td>
                    <td><input type="text" name="director"></td>
                    <td><input type="text" name="genero" > </td>
                    <td><input type="checkBox" name="estreno" value="1"></td>
                    <td><input type="checkBox" name="publico" value="1"></td>
                    <td><input type="Date" name="fecha"> </td>
                    <td><input type="text" name="imagen"></td>
               
                    <td> <input type="submit" name="operacion" value="alta"></td>

                </tr>

            </form>

            <c:forEach var="fila" items="${consultaPelis.rows}">

                <form action='index.jsp' method="post" >
                    <input type='hidden' name='codigo_pelicula' value="${fila.codigo_pelicula}">
                    <tr>
                        <td align='center'>"${fila.nombre}</td>
                        <input type='hidden' name='nombre' value="${fila.nombre}">
                        <td>${fila.director}</td>
                         <input type='hidden' name='director' value="${fila.director}">
                        <td><input type="text" name="genero" value="${fila.genero}"></td>
                            <c:set var="estado1" value=">"/>
                            <c:if test="${fila.estreno}"> 
                                <c:set var="estado1" value="checked='checked'>"/>
                            </c:if>
                        <td><input type="checkBox" name="estreno" value="1" ${estado1}</td>
                            <c:set var="estado2" value=">"/>
                            <c:if test="${fila.publico}"> 
                                <c:set var="estado2" value="checked='checked'>"/>
                            </c:if>
                        <td><input type="checkBox" name="publico" value="1" ${estado2}</td>
                        <td>${fila.fecha_insercion}</td>
                         <input type='hidden' name='fecha' value="${fila.fecha_insercion}">
                     
                        <c:set var="imag" value=".\\img\\${fila.imagen}"/>
                        <td><img width="50" height="50"  src=${imag}></td>
                        <input type="hidden" name="imagen" value="${fila.imagen}"/>
                     
                        <td><input type="submit" name="operacion" value="modif"></td>
                        <td><input type="submit" name="operacion" value="borrar"></td>
                    </tr>
                </form>

            </c:forEach> 

        </table>
      




    </body>
</html>


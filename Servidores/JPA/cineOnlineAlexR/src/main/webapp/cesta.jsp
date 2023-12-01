<%-- 
    Document   : cesta
    Created on : 17 ene. 2022, 18:23:37
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta</title>
    </head>
    <body>
        <jsp:include page="operaciones"/>
        <jsp:include page="cargaCesta"/>
        <h1>Esta es tu cesta ${sessionScope.usuario}</h1>
        <table border="1">
            <tr>
                <th>Denominacion</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
               
            </tr>
            <c:forEach var="vist" items="${requestScope.listaVista}">
                <form action="cesta.jsp">
                <input type="hidden" name="codArticulo" value="${vist.codArticulo}"/>
                <tr>
                    <td>${vist.denominacion}</td>
                    <td><p>${vist.precio}€</p></td>
                    <td>${vist.cantidad}</td>
                    <td>${vist.cantidad*vist.precio}€</td>
                    <td><input type="submit" name="op" value="mas"/></td>
                    <td><input type="submit" name="op" value="menos"/></td>
                </tr>
                </form>
            </c:forEach>
            
        </table>
        <form action="factura.jsp">
                <input type="submit" value="Comprar">
        </form>
        <form action="finalizar">
                <input type="submit" value="Salir">
        </form>
        <form action="index.jsp">
            <input type="submit" value="Volver">
        </form>
        <h1 style="text-align: center">Total de visitas ${applicationScope.contador}</h1>
    </body>
</html>

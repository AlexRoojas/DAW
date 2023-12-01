<%-- 
    Document   : factura
    Created on : 20 ene. 2022, 17:58:07
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
    </head>
    <body>
        <jsp:include page="generaFactura"/>
        <h1>Esta es tu factura ${sessionScope.usuario} a las ${requestScope.fact.fecha}</h1>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
               
            </tr>
            <c:forEach var="vist" items="${requestScope.listaVista}">
                <form action="factura.jsp">
                <tr>
                    <td>${vist.denominacion}</td>
                    <td><p>${vist.precio}€</p></td>
                    <td>${vist.cantidad}</td>
                    <td>${vist.cantidad*vist.precio}€</td>
                </tr>
                </form>
            </c:forEach>
            
        </table>
        <form action="finalizar">
            <h1>El total de su compra es de: ${requestScope.fact.importe}€</h1>
                <input type="submit" value="Salir">
        </form>
        <h1 style="text-align: center">Total de visitas ${applicationScope.contador}</h1>
    </body>
</html>

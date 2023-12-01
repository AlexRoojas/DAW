<%-- 
    Document   : index
    Created on : 15 ene. 2022, 17:02:35
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        
        <c:if test="${!empty param.cantidad}">
            
            <jsp:useBean id="miDetallePK" scope="request" class="com.daw.tiendaonlinebdjpa.DTO.DetallePK">
                <jsp:setProperty name="miDetallePK" property="usuario" value="${sessionScope.usuario}"/>
                <jsp:setProperty name="miDetallePK" property="codArticulo" value="${param.codArticulo}"/>
            </jsp:useBean>

            <jsp:useBean id="miDetalle" scope="request" class="com.daw.tiendaonlinebdjpa.DTO.Detalle">
                <jsp:setProperty name="miDetalle" property="detallePK" value="${miDetallePK}"/>
                <jsp:setProperty name="miDetalle" property="cantidad" value="${param.cantidad}"/>
            </jsp:useBean>
            
            <jsp:include page="operaciones"/>
        </c:if>
        
        
        <jsp:include page="cargaArt"/>
      
        <h1>Bienvenido ${sessionScope.usuario}</h1>
        <table border="1">
            <tr>
                <th>Articulo</th>
                <th>Existencias</th>
                 <th>Precio</th>
                <th>Unidades</th>
               
            </tr>
            <c:forEach var="art" items="${requestScope.listaArt}">
                <form action="index.jsp">
                <input type="hidden" name="codArticulo" value="${art.codArticulo}"/>
                <tr>
                    <td>
                        <img src="imagenes/${art.imagen}">
                        <br>
                        ${art.denominacion}
                    </td>
                    <td><p>Quedan: ${art.existencias}</p></td>
                    <td>${art.precio}€</td>
                    <td><input type="number" name="cantidad" value="0" min="0" max="${art.existencias}"/></td>
                    <td><input type="submit" value="Añadir"/></td>
                </tr>
                </form>
            </c:forEach>
            
            <form action="articulos.jsp">
                <input type="submit" value="Alta Articulo">
            </form>
            <form action="finalizar">
                <input type="submit" value="Cerrar Sesion">
            </form>
            <form action="cesta.jsp">
                <input type="submit" value="Ver Cesta">
            </form>
        </table>
        <h1 style="text-align: center">Total de visitas ${applicationScope.contador}</h1>
    </body>
</html>

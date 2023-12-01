<%-- 
    Document   : altaArt
    Created on : 18 ene. 2022, 18:16:31
    Author     : kete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="cargaCateProv"/>
        <h1>Alta Articulo</h1>
    
        <form action="altaArt" method="post" enctype="multipart/form-data">
            <label>Denominacion: </label>
            <input type="text" name="denominacion"><br>
            
            <label>Categoria</label>
            <select name="categoria">
               <c:forEach var="cate" items="${requestScope.listaCateg}"> 
                   <option value="${cate}">${cate}</option>    
               </c:forEach>
            </select>
            <br>
            <label>Precio : </label>
            <input type="number" name="precio"><br>
            
            <label>Existencias : </label>
            <input type="number" name="existencias"><br>
            
            <label>Proveedor</label>
            <select name="proveedor">
                <c:forEach var="prov" items="${requestScope.listaProv}"> 
                    <option name="codArticulo" value="${prov.codProveedor}">${prov.nombreProveedor}</option>    
               </c:forEach>
            </select>
            <br>
            <label>Imagen</label><input type="file" name="imagen"/>
            <br>
            <input type="submit" value="Crear">
        </form>
        <form action="index.jsp">
            <input type="submit" value="Volver">
        </form>
        <h1 style="text-align: center">Total de visitas ${applicationScope.contador}</h1> 
    </body>
</html>

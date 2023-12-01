<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel='stylesheet' href='estiloTabla.css'>
	</head>
	
	<jsp:useBean id="cursoCiclo" scope="application" class="pojos.Curso">
		<jsp:setProperty name="cursoCiclo" property="nombreCurso" value='<%=application.getInitParameter("nombreCurso")%>'/>
 	</jsp:useBean>
	
	<jsp:useBean id="alumno" scope="request" class="pojos.Alumno">
		<jsp:setProperty name="alumno" property="*" />
	</jsp:useBean>
	
	<div class="container">
			<h1>Alta de Alumnos</h1>
				<form action="gestionCurso.jsp">
					Nif: <input type="number" name="nif"><br>
					Nombre: <input type="text" name="nombre"><br>
					Primer Apellido: <input type="text" name="apellido1"><br>
					Segundo Apellido: <input type="text" name="apellido2"><br>
					Edad: <input type="number" name="edad"><br>
					Curso: <input type="text" name="curso"><br>
					Población: <input type="text" name="poblacion"><br>
					CP: <input type="text" name="cp"><br>
					N Hermanos: <input type="number" name="nHermanos"><br>
					<input type="submit" value="Dar de alta">
				</form>
		</div>
	
		<c:if test="${alumno.nif ne 0}">
			<jsp:setProperty name="cursoCiclo" property="addAlumno" value="${alumno}"/>
		</c:if>
	
	
	<body>
	Alumnmo dado de alta <jsp:getProperty name="alumno" property="nombre"/>	
	Curso <jsp:getProperty name="cursoCiclo" property="nombreCurso"/>	
	<div class="container">
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Edad</th>
					<th>Curso</th>
					<th>Número de Hermanos</th>
				</tr>
				<c:forEach var="alu" items="${cursoCiclo.listaAlumnos}">
				
				</c:forEach>
					<tr>
						<td><c:out value="${alu.value.nombre}"/></td>
						<td><c:out value="${alu.value.apellido1}"/> <c:out value="${alu.value.apellido2}"/></td>
						<td><c:out value="${alu.value.edad}"/></td>
						<td><c:out value="${alu.value.curso}"/></td>
						<td><c:out value="${alu.value.nHermanos}"/></td>
					</tr>
				
			</table>
		</div>
	</body>
</html>
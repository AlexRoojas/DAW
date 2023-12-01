<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pojos.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel='stylesheet' href='estiloTabla.css'>
	</head>
	
	<jsp:useBean id="cursoCiclo" scope="application" class="pojos.Curso">
		<jsp:setProperty name="cursoCiclo" property="nombreCurso" value='<%=application.getInitParameter("nomCurso")%>'/>
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
	<%--if(alumno.getNif()!=0)cursoCiclo.addAlumno(alumno);--%>
	
	<%if(alumno.getNif()!=0){%>
	 <jsp:setProperty name="cursoCiclo" property="AddAlumno" value='<%=alumno%> '/>
	 
	<%}%>
	<jsp:getProperty name="cursoCiclo" property="numAlum"/>	
	<body>
	Alumnmo dado de alta <jsp:getProperty name="alumno" property="nombre"/>	
	Curso <jsp:getProperty name="cursoCiclo" property="nomCurso"/>	
	<div class="container">
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Edad</th>
					<th>Curso</th>
					<th>Número de Hermanos</th>
				</tr>
				<%
				for(Integer cod : cursoCiclo.getListaAlumnos().keySet()){
					 alumno = cursoCiclo.getListaAlumnos().get(cod);
					
					 %>
					<tr>
						<td><%=alumno.getNombre()%></td>
						<td><%=alumno.getApellido1() + " " + alumno.getApellido2()%></td>
						<td><%=alumno.getEdad()%></td>
						<td><%=alumno.getCurso()%></td>
						<td><%=alumno.getnHermanos()%></td>
					</tr>
				<%}%>
			</table>
		</div>
	</body>
</html>
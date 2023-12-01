<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualización de la fecha y hora</title>
<link rel='stylesheet' type='text/css' href='estiloTabla.css'/>
</head>
<body>
	
		
	
		<jsp:useBean id="mapa" type="HashMap" class="java.util.HashMap" scope="application"/>
		<jsp:useBean id="alumno"  class="pojos.Alumno" scope="request">
			<jsp:setProperty name="alumno" property="*" />
		</jsp:useBean>
	
	<table>
		<caption>Resultado del préstamo</caption>
			<tr>
			<th>Recibo</th>
			<th>Interes Pagado</th>
			<th>Capital Amortizado</th>
			<th>Capital pendiente</th>
			</tr>
			<%
			HashMap<Integer,Alumno> mapaAlumno=(HashMap<Integer,Alumno>) mapa;
			for(int nif:mapaAlumno.keySet()){%>
			
			<tr>
				<td><%=mapaAlumno.get(nif).getNif()%></td><td><%=mapaAlumno.get(nif).getNombre()%></td><td><%=mapaAlumno.get(nif).getApellido1()%></td>
				<td><%=mapaAlumno.get(nif).getApellido2()%></td><td><%=mapaAlumno.get(nif).getEdad()%></td><td><%=mapaAlumno.get(nif).getCurso()%></td>
				<td><%=mapaAlumno.get(nif).getPoblacion()%></td><td><%=mapaAlumno.get(nif).getCodPostal()%></td><td><%=mapaAlumno.get(nif).getNumHermanos()%></td>
			</tr>
		<%}%>
	</table>
		
</body>
</html>
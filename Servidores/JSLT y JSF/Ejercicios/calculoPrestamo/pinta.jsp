<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualización de la fecha y hora</title>
<link rel='stylesheet' type='text/css' href='estiloTabla.css'/>
</head>
<body>
	
		
		<jsp:include page='/calcula'>
			<jsp:param name="illo" value="xd"/>
		</jsp:include>
	<%	
		int periocidad = Integer.parseInt(request.getParameter("periocidad"));
		int anios = Integer.parseInt(request.getParameter("anios"));
		
		double tabla[][]=new double[(anios*periocidad)][4];
		tabla=(double[][])request.getAttribute("tabla");
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#,###,##0.00");
		
		int sumaInteres=0;
		int sumaCapital=0;
		int contador=0;
	%>
	<table>
		<caption>Resultado del préstamo</caption>
		<%for(int k=1;k<=anios;k++){
		%>
			<tr>
			<th>Recibo</th>
			<th>Interes Pagado</th>
			<th>Capital Amortizado</th>
			<th>Capital pendiente</th>
			</tr>
			<%
			for(int l=0;l<periocidad;l++){
			%>
			<tr>
			<td><%=df.format(tabla[contador][0])%></td>
			<td><%=df.format(tabla[contador][1])%></td>
			<td><%=df.format(tabla[contador][2])%></td>
			<td><%=df.format(tabla[contador][3])%></td>
			</tr>
			<%
				sumaInteres+=tabla[l*k][1];
				sumaCapital+=tabla[l*k][2];
				contador++;
			}
			%>
			
			<tr><td colspan='4' class='pie'>Interes pagado total: <%df.format(sumaInteres);%>     Capital pagado total: <%df.format(sumaCapital);%> <br/>Anio: <%=k%> </td></tr>
			<%sumaInteres=0;
			sumaCapital=0;
			}%>
	</table>
		
</body>
</html>
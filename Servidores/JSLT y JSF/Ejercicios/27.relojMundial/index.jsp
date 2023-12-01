<%@page contentType="text/html" pageEncoding="UTF-8" import="pojos.*" import="javax.servlet.jsp.*" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!doctype html>
<html>
	<head>
		<link rel='stylesheet' href='styles.css'>
	</head>
	
	<body>
	
	<div>
	<c:set var="langSel" scope="page" value="${param.langSel}"/>
	<fmt:setLocale value="${langSel}"/>
	<c:choose>
			<c:when test="${langSel eq 'spain'}">
				<fmt:setLocale value="es_ES"/>
				<fmt:setTimeZone value="GMT+1"/>
			</c:when>
			<c:when test="${langSel eq 'japon'}">
				<fmt:setLocale value="jp_JP"/>
				<fmt:setTimeZone value="GMT+9"/>
			</c:when>
			<c:when test="${langSel eq 'andorra'}">
				<fmt:setLocale value="ad_AD"/>
				<fmt:setTimeZone value="GMT+1"/>
			</c:when>
			<c:when test="${langSel eq 'eeuu'}">
				<fmt:setLocale value="en_US"/>
				<fmt:setTimeZone value="GMT-8"/>
			</c:when>
			<c:otherwise>
				<fmt:setLocale value="kr_KR"/>
				<fmt:setTimeZone value="GMT+9"/>
			</c:otherwise>
		</c:choose>
	<fmt:setBundle basename="textos"/>
	<h1><fmt:message key="saludo" /></h1>
		<form action="index.jsp">
			<input type="submit" value="spain" id="spain" name="langSel" >
			<input type="submit" src="imagenes/and" id="andorra" value="andorra" name="langSel">
			<input type="submit" src="imagenes/cor" id="corea" value="corea" name="langSel">
			<input type="submit" src="imagenes/eeuu" id="eeuu" value="eeuu" name="langSel">
			<input type="submit" src="imagenes/jap" id="japon" value="japon" name="langSel">
		</form>
		<img src="<fmt:message key='imagen'/>"/>
		<c:set var="fecha" value="<%=new java.util.Date()%>"/>
		<jsp:useBean id="hora" class="java.util.GregorianCalendar"/>
		
		<h2><fmt:formatDate value="${fecha}" type="both" timeStyle="long" dateStyle="long"/></h2>
		<h2><fmt:formatNumber value="1256.5"  type="currency" minFractionDigits="2"/></h2>
	</div>
	</body>
</html>
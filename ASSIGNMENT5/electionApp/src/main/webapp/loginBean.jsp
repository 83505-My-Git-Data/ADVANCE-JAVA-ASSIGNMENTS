<%@page import="com.sunbeam.pojos.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*" />
	
	Hello, ${lb.email} <br/>
	
	${lb.authenticate()};
	
	<c:choose>
		<c:when test="${lb.user.role == 'voter'}">
			<c:redirect url="candlistBean.jsp"/>		
		</c:when>
		<c:when test="${lb.user.role == 'admin'}">
			<c:redirect url="resultBean.jsp"/>		
		</c:when>
		<c:otherwise>
			<h3>${initParam.appTitle}</h3>
			Hello, ${lb.email} <br/>
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>		
		</c:otherwise>
	</c:choose>
</body>
</html>
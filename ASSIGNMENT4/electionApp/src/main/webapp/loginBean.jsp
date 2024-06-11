<%@page import="com.sunbeam.pojos.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="pass" />
	<%
	lb.authenticate();
	%>
	<%
	if (lb.getUser() != null) {
	%>
	<jsp:forward page="candlistBean.jsp"></jsp:forward>
	<%
	} else {
	%>
	Login Failed.
	<%
	}
	%>
</body>
</html>
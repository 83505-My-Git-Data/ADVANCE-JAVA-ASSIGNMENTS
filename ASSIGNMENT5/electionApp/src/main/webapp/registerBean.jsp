<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<jsp:useBean id="lb" class="com.sunbeam.beans.RegisterBean" />
	<jsp:setProperty name="lb" property="id" param="id" />
	<jsp:setProperty name="lb" property="firstName" param="first_name" />
	<jsp:setProperty name="lb" property="lastName" param="last_name" />
	<jsp:setProperty name="lb" property="dob" param="dob" />
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="passwd" />
	<jsp:setProperty name="lb" property="status" param="status" />
	<jsp:setProperty name="lb" property="role" param="role" />
	<% lb.register(); %>
	<% if(lb.getUser() != null) { %>
		<jsp:forward page="index.jsp"></jsp:forward>
	<% } else { %>
		Registration Failed.
	<% } %>
</body>
</html>
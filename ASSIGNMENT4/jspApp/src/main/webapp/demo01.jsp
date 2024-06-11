<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>

<%! 
	int count =0;
	public void jspInit()
	{
		System.out.println("Demo01s JspInit Called");
	}
	public void jspDestroy()
	{
		System.out.println("Demo01s JspDestroy Called");
	}


%>

<%
Date now = new Date();
out.println("Server Time: " + now);
%>

<br/><br/>
	<% count++; %>
	
	<% if(count%2==0){ %>
	Even Count: <%= count %>
	<% }else { %>
		Odd Count: <%= count %>
		<%} %>
	
	
	
</body>
</html>
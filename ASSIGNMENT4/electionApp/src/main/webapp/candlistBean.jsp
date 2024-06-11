<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidates</title>
</head>
<body>
	<h1>Online Voting!!!</h1>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean" />
	<h2>Candidate List</h2>
	<% List<Candidate> li = clb.getCandidateList(); %>
	<% for(Candidate c: li)
		{
		out.println("<input type='radio' name='name' value="+ c.getId() + " />"+ c.getName() +" ( "+ c.getParty()+ ")<br/>");


		}%>
		<input type="submit"  value="Vote"/>
	


</body>
</html>
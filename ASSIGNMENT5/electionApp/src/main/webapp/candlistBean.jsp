<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	

<form method="post" action="voteBean.jsp">
		<c:forEach var="c" items="${clb.candidateList}">
			<input type="radio" name="name" value="${c.id}"/> ${c.name} - ${c.party} <br/>
		</c:forEach>
		<br/> <input type="submit" value="Vote"/>
	</form>


</body>
</html>
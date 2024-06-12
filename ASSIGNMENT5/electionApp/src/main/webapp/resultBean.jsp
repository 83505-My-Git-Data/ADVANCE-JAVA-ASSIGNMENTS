<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
 	<h2>${initParam.title}- Online Voting</h2>
 
	<h1>Candidate Results</h1>

	<jsp:useBean id="res" class="com.sunbeam.beans.CandidateListBean" />
	

	<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>

		</thead>

		<tbody>
			<c:forEach var="c" items="${res.getCandidateList()}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
					<a href = "editCandBean.jsp?id=${c.id}"> <img src="images/edit.png" width="24"  height="24"></a>
					<a href = "deletecandBean.jsp?id=${c.id}"> <img src="images/delete.png" width="24"  height="24"></a>
					</td>
				</tr>
			</c:forEach>
			<tr>

			</tr>
		</tbody>
	</table>
	
	<a href="index.jsp">Sign Out</a>


</body>
</html>
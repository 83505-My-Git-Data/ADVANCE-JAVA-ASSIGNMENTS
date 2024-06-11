<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidates</title>
</head>
<body>

	<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"></jsp:useBean>
	<jsp:setProperty name="fcb" property="id"  param="id"/><br/><br/>
	${fcb.findCandidate()}
	<form method="post" action="updateCandBean.jsp">
		<input type="hidden" name="id" value = "${fcb.candidate.id}"/> <br/><br/>
		Name:<input type="text" name="name" value = "${fcb.candidate.name}"/> <br/><br/>
		Party:<input type="text" name="party" value = "${fcb.candidate.party}" /> <br/><br/>
		Votes:<input type="text" name="votes" value = "${fcb.candidate.votes}" readonly="readonly"/> <br/><br/>
		
		<input type="submit" value="Update"/> <br/><br/>
		
	</form>
	
	
</body>
</html>
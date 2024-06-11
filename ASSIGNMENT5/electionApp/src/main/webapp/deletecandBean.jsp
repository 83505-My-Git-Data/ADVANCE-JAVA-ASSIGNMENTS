<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean"></jsp:useBean>
	<jsp:setProperty property="id" name="dcb" />

	${dcb.deleteCandidate() }

	<c:choose>
		<c:when test="${dcb.count==1 }">
			<c:redirect url="resultBean.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
		Candidate delete failed. <br />
			<br />
			<a href="result.jsp">Show Result</a>

		</c:otherwise>
	</c:choose>




</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>

    <jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean" scope="session" />
    <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session" />

    <jsp:setProperty property="userId" name="vb" value="${lb.user.id}" />
    <jsp:setProperty property="id" name="vb" param="name" />
    ${ vb.vote() }

    <c:choose>
        <c:when test="${ vb.cnt != 0 }">
            SuccessFully Voted! Thank You
            <br/><br/>
            <a href="logout.jsp">Logout</a> 
        </c:when>
        <c:otherwise>
            <h1>Already Voted</h1>
            <a href="logout.jsp">LogOut</a>
        </c:otherwise>
    </c:choose>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <jsp:useBean id="nt" class="com.sunbeam.beans.VoteBean"></jsp:useBean>
     <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
     <jsp:setProperty property="id" name="nt" param="candidate"/>
    Hello : <jsp:getProperty name="lb" property="email"/> <hr/>
  
   
     <jsp:setProperty property="userId" name="nt" value="${lb.user.id }"/>  
     ${nt.getStatusOfVoting() }
     
     <c:choose>
       <c:when test="${ nt.voteStatus==1 }">
		      ${ nt.vote() }
		     <c:choose>
		       <c:when test="${ nt.getCnt()!=0 }">
		          <h1>Successfully Voted</h1>
		          ${ nt.setStatusUser() }
		           <a href="index.jsp" >LogOut</a>   
		       </c:when>
		       <c:otherwise>
		          <h1>Voting failed</h1>
		       </c:otherwise>
		       
		     </c:choose>
       </c:when>
       
       <c:otherwise>
          <h1>Already Voted</h1>
          <a href="index.jsp" />LogOut
       </c:otherwise>
       
     </c:choose>
     
     
     
     
     
   
</body>
</html>
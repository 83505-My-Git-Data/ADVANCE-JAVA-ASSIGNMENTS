<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	
	<h3>${initParam.title} - Online Voting</h3>

	<form method="post" action="loginBean.jsp">
		Email: <input type="text" name="email" /> <br />
		<br /> Password: <input type="password" name="password" /> <br />
		<br /> <input type="submit" value="Sign In" /> <a href="newuser.jsp">Sign
			Up</a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<h3>${initParam.title} - Online Voting</h3>

    <form method="post" action="registerBean.jsp">
        
        id: <input type="number" name="id" /> <br /> <br /> 
        first_name: <input type="text" name="first_name" /> <br /> <br /> 
        last_name:  <input type="text" name="last_name" /> <br /> <br /> 
        Email: <input type="email" name="email" /> <br /> <br /> 
        Password: <input type="password" name="passwd" /> <br /> <br /> 
        Date Of Birth: <input type="date" name="dob" /> <br /> <br /> 
        Role: 
        <select name="role">
            <option value="voter">Voter</option>
            <option value="admin">Admin</option>
        </select> 
        <br /> <br />
        Status: <input type="text" name="status" /> <br /> <br /> 
        <input type="submit" value="Sign Up" /> 
        <br/><br/>
            
        <a href="index.jsp">Already Signed Up, Do Login!</a>
    </form>
</body>
</html>

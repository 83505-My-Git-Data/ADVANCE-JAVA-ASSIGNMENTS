<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

<h5>Product List</h5> <br/>

<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>All Products</caption>
		<c:forEach var="product" items="${requestScope.products}">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.availableQty}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
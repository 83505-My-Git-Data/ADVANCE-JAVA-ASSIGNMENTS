<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Page</title>
</head>
<%-- data  --%>
<jsp:setProperty property="*" name="product_bean"/>
<body>

<h5>${sessionScope.product_bean.addNewProduct() }</h5>

</body>
</html>
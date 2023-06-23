<%@page import="com.infosys.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>
	<h1>Product list</h1>
	<hr>
	<ul>
	<%
	List<Product> list = (List<Product>) request.getAttribute("products");
	for(Product p: list){
		out.println("<li>" + p.getProductName() + " --> $" + p.getUnitPrice() + "</li>");
	}
	%>
	</ul>
</body>
</html>
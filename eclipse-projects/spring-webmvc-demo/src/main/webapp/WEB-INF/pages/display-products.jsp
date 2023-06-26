<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>
	<h1>Product list</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>Product name</th>
				<th>Quantity per unit</th>
				<th>Unit price</th>
				<th>Units in stock</th>
				<th>Discontinued?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="p">
				<tr>
					<td>${p.productName}</td>
					<td>${p.quantityPerUnit}</td>
					<td>${p.unitPrice}</td>
					<td>${p.unitsInStock}</td>
					<td>${p.discontinued==1? "Yes": "No"}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
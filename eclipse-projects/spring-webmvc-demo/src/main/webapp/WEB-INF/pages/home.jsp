<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Northwind Product Dashboard</title>
</head>
<body>
	<h1>Northwind Product Dashboard</h1>
	<hr />
	<a href="./product-list">Product list</a>
	
	<h3>List products by price range: </h3>
	<form action="./products-by-price-range">
		<div>
			<label for="min_price">Minimum price: </label>
			<input type="text" name="min_price" id="min_price" />
		</div>
		<div>
			<label for="max_price">Maximum price: </label>
			<input type="text" name="max_price" id="max_price" />
		</div>
		<button>Submit</button>
	</form>
	
	<div>
	<a href="./add-product">Add a new product</a>
	</div>
</body>
</html>
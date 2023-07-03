<%@ include file="./header.txt"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<h3>List products by price range:</h3>
<form action="./products-by-price-range">
	<div>
		<label for="min_price">Minimum price: </label> <input type="text"
			name="min_price" id="min_price" />
	</div>
	<div>
		<label for="max_price">Maximum price: </label> <input type="text"
			name="max_price" id="max_price" />
	</div>
	<button class="btn btn-primary">Submit</button>
</form>

<c:if test="${fn:length(products)==0}">
	<h3 class="text-warning">No products found between $${param.min_price} and $${param.max_price}!</h3>
</c:if>

<c:if test="${fn:length(products)!=0}">

	<h5>${title}</h5>

	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Product name</th>
				<th>Quantity per unit</th>
				<th>Unit price</th>
				<th>Units in stock</th>
				<th>Discontinued?</th>
				<th>Action</th>
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
					<td class="text-center"><a
						href="./edit-product?productId=${p.productId}"><i
							class="bi bi-pencil"></i></a> <a
						href="./delete-product?productId=${p.productId}"><i
							class="bi bi-trash"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<%@ include file="./footer.txt"%>









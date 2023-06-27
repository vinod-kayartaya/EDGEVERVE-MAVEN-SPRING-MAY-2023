<%@ include file="header.txt"%>

<h3>Confirmation needed!</h3>

<p>The following product details will be permanently deleted</p>

<table class="table">
	<tr>
		<td>Name</td>
		<td>: ${p.productName}</td>
	</tr>
	<tr>
		<td>Quantity per unit</td>
		<td>: ${p.quantityPerUnit}</td>
	</tr>
	<tr>
		<td>Unit price</td>
		<td>: $${p.unitPrice}</td>
	</tr>
	<tr>
		<td>Units in stock</td>
		<td>: ${p.unitsInStock}</td>
	</tr>
	<tr>
		<td>Units on order</td>
		<td>: ${p.unitsOnOrder}</td>
	</tr>
	<tr>
		<td>Reorder level</td>
		<td>: ${p.reorderLevel}</td>
	</tr>
	<tr>
		<td>Discontinued?</td>
		<td>: ${p.discontinued==1? "Yes": "No"}</td>
	</tr>
</table>

<form method="POST">
	<input type="hidden" name="productId" value="${p.productId}" />
	<button class="btn btn-outline-danger">Confirm delete</button>
	<a class="btn btn-link" href="./product-list">Cancel</a>
</form>


<%@ include file="footer.txt"%>













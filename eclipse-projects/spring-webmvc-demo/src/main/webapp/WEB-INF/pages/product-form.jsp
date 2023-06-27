<%@ include file="./header.txt" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<h2>Product form</h2>
	
	<hr />

	<sf:form modelAttribute="p">

		<div>
			<label for="productId">Product id: </label>
			<sf:input path="productId" />
		</div>



		<div>
			<label for="productName">Product name: </label>
			<sf:input path="productName" />
		</div>


		<div>
			<label for="quantityPerUnit">Quantity per unit: </label>
			<sf:input path="quantityPerUnit" />
		</div>


		<div>
			<label for="unitPrice">Unit price</label>
			<sf:input path="unitPrice" />
		</div>


		<div>
			<label for="unitsInStock">Units in stock: </label>
			<sf:input path="unitsInStock" />
		</div>


		<div>
			<label for="unitsOnOrder">Units on order: </label>
			<sf:input path="unitsOnOrder" />
		</div>


		<div>
			<label for="reorderLevel">Reorder level: </label>
			<sf:input path="reorderLevel" />
		</div>


		<div>
			<label for="discontinued">Discontinued: </label>
			<sf:input path="discontinued" />
		</div>


		<div>
			<label for="categoryId">Category id: </label>
			<sf:input path="categoryId" />
		</div>


		<div>
			<label for="supplierId">Supplier id: </label>
			<sf:input path="supplierId" />
		</div>


		<sf:button>Submit</sf:button>

	</sf:form>

<%@ include file="./footer.txt" %>

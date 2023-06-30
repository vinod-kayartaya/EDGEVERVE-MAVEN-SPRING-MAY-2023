<%@ include file="./header.txt"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<h2>Product details</h2>


<sf:form modelAttribute="p" action="./save-product">


	<sf:hidden path="productId" />



	<div class="mb-3 row">
		<label for="productName" class="col-2 col-form-label">Product
			name: </label>
		<div class="col-4">
			<sf:input path="productName" cssClass="form-control" />
			<sf:errors path="productName" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="quantityPerUnit" class="col-2 col-form-label">Quantity
			per unit: </label>
		<div class="col-4">
			<sf:input path="quantityPerUnit" cssClass="form-control" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="unitPrice" class="col-2 col-form-label">Unit price</label>
		<div class="col-4">
			<sf:input path="unitPrice" cssClass="form-control" />
			<sf:errors path="unitPrice" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="unitsInStock" class="col-2 col-form-label">Units
			in stock: </label>
		<div class="col-4">
			<sf:input path="unitsInStock" cssClass="form-control" />
			<sf:errors path="unitsInStock" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="unitsOnOrder" class="col-2 col-form-label">Units
			on order: </label>
		<div class="col-4">
			<sf:input path="unitsOnOrder" cssClass="form-control" />
			<sf:errors path="unitsOnOrder" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="reorderLevel" class="col-2 col-form-label">Reorder
			level: </label>
		<div class="col-4">
			<sf:input path="reorderLevel" cssClass="form-control" />
			<sf:errors path="reorderLevel" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="discontinued" class="col-2 col-form-label">Discontinued?
		</label>

		<div class="col-4">
			<sf:radiobutton id="discontinued_yes" path="discontinued" value="1"
				cssClass="form-check-input" />
			<label for="discontinued_yes" class="form-check-label">Yes</label>

			<sf:radiobutton id="discontinued_no" path="discontinued" value="0"
				cssClass="form-check-input" />
			<label for="discontinued_no" class="form-check-label">No</label>

			<sf:errors path="discontinued" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="categoryId" class="col-2 col-form-label">Category:
		</label>
		<div class="col-4">
			<sf:select path="categoryId" cssClass="form-select">
				<sf:option value="-1"> -- SELECT -- </sf:option>
				<sf:options items="${categories}" itemLabel="categoryName"
					itemValue="categoryId" />
			</sf:select>
			<sf:errors path="categoryId" cssClass="text-danger" />
		</div>
	</div>


	<div class="mb-3 row">
		<label for="supplierId" class="col-2 col-form-label">Supplier:
		</label>
		<div class="col-4">
			<sf:select path="supplierId" cssClass="form-select">
				<sf:option value="-1"> -- SELECT -- </sf:option>
				<sf:options items="${suppliers}" itemLabel="companyName"
					itemValue="supplierId" />
			</sf:select>
			<sf:errors path="supplierId" cssClass="text-danger" />
		</div>
	</div>


	<sf:button class="btn btn-primary">Save</sf:button>

</sf:form>

<%@ include file="./footer.txt"%>

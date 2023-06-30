package com.infosys.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.infosys.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "productName.empty",
				"Product name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice", "unitPrice.empty", "Unit price is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discontinued", "discontinued.not.selected", "Mandatory");

		Product p = (Product) target;

		String productName = p.getProductName();
		Double unitPrice = p.getUnitPrice();
		Integer unitsInStock = p.getUnitsInStock();
		Integer unitsOnOrder = p.getUnitsOnOrder();
		Integer reorderLevel = p.getReorderLevel();
		Integer categoryId = p.getCategoryId();
		Integer supplierId = p.getSupplierId();

		if (productName != null && !productName.isBlank() && (productName.length() < 3 || productName.length() > 30)) {
			errors.rejectValue("productName", "productName.length.invalid");
		}

		if (unitPrice != null && unitPrice < 0) {
			errors.rejectValue("unitPrice", "input.negative");
		}
		if (unitsInStock != null && unitsInStock < 0) {
			errors.rejectValue("unitsInStock", "input.negative");
		}
		if (unitsOnOrder != null && unitsOnOrder < 0) {
			errors.rejectValue("unitsOnOrder", "input.negative");
		}
		if (reorderLevel != null && reorderLevel < 0) {
			errors.rejectValue("reorderLevel", "input.negative");
		}

		if (categoryId == -1) {
			errors.rejectValue("categoryId", "", "Please select a category");
		}
		if (supplierId == -1) {
			errors.rejectValue("supplierId", "", "Please select a supplier");
		}
	}

}

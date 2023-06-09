package com.infosys.entity;

import lombok.Data;

@Data
public class Product {
	private Integer productId;
	private String productName;
	private Integer supplierId;
	private Integer categoryId;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Integer discontinued;
	
	public void setProductName(String productName) {
		System.out.println("setProductName called with " + productName);
		this.productName = productName;
	}
}

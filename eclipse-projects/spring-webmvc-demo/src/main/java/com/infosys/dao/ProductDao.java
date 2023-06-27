package com.infosys.dao;

import java.util.List;

import com.infosys.entity.Product;

public interface ProductDao {

	public List<Product> getAll();

	public List<Product> getByPriceRange(Double min, Double max);

	public void addNewProduct(Product product);

	public Product getProduct(Integer id);
	
	public void updateProduct(Product product);

	public void deleteProduct(Integer productId);

}

package com.infosys.dao;

import java.util.List;

import com.infosys.entity.Product;

public interface ProductDao {

	// CRUD operations
	public void addProduct(Product product) throws DaoException;

	public Product getProductById(int productId) throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	// Query operations

	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsInPriceRange(double min, double max) throws DaoException;

	public List<Product> getOutOfStockProducts() throws DaoException;

	public List<Product> getDiscontinuedProducts() throws DaoException;
}

package com.infosys.dao;

public interface ProductDao {
	// typically a DAO interface consists of 
	
	// 1. CRUD operations
	
	// 2. QUERY operations
	public int count() throws DaoException;
}

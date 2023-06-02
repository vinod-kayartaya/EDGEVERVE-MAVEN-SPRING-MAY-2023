package com.infosys.dao;

import com.infosys.entity.Customer;

public interface CustomerDao {

	// CRUD operations
	public default void add(Customer customer) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default Customer getById(String customerId) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default void update(Customer customer) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	// QUERY operations

	public default String getCustomerName(String customerId) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

}

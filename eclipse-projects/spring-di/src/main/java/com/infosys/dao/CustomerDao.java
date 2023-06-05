package com.infosys.dao;

import java.util.List;

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
	
	public default List<Customer> getAllCustomers() throws DaoException {
		throw new DaoException("Method not implemented yet");
	}

	public default List<Customer> getCustomersFromCity(String city) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}
	
	public default List<Customer> getCustomersFromCountry(String country) throws DaoException {
		throw new DaoException("Method not implemented yet");
	}
}












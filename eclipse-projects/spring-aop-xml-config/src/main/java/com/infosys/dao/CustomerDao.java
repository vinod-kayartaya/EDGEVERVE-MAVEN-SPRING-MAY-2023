package com.infosys.dao;

import java.util.List;

import com.infosys.entity.Customer;

public interface CustomerDao {

	// CRUD operations
	public void addCustomer(Customer customer) throws DaoException;

	public Customer findById(String customerId) throws DaoException;

	public void updateCustomer(Customer customer) throws DaoException;

	public void deleteCustomer(String customerId) throws DaoException;

	// QUERY operations

	public Customer findByEmail(String email) throws DaoException;

	public List<Customer> findByCity(String city) throws DaoException;

	public List<Customer> findByCountry(String country) throws DaoException;

	public List<Customer> findByRegion(String region) throws DaoException;

	public List<Customer> findByJobTitle(String jobTitle) throws DaoException;

	public List<Customer> findAll() throws DaoException;
}

package com.infosys.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.infosys.entity.Customer;

public class JdbcTemplateCustomerDao implements CustomerDao {

	// This class uses JdbcTemplate to work with RDBMS.
	// This means, an object/bean of this class has a dependency on JdbcTemplate.
	// We can have a variable of JdbcType class and allow spring to pass the
	// dependency
	// via constructor or setter.

	private JdbcTemplate jdbcTemplate;

	// default constructor - always a good practice
	public JdbcTemplateCustomerDao() {
	}

	// overloaded constructor; this can be used wile doing autowire by "constructor"
	public JdbcTemplateCustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// setter - a writable property (aka mutator) "jdbcTemplate"
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addCustomer(Customer customer) throws DaoException {

	}

	@Override
	public Customer findById(String customerId) throws DaoException {
		String sql = "select*from customers where lower(customer_id) = lower(?)";
		return jdbcTemplate.queryForObject(sql, crm, customerId);
	}

	@Override
	public void updateCustomer(Customer customer) throws DaoException {

	}

	@Override
	public void deleteCustomer(String customerId) throws DaoException {

	}

	@Override
	public Customer findByEmail(String email) throws DaoException {
		String sql = "select*from customers where lower(email) = lower(?)";
		return jdbcTemplate.queryForObject(sql, crm, email);
	}

	@Override
	public List<Customer> findByCity(String city) throws DaoException {
		String sql = "select*from customers where lower(city) = lower(?)";
		return jdbcTemplate.query(sql, crm, city);
	}

	@Override
	public List<Customer> findByCountry(String country) throws DaoException {
		String sql = "select*from customers where lower(country) = ?";
		return jdbcTemplate.query(sql, crm, country);
	}

	@Override
	public List<Customer> findByRegion(String region) throws DaoException {
		String sql = "select*from customers where lower(region) = lower(?)";
		return jdbcTemplate.query(sql, crm, region);
	}

	@Override
	public List<Customer> findByJobTitle(String jobTitle) throws DaoException {
		String sql = "select*from customers where lower(contact_title) = lower(?)";
		return jdbcTemplate.query(sql, crm, jobTitle);
	}

	@Override
	public List<Customer> findAll() throws DaoException {
		String sql = "select*from customers";
		return jdbcTemplate.query(sql, crm);
	}

	private static RowMapper<Customer> crm = (rs, n) -> {
		Customer c = new Customer();
		// need to copy data from "rs" into "c"
		c.setCustomerId(rs.getString("customer_id"));
		c.setCompanyName(rs.getString("company_name"));
		c.setContactName(rs.getString("contact_name"));
		c.setContactTitle(rs.getString("contact_title"));
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getString("city"));
		c.setRegion(rs.getString("region"));
		c.setCountry(rs.getString("country"));
		c.setPostalCode(rs.getString("postal_code"));
		c.setPhone(rs.getString("phone"));
		c.setFax(rs.getString("fax"));
		return c;
	};

}

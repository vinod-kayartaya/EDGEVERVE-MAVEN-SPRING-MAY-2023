package com.infosys.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.infosys.entity.Customer;

public class JdbcTemplateCustomerDao implements CustomerDao {

	// express JdbcTemplate as a dependency
	private JdbcTemplate template;

	public JdbcTemplateCustomerDao() {
	}

	public JdbcTemplateCustomerDao(JdbcTemplate template) {
		super();
		this.template = template;
	}

	// this setter exposes a writable property called "jdbcTemplate"
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	private RowMapper<Customer> crm = (rs, i)->{
		Customer c = new Customer();
		c.setCustomerId(rs.getString("customer_id"));
		c.setCompanyName(rs.getString("company_name"));
		c.setContactName(rs.getString("contact_name"));
		c.setContactTitle(rs.getString("contact_title"));
		c.setAddress(rs.getString("address"));
		c.setCity(rs.getNString("city"));
		c.setRegion(rs.getString("region"));
		c.setPostalCode(rs.getString("postal_code"));
		c.setCountry(rs.getString("country"));
		c.setPhone(rs.getString("phone"));
		c.setFax(rs.getString("fax"));
		return c;
	};

	@Override
	public void add(Customer customer) throws DaoException {
		CustomerDao.super.add(customer);
	}


	@Override
	public void update(Customer customer) throws DaoException {
		CustomerDao.super.update(customer);
	}
	
	@Override
	public Customer getById(String customerId) throws DaoException {
		// This method should catch any exception and re-throw the same as DaoException
		// We will use AOP to do the same
		return template.queryForObject("select * from customers where lower(customer_id)=lower(?)", crm, customerId);
	}

	@Override
	public List<Customer> getAllCustomers() throws DaoException {
		return template.query("select * from customers", crm);
	}

	@Override
	public List<Customer> getCustomersFromCity(String city) throws DaoException {
		return template.query("select * from customers where lower(city)=lower(?)", crm, city);
	}

	@Override
	public List<Customer> getCustomersFromCountry(String country) throws DaoException {
		return template.query("select * from customers where lower(country)=lower(?)", crm, country);
	}
	
	@Override
	public String getCustomerName(String customerId) throws DaoException {
		return template.queryForObject(
				"select company_name from customers where lower(customer_id)=lower(?)", 
				String.class, 
				customerId);
	}


}

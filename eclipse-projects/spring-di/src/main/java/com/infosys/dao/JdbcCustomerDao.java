package com.infosys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Customer;

@Repository
public class JdbcCustomerDao implements CustomerDao{
	
	// dependency, and is injected via auto-wiring
	@Autowired
	private DataSource dataSource;
	// spring tries to find a bean with the name "dataSource"
	// 1. if found, then that bean is assigned to this variable
	// 2. if not, spring tries to find a bean with the data type DataSource
	// 3. if ONE object is found, then it is assigned
	// 4. if NO bean is found of type DataSource, then exception is thrown
	// 5. if MULTIPLE beans found, then exception is thrown
	
	public JdbcCustomerDao() {
		System.out.println("JdbcCustomerDao constructor called");
		System.out.println("inside the JdbcCustomerDao constructor, dataSource is " + dataSource);
	}
	
	
	// setter is also known as "writable property" or "mutator"
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String getCustomerName(String customerId) {
		System.out.println("inside the JdbcCustomerDao.getCustomerName(), dataSource is " + dataSource);

		String sql = "select company_name from customers where customer_id=?";
		
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql); // 1st round trip
		){
			stmt.setString(1, customerId);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					return rs.getString(1);
				}
				return null;
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public void add(Customer customer) throws DaoException {
		
		String sql = "insert into customers values (?,?,?,?,?,?,?,?,?,?,?)"; 	// *
		try(
				Connection conn = dataSource.getConnection();					// #
				PreparedStatement stmt = conn.prepareStatement(sql);			// #
		){
			conn.setAutoCommit(false);											// #
			stmt.setString(1, customer.getCustomerId());						// #*
			stmt.setString(2, customer.getCompanyName());						// #*
			stmt.setString(3, customer.getContactName());						// #*
			stmt.setString(4, customer.getContactTitle());						// #*
			stmt.setString(5, customer.getAddress());							// #*
			stmt.setString(6, customer.getCity());		 						// #*
			stmt.setString(7, customer.getRegion());							// #*
			stmt.setString(8, customer.getPostalCode());						// #*
			stmt.setString(9, customer.getCountry());							// #*	
			stmt.setString(10, customer.getPhone());							// #*
			stmt.setString(11, customer.getFax());								// #*
			
			try {
				stmt.execute();													// #
				conn.commit();													// #
			}
			catch(Exception e) {
				conn.rollback();												// #
				throw new DaoException(e);										// #
			}
		} // conn.close() and stmt.close() are called automatically
		catch(SQLException e) {
			e.printStackTrace();
			throw new DaoException(e);
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

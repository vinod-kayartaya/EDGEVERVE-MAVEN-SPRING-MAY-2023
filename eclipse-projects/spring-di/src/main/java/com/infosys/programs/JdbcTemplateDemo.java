package com.infosys.programs;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.infosys.entity.Customer;

public class JdbcTemplateDemo {

	static JdbcTemplate template;

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context2.xml");
		template = ctx.getBean(JdbcTemplate.class);

		demo4();

		ctx.close();

	}
	
	static void demo4() {
		// get a Customer object for a given id
		String customerId = "Anton";
		String sql = "select * from customers where lower(customer_id)=lower(?)";
		
		// this arrow function returns a Customer object for the current row of "rs"
		RowMapper<Customer> crm = (rs, i)->{
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
		
		Customer c = template.queryForObject(sql, crm, customerId);
		System.out.println(c);
	}

	static void demo3() {
		double minPrice = 10;
		double maxPrice = 20;
		String sql = "select product_name from products where unit_price between ? and ? order by unit_price";
		List<String> list = template.queryForList(sql, String.class, minPrice, maxPrice);
		for (String pname : list) {
			System.out.println(pname);
		}
	}

	static void demo2() {
		// get the name of the shipping company for a given id
		int id = 2;
		String sql = "select company_name from shippers where shipper_id=?";
		try {
			String companyName = template.queryForObject(sql, String.class, id);
			System.out.printf("Name of the company for id %d is '%s'%n", id, companyName);
		} catch (DataAccessException e) {
			System.err.printf("No data found for shipper id %d%n", id);
		}
	}

	static void demo1() {

		int id = 4;
		String name = "KVinod Transports";
		String phone = "(943) 142-4784";

		PreparedStatementCallback<Integer> psc = (ps) -> {
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, phone);
			return ps.executeUpdate();
		};

		// add a new record to the SHIPPERS table
		String sql = "insert into shippers values (?, ?, ?)";
		try {
			Integer count = template.execute(sql, psc);

			// template.execute does the following
			// 1. using the dataSource injected, get a db connection
			// 2. using the sql supplied as the 1st arg, and the db connection, create a
			// PreparedStatement
			// 3. invokes the psc (callback function), which sets the PreparedStatement
			// parameters, and executes
			// 4. returns the return value of psc
			// 5. handle any exceptions and throws a uniform DataAccessException
			// 6. closes all the resources such as PreparedStatement and Connection

			System.out.println(count + " records inserted");
		} catch (DataAccessException e) {
			System.err.println("Could not insert record");
		}

	}
}

package com.infosys.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.infosys.dao.JdbcCustomerDao;

public class AppConfig1 {

	public AppConfig1() {
		System.out.println("AppConfig1 constructor called");
	}

	// an object of this type represents a Database Connection Pool.
	// Whenever you want, you ask for a db connection, use it and close it.
	// When the connection is closed, a new connection will be created and
	// added to the connection pool
	@Bean
	public BasicDataSource ds() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl("jdbc:h2:tcp://localhost/~/northwind");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		bds.setDriverClassName("org.h2.Driver");

		bds.setInitialSize(5);
		bds.setMaxTotal(50);
		bds.setMaxWaitMillis(100);

		System.out.println("returning an object of BasicDataSource to the spring container");
		return bds;
	}

	// Since spring invokes this function, any parameter of this function should be
	// passed by spring itself.
	// this is one of the example of dependency injection. For example, in this
	// function below, there is a dependency
	// of javax.sql.DataSource, and in the spring container, we have an object of
	// DataSource (the @Bean declared above)

	@Bean(name = "dao")
	@Scope("prototype")
	public JdbcCustomerDao jdbcCustomerDao(DataSource dataSource) { // dependency injection
		System.out.println(
				"inside the jdbcCustomerDao(..) function, dataSource is an object of " + dataSource.getClass());
		JdbcCustomerDao dao = new JdbcCustomerDao();

		dao.setDataSource(dataSource); // I am wiring an object of DataSource to "dao". Manual wiring

		// an object of JdbcCustomerDao is an instance of:
		// 1. JdbcCustomerDao
		// 2. java.lang.Object
		// 3. CustomerDao
		System.out.println("returning a new JdbcCustomerDao object to the spring container");
		return dao;
	}

}

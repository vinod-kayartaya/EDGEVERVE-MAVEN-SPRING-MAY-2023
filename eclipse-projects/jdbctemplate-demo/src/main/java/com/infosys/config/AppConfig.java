package com.infosys.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "com.infosys.dao", "com.infosys.aspects" })
@EnableAspectJAutoProxy
public class AppConfig {
	@Bean
	public BasicDataSource h2ds() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl("jdbc:h2:tcp://localhost/~/northwind");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		bds.setDriverClassName("org.h2.Driver");

		bds.setInitialSize(5);
		bds.setMaxTotal(50);
		bds.setMaxWaitMillis(100);

		return bds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) { // DI
		return new JdbcTemplate(ds); // Manual wiring
	}
	
}

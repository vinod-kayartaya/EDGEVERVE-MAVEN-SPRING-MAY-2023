package com.infosys.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.infosys.dao"}) // searches for Components in the specified packages and sub-packages
public class AppConfig2 {
	
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

		System.out.println("returning an object of BasicDataSource to the spring container");
		return bds;
	}

}

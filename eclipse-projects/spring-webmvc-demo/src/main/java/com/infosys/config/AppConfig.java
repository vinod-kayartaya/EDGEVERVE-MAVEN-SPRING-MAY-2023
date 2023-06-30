package com.infosys.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource({ "classpath:jdbc-info.properties" })
@ComponentScan(basePackages = { 
		"com.infosys.controllers", "com.infosys.dao" })
public class AppConfig {
	
	// bean for error messages source file
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:error-messages");
		source.setDefaultEncoding("utf-8");
		return source;
	}
	
	// configure the ViewResolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		// this will resolve a view name "display-products" as 
		// prefix + viewName + suffix
		// "/WEB-INF/pages/" + viewName + ".jsp"
		// "/WEB-INF/pages/display-products.jsp"
		return resolver;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) { // DI
		return new JdbcTemplate(ds); // Manual wiring
	}
	
	@Bean
	public BasicDataSource dataSource(@Value("${jdbc.connection.driverClassName}") String driverClassName,
			@Value("${jdbc.connection.url}") String url, @Value("${jdbc.connection.username}") String username,
			@Value("${jdbc.connection.password}") String password) {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUsername(username);
		bds.setUrl(url);
		bds.setPassword(password);
		bds.setInitialSize(5);
		bds.setMaxTotal(50);
		bds.setMaxIdle(5);
		bds.setMinIdle(2);
		bds.setMaxWaitMillis(1000);
		return bds;
	}
}

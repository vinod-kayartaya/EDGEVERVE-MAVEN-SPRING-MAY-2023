package com.infosys.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = { "com.infosys.dao" })
@PropertySource({ "classpath:jdbc-info.properties" })
public class AppConfig {

	// bean representing the transaction manager for commit/rollback by
	// spring-data-jpa
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) { // DI
		return new JpaTransactionManager(entityManagerFactory); // Wired
	}

	// bean representing an object of EntityManagerFactory, required by the
	// spring-data-jpa
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) { // DI happening here
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource); // manual wiring
		factory.setPackagesToScan("com.infosys.entity");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // JPA provider
		
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		factory.setJpaProperties(props);
		
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	// bean for database connection pool
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

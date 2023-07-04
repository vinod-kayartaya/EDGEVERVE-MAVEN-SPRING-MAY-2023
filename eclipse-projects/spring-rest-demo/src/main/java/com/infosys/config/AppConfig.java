package com.infosys.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan({ "com.infosys.dao", "com.infosys.controllers" })
@PropertySource({ "classpath:jdbc-info.properties" })
public class AppConfig implements WebApplicationInitializer {

	@Bean
	public EntityManager em(EntityManagerFactory factory) {
		log.trace("AppConfig.em() called");
		return factory.createEntityManager();
	}

	@Bean
	public EntityManagerFactory factory(DataSource dataSource) { // dependency injection
		log.trace("AppConfig.factory() called");
		LocalContainerEntityManagerFactoryBean f = new LocalContainerEntityManagerFactoryBean();

		f.setDataSource(dataSource); // manual wiring
		f.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		f.setPackagesToScan("com.infosys.entity"); // where are your @Entity classes?
		f.afterPropertiesSet();

		return f.getObject();
	}

	@Bean
	public DataSource dataSource(@Value("${jdbc.connection.url}") String url,
			@Value("${jdbc.connection.username}") String username,
			@Value("${jdbc.connection.password}") String password) {

		log.trace("AppConfig.dataSource() called");
		JdbcDataSource jds = new JdbcDataSource();
		jds.setUrl(url);
		jds.setUser(username);
		jds.setPassword(password);
		return jds;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.trace("AppConfig.onStartup() called");

		// Create a Spring container loading from a config class file (this class
		// itself)
		// Register the spring container with the DispatcherServlet

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);

		DispatcherServlet ds = new DispatcherServlet(ctx);
		Dynamic s1 = servletContext.addServlet("ds", ds);
		s1.addMapping("/");
		s1.setLoadOnStartup(0);
	}

}

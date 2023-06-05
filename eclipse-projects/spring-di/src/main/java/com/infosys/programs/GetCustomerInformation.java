package com.infosys.programs;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig1;
import com.infosys.dao.CustomerDao;

public class GetCustomerInformation {

	public static void main(String[] args) {

		// Spring container
		AnnotationConfigApplicationContext ctx;
		System.out.println("--------------");
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
		// 1. at this time, spring creates a new container, and creates an object of
		// AppConfig1 class
		// 2. Spring invokes all the functions of AppConfig1 class that have been
		// annotated with @Bean, collects the return
		// values (in this case, an object JdbcCustomerDao), and keeps them in the
		// container. Generally, the name of the
		// method itself is the name of the bean, but if we want, we can give a
		// different name @Bean(name="...")
		System.out.println("--------------");
		CustomerDao dao;

		// dao = new JdbcCustomerDao(); // tight coupling; must be avoided
		dao = ctx.getBean(CustomerDao.class);
		// here spring looks in the container for any object of type CustomerDao
		// interface, and if found, it will simply
		// give the reference of the same.
		CustomerDao dao2 = ctx.getBean(CustomerDao.class);

		System.out.println("dao==dao2 is " + (dao == dao2));

		ctx.getBean(DataSource.class);
		ctx.getBean(DataSource.class);
		ctx.getBean(DataSource.class);
		ctx.getBean(DataSource.class);

		String customerName = dao.getCustomerName("ALFKI");
		System.out.println("Customer name = " + customerName);
		ctx.close();
	}

}

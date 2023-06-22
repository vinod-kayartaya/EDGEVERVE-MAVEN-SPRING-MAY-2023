package com.infosys.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.CustomerDao;
import com.infosys.entity.Customer;

public class TestCustomerDao {


	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			CustomerDao dao = ctx.getBean(CustomerDao.class);
			Customer c1 = dao.findByPhone("0621-08460");
			System.out.println(c1);
			
			dao.findAllByAddressCity("London").forEach(System.out::println);
		}
	}

}

package com.infosys.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig2;
import com.infosys.dao.CustomerDao;

public class DisplayCustomerName {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
		
		CustomerDao dao;
		dao = ctx.getBean(CustomerDao.class);
		
		String name = dao.getCustomerName("ALFKI");
		System.out.printf("Customer name = %s%n", name);
		
		ctx.close();
	}

}

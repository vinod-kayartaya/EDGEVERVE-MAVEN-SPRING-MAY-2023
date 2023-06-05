package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.CustomerDao;

public class GetCustomerNameUsingXmlConfiguration {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context1.xml");
		
		CustomerDao dao = ctx.getBean(CustomerDao.class);
		
		String customerName = dao.getCustomerName("ALFKI");
		
		System.out.println("Customer name = " + customerName);
		
		ctx.close();
		
	}
	
}

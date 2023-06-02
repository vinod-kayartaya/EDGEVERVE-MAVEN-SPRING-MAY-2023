package com.infosys.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig2;
import com.infosys.dao.CustomerDao;
import com.infosys.entity.Customer;

public class AddNewCustomer {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class)) {

			Customer c1 = new Customer();
			c1.setCustomerId("VNKMR");
			c1.setCompanyName("KVinod Inc");
			c1.setContactName("Vinod Kumar K");
			c1.setContactTitle("CEO");
			c1.setCity("Bangalore");
			
			CustomerDao dao = ctx.getBean(CustomerDao.class);
			dao.add(c1);
			System.out.println("Customer data added");
			
		}// ctx.close() called automatically

	}

}

package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.CustomerDao;

public class CustomerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("context2.xml");
		
		CustomerDao dao1 = ctx.getBean("dao1", CustomerDao.class);
		dao1.printInfo();
		
		CustomerDao dao2 = ctx.getBean("dao2", CustomerDao.class);
		dao2.printInfo();
		
		CustomerDao dao3 = ctx.getBean("dao3", CustomerDao.class);
		dao3.printInfo();
		
		CustomerDao dao4 = ctx.getBean("dao4", CustomerDao.class);
		dao4.printInfo();
		
		CustomerDao dao5 = ctx.getBean("dao5", CustomerDao.class);
		dao5.printInfo();
		
		CustomerDao dao6 = ctx.getBean("dao6", CustomerDao.class);
		dao6.printInfo();
		
		ctx.close();
	}
}

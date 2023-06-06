package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.ProductDao;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("context1.xml");
		
		ProductDao dao1 = ctx.getBean("dao1", ProductDao.class);
		dao1.printInfo();
		
		ProductDao dao2 = ctx.getBean("dao2", ProductDao.class);
		dao2.printInfo();
		
		ProductDao dao3 = ctx.getBean("dao3", ProductDao.class);
		dao3.printInfo();
		
		ProductDao dao4 = ctx.getBean("dao4", ProductDao.class);
		dao4.printInfo();
		
		ProductDao dao5 = ctx.getBean("dao5", ProductDao.class);
		dao5.printInfo();
		
		ProductDao dao6 = ctx.getBean("dao6", ProductDao.class);
		dao6.printInfo();
		
		ProductDao dao7 = ctx.getBean("dao7", ProductDao.class);
		dao7.printInfo();
		
		ProductDao dao8 = ctx.getBean("dao8", ProductDao.class);
		dao8.printInfo();
		
		ctx.close();
		
	}
}

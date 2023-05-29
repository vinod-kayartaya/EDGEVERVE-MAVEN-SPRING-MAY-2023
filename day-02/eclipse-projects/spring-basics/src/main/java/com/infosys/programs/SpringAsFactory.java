package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringAsFactory {

	public static void main(String[] args) {

		// a variable to represent spring container
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context1.xml");) {

			// dependency
			ProductDao dao;
			
			// ask for (not being injected) an object of the dependency
			dao = ctx.getBean("jdbc-dao", ProductDao.class);
			
			// use the dependency
			int pc = dao.count();
			log.trace("product count = {}", pc);
			
		} // ctx.close() called here automatically
	}
}

package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetProductCount {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("context3.xml");) {
			ProductDao dao;

			dao = ctx.getBean(ProductDao.class);

			int pc = dao.count();
			
			log.trace("product count = {}", pc);

		} // ctx.close() called here automatically
	}
}

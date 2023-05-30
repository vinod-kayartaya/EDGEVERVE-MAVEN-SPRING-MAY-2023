package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringAsFactory {

	public static void main(String[] args) {

		// a variable to represent spring container
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context1.xml");
		// singleton beans are created here
		) {

			log.trace("now entering the try block");

			// dependency
			ProductDao dao1, dao2;

			// ask for (not being injected) an object of the dependency
			log.trace("calling the ctx.getBean for jdbc-dao...");
			dao1 = ctx.getBean("jdbc-dao", ProductDao.class); // prototype beans are created
			log.trace("finished calling ctx.getBean for jdbc-dao!");
			
			log.trace("dao1 is now referencing to an object who's hashCode is {}", dao1.hashCode());

			log.trace("calling the ctx.getBean for jdbc-dao...");
			dao2 = ctx.getBean("jdbc-dao", ProductDao.class);
			log.trace("finished calling ctx.getBean for jdbc-dao!");

			log.trace("dao2 is now referencing to an object who's hashCode is {}", dao2.hashCode());
			log.trace("dao is an instance of {} class", dao1.getClass().getName());

			log.trace("dao1==dao2 is {}", dao1 == dao2);

			// use the dependency
			// int pc = dao.count();
			// log.trace("product count = {}", pc);
			
		} // ctx.close() called here automatically
	}
}

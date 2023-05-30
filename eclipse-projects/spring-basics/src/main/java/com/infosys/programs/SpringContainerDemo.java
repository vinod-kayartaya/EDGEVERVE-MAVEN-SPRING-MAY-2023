package com.infosys.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.service.ProductService;

public class SpringContainerDemo {

	public static void main(String[] args) {

		// a variable representing a spring container
		// ApploicationContext is an interface
		// most commonly used implementations are: ClassPathXmlApplicationContext,
		// FileSystemXmlApplicationContext, AnnotationConfigApplicationContext
		ClassPathXmlApplicationContext ctx;

		// create an object of spring container
		ctx = new ClassPathXmlApplicationContext("beans.xml"); // new spring container using XML found in class-path
																// (i.e src/main/resources)
		// the above statement will load all bean definitions from the beans.xml into
		// spring container

		// dependency of this program
		ProductService service;

		// ask spring container to give an object of ProductService

		service = ctx.getBean("ps1", ProductService.class);
		
		// make use of the dependency service object
		service.printProducts();

		ctx.close(); // release resources
	}

}

package com.infosys.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.ProductDao;
import com.infosys.entity.Product;

public class AroundAdviceDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDao dao = ctx.getBean(ProductDao.class);

		double min = 10;
		double max = 20;

		List<Product> list = dao.getProductsInPriceRange(min, max);
		System.out.printf("There are %d products between $%.1f and $%.1f%n", list.size(), min, max);

		min = 20;
		max = 10;

		list = dao.getProductsInPriceRange(min, max);
		System.out.printf("There are %d products between $%.1f and $%.1f%n", list.size(), min, max);

		ctx.close();

	}

}

package com.infosys.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.ProductDao;
import com.infosys.entity.Product;

public class TestJdbcTemplateProductDao {
	
	static ProductDao dao;

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		dao = ctx.getBean(ProductDao.class);
		System.out.println("dao is an instanceof " + dao.getClass().getName());
		
		// demo1();
		// demo2();
		demo3();
		
		ctx.close();
	}
	
	static void demo1() {
		List<Product> list = dao.getDiscontinuedProducts();
		for(Product p: list) {
			System.out.println(p);
		}
	}
	
	static void demo2() {
		List<Product> list = dao.getOutOfStockProducts();
		for(Product p: list) {
			System.out.println(p);
		}
	}
	
	static void demo3() {
		List<Product> list = dao.getProductsInPriceRange(50, 100);
		for(Product p: list) {
			System.out.println(p);
		}
	}
}

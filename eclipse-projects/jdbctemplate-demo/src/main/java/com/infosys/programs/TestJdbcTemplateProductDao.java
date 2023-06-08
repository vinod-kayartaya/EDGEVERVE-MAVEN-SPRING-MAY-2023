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
		// demo3();
		demo4();
		
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
	
	static void demo4() {
		Product p = new Product();
		p.setProductId(102);
		p.setProductName("Pepsi cola");
		p.setSupplierId(1);
		p.setCategoryId(1);
		p.setQuantityPerUnit("250ml X 6 bottles");
		p.setUnitPrice(240.0);
		p.setUnitsInStock(190);
		p.setUnitsOnOrder(130);
		p.setReorderLevel(25);
		p.setDiscontinued(0);
		
		dao.addProduct(p);
		System.out.println("New product added");
	}
}















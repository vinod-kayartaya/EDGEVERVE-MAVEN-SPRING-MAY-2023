package com.infosys.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.ProductDao;
import com.infosys.entity.Product;

public class TestingAop {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

			ProductDao dao = ctx.getBean(ProductDao.class);

			System.out.println("dao is an instanceof " + dao.getClass().getName());

			Product p = dao.getProductById(15);
			System.out.println(p);

			List<Product> list = dao.getAllProducts();
			System.out.printf("There are %d products%n", list.size());

			list = dao.getProductsInPriceRange(50, 500);
			System.out.printf("There are %d products between $50 and $500%n", list.size());

//			list = dao.getDiscontinuedProducts();
//			System.out.printf("%d products have been discontinued%n", list.size());

			list = dao.getOutOfStockProducts();
			System.out.printf("%d products are not in stock%n", list.size());

		} // ctx.close() called here automatically

	}
}

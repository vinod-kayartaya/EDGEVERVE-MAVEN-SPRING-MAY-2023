package com.infosys.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.DaoException;
import com.infosys.dao.ProductDao;
import com.infosys.entity.Product;

public class TestingExceptionHandlingUsingAop {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			ProductDao dao = ctx.getBean(ProductDao.class);
			System.out.println("dao is an instanceof " + dao.getClass().getName());

			try {
				List<Product> list = dao.getDiscontinuedProducts();
				System.out.printf("%d products are discontinued%n", list.size());
			} catch (DaoException e) {
				System.out.printf("There is an error - %s%n", e.getClass().getName());
			}
			
			System.out.println("End of app reached");
		}

	}
}

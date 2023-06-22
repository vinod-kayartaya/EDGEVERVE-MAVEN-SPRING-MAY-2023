package com.infosys.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.infosys.config.AppConfig;
import com.infosys.dao.ProductDao;
import com.infosys.entity.Product;

public class TestProductDao {

	static ProductDao dao;

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			dao = ctx.getBean(ProductDao.class);
			demo4();
		}
	}

	static void demo4() {
		dao.findAllByCategoryName("SEAFOOD").forEach(TestProductDao::printProduct);
	}

	static void demo3() {
		dao.findAllByUnitPrice(18.0).forEach(TestProductDao::printProduct);

	}

	static void demo2() {
		// display the products by price range
		double min = 10;
		double max = 15;

		dao.findAllByUnitPriceBetween(min, max).forEach(TestProductDao::printProduct);

	}

	static void demo1() {
		// get product data by page
		int pageNum = 5;
		int pageSize = 10;

		Page<Product> page = dao.findAll(PageRequest.of(pageNum - 1, pageSize));
		page.forEach(TestProductDao::printProduct);

		System.out.printf("Displaying %d products out of %d total%n", pageSize, dao.count());

	}

	static void printProduct(Product p) {
		System.out.printf("%2d %s (%s) --> $%.2f%n", p.getProductId(), p.getProductName(),
				p.getCategory().getCategoryName(), p.getUnitPrice());
	}

}

package com.infosys.programs;

import com.infosys.entity.Category;
import com.infosys.entity.Product;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;

public class GetOneCategory {
	static String productToString(Product p) {
		return "%2d %s (%s) --> $%.1f".formatted(p.getProductId(), 
				p.getProductName(),
				p.getCategory().getCategoryName(),
				p.getUnitPrice());
	}

	public static void main(String[] args) {

		try (EntityManager em = JpaUtil.entityManager()) {
			int id = KeyboardUtil.getInt("Enter category id to search: ");
			Category c1 = em.find(Category.class, id);

			if (c1 == null) {
				System.out.printf("No category found for id %d%n", id);
				return;
			}

			System.out.printf("Category name: %s%n", c1.getCategoryName());
			System.out.printf("Description  : %s%n", c1.getDescription());
			System.out.println("Products in this category are: ");
			System.out.println("------------------------------");

			c1.getProductList().stream() // stream of products
					.map(GetOneCategory::productToString) // stream of strings
					.forEach(System.out::println);

		} // em.close() called here

	}

}

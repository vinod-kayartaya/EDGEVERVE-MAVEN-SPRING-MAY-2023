package com.infosys.programs;

import com.infosys.entity.Product;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;

public class GetOneProduct {

	public static void main(String[] args) {
		Product p1;

		try (EntityManager em = JpaUtil.entityManager()) {
			int id = KeyboardUtil.getInt("Enter product id to search: ");
			p1 = em.find(Product.class, id); // now p1 is a managed entity
		} // em.close() called

		// now p1 is a detatched entity
		System.out.printf("Product name    : %s%n", p1.getProductName());
		System.out.printf("Unit price      : $%.2f%n", p1.getUnitPrice());
		System.out.printf("Category        : %s (%s)%n", 
				p1.getCategory().getCategoryName(),
				p1.getCategory().getDescription());
	}

}

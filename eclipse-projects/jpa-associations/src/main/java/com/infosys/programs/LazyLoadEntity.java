package com.infosys.programs;

import com.infosys.entity.Category;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class LazyLoadEntity {

	public static void main(String[] args) {

		Category c1, c2;

		try (EntityManager em = JpaUtil.entityManager()) {

			c1 = em.find(Category.class, 1); // SQL SELECT is executed
			c2 = em.getReference(Category.class, 2); // Just a proxy is given
			
			System.out.printf("c1 is an object of type %s%n", c1.getClass().getName());
			System.out.printf("c2 is an object of type %s%n", c2.getClass().getName());

		} // em.close() is called
		
		System.out.printf("Category name for id 1 is %s%n", c1.getCategoryName());
		System.out.printf("Category name for id 1 is %s%n", c2.getCategoryName());
		

	}

}

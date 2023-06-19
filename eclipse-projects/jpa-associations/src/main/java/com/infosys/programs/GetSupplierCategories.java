package com.infosys.programs;

import com.infosys.entity.Supplier;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class GetSupplierCategories {
	
	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			
			Supplier e5 = em.find(Supplier.class, 1); // get details for Supplier_id = 5
			
			System.out.printf("Supplier name: %s (%s, %s)%n",
					e5.getCompanyName(),
					e5.getContactName(),
					e5.getContactTitle());
			
			System.out.println("List of categories: ");
			e5.getCategories()
				.stream()
				.map(c->"%s - %s".formatted(c.getCategoryName(), c.getDescription()))
				.sorted()
				.forEach(System.out::println);
			
			
		} // em.close() here
		
	}

}

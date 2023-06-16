package com.infosys.programs;

import com.infosys.entity.Supplier;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;

public class GetOneSupplier {
	
	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			int id = KeyboardUtil.getInt("Enter supplier id to search: ");
			
			Supplier s1 = em.find(Supplier.class, id);
			System.out.printf("Company name  : %s%n", s1.getCompanyName());
			System.out.printf("Contact person: %s (%s)%n",
					s1.getContactName(), s1.getContactTitle());
			System.out.printf("Address       : %s%n", s1.getAddress().getStreetAddress());
			System.out.printf("City          : %s%n", s1.getAddress().getCity());
			System.out.printf("Region        : %s%n", s1.getAddress().getRegion());
			System.out.printf("Country       : %s%n", s1.getAddress().getCountry());
			
			
			System.out.println("Products supplied by this supplier are:");
			System.out.println("---------------------------------------");
			s1.getProductList()
				.stream() // stream of products
				.map(GetOneCategory::productToString) // stream of strings
				.forEach(System.out::println);
			
		} // em.close()
		
	}

}

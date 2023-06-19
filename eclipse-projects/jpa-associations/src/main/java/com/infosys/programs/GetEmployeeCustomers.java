package com.infosys.programs;

import com.infosys.entity.Employee;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class GetEmployeeCustomers {
	
	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			
			Employee e5 = em.find(Employee.class, 5); // get details for employee_id = 5
			
			System.out.printf("Employee name: %s%s %s%n",
					e5.getTitleOfCourtesy(),
					e5.getFirstname(),
					e5.getLastname());
			
			// display the list of all customers whose orders, this employee has processed
			System.out.println("List of customers: ");
			e5.getCustomers()
				.stream()
				.map(c->"%s - %s".formatted(c.getCompanyName(), c.getAddress().getCity()))
				.sorted()
				.forEach(System.out::println);
			
			
		} // em.close() here
		
	}

}

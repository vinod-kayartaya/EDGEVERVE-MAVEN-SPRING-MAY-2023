package com.infosys.programs;

import com.infosys.entity.Department;
import com.infosys.entity.Employee;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AddDepartmentWithEmployees {
	
	public static void main(String[] args) {
		
		
		Department d1 = new Department("ADMIN");
		Department d2 = new Department("ACCOUNTING");
		
		Employee e1 = new Employee("Sachin", 25000.0);
		Employee e2 = new Employee("Harish", 35000.0);
		Employee e3 = new Employee("Ramesh", 26000.0);
		Employee e4 = new Employee("Raghav", 29000.0);
		
		d1.addEmployee(e1); // e1.setDepartment(d1) is done automatically
		d1.addEmployee(e2);
		d1.addEmployee(e3);
		d2.addEmployee(e4);
		
		try(EntityManager em = JpaUtil.entityManager()){
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			// let's add only departments, and let hibernate add the corresponding employees
			try {
				em.persist(d1); // d1 is going to be a managed entity now, but has 3 unmanaged Employee entities
				em.persist(d2);
				tx.commit();
				System.out.println("Department and corresponding employees added to the database");
			}
			catch(Exception e) {
				System.out.println("Could not add entities");
				throw new RuntimeException(e);
			}
			
		}// em.close() 
		
	}

}

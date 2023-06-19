package com.infosys.programs;

import com.infosys.entity.Department;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DeleteDepartment {
	
	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			
			Department d1 = em.find(Department.class, 1);
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			// let's add only departments, and let hibernate add the corresponding employees
			try {
				em.remove(d1); 
				tx.commit();
				System.out.println("Department and corresponding employees deleted from the database");
			}
			catch(Exception e) {
				System.out.println("Could not delete department");
				throw new RuntimeException(e);
			}
			
		}// em.close() 
		
	}

}

package com.infosys.programs;

import java.util.List;

import com.infosys.entity.Employee;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;

public class GetOneEmployeeDetails {

	public static void main(String[] args) {

		try (EntityManager em = JpaUtil.entityManager()) {
			int id = KeyboardUtil.getInt("Enter employee id to search: ");

			Employee e1 = em.find(Employee.class, id);
			if (e1 == null) {
				System.out.println("No employee found!");
				return;
			}

			System.out.printf("Name           : %s%s %s%n", e1.getTitleOfCourtesy(), e1.getFirstname(),
					e1.getLastname());
			System.out.printf("Address        : %s%n", e1.getAddress().getStreetAddress());
			System.out.printf("City           : %s%n", e1.getAddress().getCity());

			if (e1.getManager() != null) {
				Employee m1 = e1.getManager();
				System.out.printf("Manager        : %s%s %s%n", m1.getTitleOfCourtesy(), m1.getFirstname(),
						m1.getLastname());
			}
			
			List<Employee> subordinates = e1.getSubordinates();
			if(subordinates!=null && !subordinates.isEmpty()) {
				System.out.println("Following are the subordinates of this employee: ");
				subordinates
					.stream()
					.map(s -> "%s%s %s".formatted(s.getTitleOfCourtesy(), s.getFirstname(),
						s.getLastname()))
					.forEach(System.out::println);
			}

		} // em.close() called here

	}
}

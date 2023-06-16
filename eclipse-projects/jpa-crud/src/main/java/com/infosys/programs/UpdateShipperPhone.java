package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateShipperPhone {

	public static void main(String[] args) {

		try (EntityManager em = JpaUtil.entityManager()) {
			int id = KeyboardUtil.getInt("Enter shipper id to search: ");
			Shipper s1 = em.find(Shipper.class, id);
			if (s1 == null) {
				System.out.println("No shipper data found for id " + id);
				return;
			}
			// s1 now is a managed entity (changes to s1, will be updated to the db during
			// commit)

			String newPhone = KeyboardUtil.getString("Enter new phone number: [" + s1.getPhone() + "] ");
			if (newPhone.isBlank()) {
				System.out.println("Operation cancelled!");
				return;
			}
			
			s1.setPhone(newPhone);
			// s1 is "dirty" only if newPhone != s1.getPhone()

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			try {
				tx.commit(); // for each dirty entity an SQL UPDATE is executed
				System.out.println("New phone number updated!");
			} catch (Exception e) {
				tx.rollback();
				System.out.println("Couldn't update phone number");
				throw new RuntimeException(e);
			}
		} // em.close() is called here automatically
	}
}

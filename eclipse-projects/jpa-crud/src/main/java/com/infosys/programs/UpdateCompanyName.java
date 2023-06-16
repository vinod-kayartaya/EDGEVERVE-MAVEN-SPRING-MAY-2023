package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateCompanyName {

	static Shipper getShipperById(int id) {
		Shipper s1;
		try (EntityManager em = JpaUtil.entityManager()) {
			s1 = em.find(Shipper.class, id);
			// now, s1 is a managed entity
		} // em.close() is called here

		// s1 now is a detached object
		return s1;
	}

	public static void main(String[] args) {
		int id = KeyboardUtil.getInt("Enter shipper id to search: ");
		Shipper shipper = getShipperById(id);
		// shipper is a detached object (once upon a
		// time it was part of an
		// EntityManager)
		if (shipper == null) {
			System.out.println("No shipper data found for id " + id);
			return;
		}

		String newCompanyName = KeyboardUtil.getString("Enter new company name: [" + shipper.getCompanyName() + "] ");
		if (newCompanyName.isBlank()) {
			System.out.println("Operation cancelled!");
			return;
		}

		shipper.setCompanyName(newCompanyName);
		// shipper may or may not be "dirty"

		try (EntityManager em = JpaUtil.entityManager()) {
			// em doesn't have any managed entities at this time
			em.merge(shipper);
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				tx.commit(); // for each dirty entity an SQL UPDATE is executed
				// but tx does not know if shipper is dirty or not
				// 1. executes a SQL SELECT statement to get shipper data for shipper.shipperId
				// 2. checks if the data retrieved from the db is same/different than that of
				// shipper
				// 3. if they are different then an SQL UPDATE is executed; otherwise no SQL
				// UPDATE!
				System.out.println("New company name updated!");
			} catch (Exception e) {
				tx.rollback();
				System.out.println("Couldn't update company name");
				throw new RuntimeException(e);
			}
		}
	}
}

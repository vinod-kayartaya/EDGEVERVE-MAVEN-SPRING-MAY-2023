package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DeleteShipperById {

	public static void main(String[] args) {

		try (EntityManager em = JpaUtil.entityManager()) {
			int id = KeyboardUtil.getInt("Enter shipper id to search: ");
			Shipper s1 = em.find(Shipper.class, id);
			if (s1 == null) {
				System.out.println("No shipper data found for id " + id);
				return;
			}

			System.out.println("Shipper data to delete: " + s1);

			String ans = KeyboardUtil.getString("Please type DELETE to confirm deletion: ");
			if (!ans.equals("DELETE")) {
				System.out.println("Operation cancelled!");
				return;
			}

			em.remove(s1); // marks s1 as "removed"

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			try {
				tx.commit(); // for each "removed" entity an SQL DELETE is executed
				System.out.println("Shipper data deleted");
			} catch (Exception e) {
				tx.rollback();
				System.out.println("Couldn't delete shipper record");
				throw new RuntimeException(e);
			}

		}

	}
}

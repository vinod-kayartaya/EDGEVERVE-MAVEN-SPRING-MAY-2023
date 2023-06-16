package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;
import com.infosys.utils.KeyboardUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AddNewShipper {

	static Shipper acceptShipperData() {
		int id = KeyboardUtil.getInt("Enter id: ");
		String name = KeyboardUtil.getString("Enter company name: ");
		String phone = KeyboardUtil.getString("Enter phone number: ");
		return new Shipper(id, name, phone);
	}

	public static void main(String[] args) {
		
		try(EntityManager em = JpaUtil.entityManager()){
			
			Shipper s1 = acceptShipperData(); // "new" entity
			em.persist(s1); // now s1 is a "managed" entity 
			// entity manager associates a status code with each of the managed entity based on how the entity became
			// a managed entity: persist() --> "new", merge() --> "dirty", remove() --> "removed"
			// also, if there is any change of data in a managed entity, it is also considered as "dirty"
			
			// during the commit, em generates and executes appropriate DML commands based on the status
			// "new" --> insert, "dirty" --> update, "reomved" --> delete

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			try {
				tx.commit(); // a bunch of sql insert/update/delete is going to be executed
				System.out.println("new shipper data saved to the db");
			} catch (Exception e) {
				tx.rollback(); // any successful DML commands will be rolled back
				System.out.println("couldn't save new shipper data");
				throw new RuntimeException(e);
			}
		}
	}
}

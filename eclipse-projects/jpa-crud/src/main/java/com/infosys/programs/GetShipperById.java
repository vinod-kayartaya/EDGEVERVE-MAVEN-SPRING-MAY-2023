package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetShipperById {
	public static void main(String[] args) {
		
		Shipper s1;
		
		try(EntityManager em = JpaUtil.entityManager()){
			log.trace("em is an object of {} class", em.getClass().getName());
			
			int id = 4;
			s1 = em.find(Shipper.class, id); // managed entity; SQL SELECT is executed here
			// Shipper s2 = new Shipper(); // new entity
			
			// "em" maintains a cache (so, EntityManger is called as 1st level cache)
			// and keeps the entity objects in it. Any object in the cache is called "managed"
			// entity and any entity object which is not in the cache is called "new/detached"
			
			
			// em.clear(); s1 is a detached entity
			
		} // em.close() called here
		
		// at this time, there is no cache, since the "em" is closed,
		// and hence s1 is now called a "detached" entity
		log.trace("s1 is {}", s1);
		
	}
}

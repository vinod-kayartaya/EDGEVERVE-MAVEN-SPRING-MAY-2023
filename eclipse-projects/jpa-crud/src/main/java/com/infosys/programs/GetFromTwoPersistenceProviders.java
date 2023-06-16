package com.infosys.programs;

import com.infosys.entity.Shipper;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class GetFromTwoPersistenceProviders {
	
	public static void main(String[] args) {
		
		EntityManager em1 = JpaUtil.entityManager("h2-hibernate-northwind");
		EntityManager em2 = JpaUtil.entityManager("mysql-eclipselink-northwind");
		
		int id = 4;
		System.out.println(em1.find(Shipper.class, id));
		System.out.println(em2.find(Shipper.class, id));
	}

}

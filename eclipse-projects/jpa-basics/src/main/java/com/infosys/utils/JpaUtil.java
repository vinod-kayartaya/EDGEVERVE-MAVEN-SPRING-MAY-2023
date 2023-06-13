package com.infosys.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {
	
	private static final EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("h2-northwind");
	}
	
	private JpaUtil() {
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}

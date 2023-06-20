package com.infosys.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JpaUtil {

	private JpaUtil() {
	}

	private static EntityManagerFactory emf;

	static {
		// read src/main/resources/META-INFA/persistence.xml
		emf = Persistence.createEntityManagerFactory("h2-hibernate-northwind");
	}

	public static EntityManager entityManager() {
		return emf.createEntityManager();
	}
}

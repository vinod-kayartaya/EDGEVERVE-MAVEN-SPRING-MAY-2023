package com.infosys.programs;

import com.infosys.entity.Category;
import com.infosys.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetOneCategoryById {

	public static void main(String[] args) {
		try (EntityManager em = JpaUtil.getEntityManager()) {
			int id = 4;
			Category c1 = em.find(Category.class, id); // here an SQL SELECT query is executed
			log.trace("c1 = {}", c1);
		} // em.close() called automatically here
	}
}

package com.infosys.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Shipper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ShipperDao {

	@Autowired
	private EntityManager em;

	public Shipper add(Shipper shipper) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(shipper);
			tx.commit();
			return shipper;
		} catch (Exception e) {
			log.warn("error while inserting shipper data", e);
			tx.rollback();
			throw new RuntimeException(e);
		}
	}

	public Shipper findById(Integer shipperId) {
		return em.find(Shipper.class, shipperId);
	}

	public List<Shipper> findAll() {
		return em.createQuery("from Shipper", Shipper.class).getResultList();
	}
}

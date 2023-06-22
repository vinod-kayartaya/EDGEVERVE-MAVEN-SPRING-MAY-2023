package com.infosys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{

	// we can add any number of function of this convention, and spring-data-jpa will implement the body for the same
	// For example, this function is interpreted by Spring like this:
	// JPQL: select p from Product p where p.unitPrice between ?1 and ?2
	// SQL: select * from products where unit_price between ? and ?
	
	List<Product> findAllByUnitPriceBetween(double min, double max);
	
	List<Product> findAllByUnitPrice(double unitPrice);
	
	@Query("from Product where lower(category.categoryName) = lower(?1)")
	List<Product> findAllByCategoryName(String categoryName); // the method name conention does not matter in this case
	

}

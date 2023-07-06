package com.infosys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

package com.infosys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, String>{

	Customer findByPhone(String phone);
	List<Customer> findAllByAddressCity(String city); // checks both "addressCity" and "address.city" in Customer class
}

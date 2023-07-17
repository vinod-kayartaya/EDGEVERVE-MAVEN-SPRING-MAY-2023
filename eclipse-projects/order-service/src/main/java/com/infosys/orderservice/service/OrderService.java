package com.infosys.orderservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.infosys.orderservice.entity.Order;
import com.infosys.orderservice.model.OrderDTO;
import com.infosys.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Value("${shipper.service-url}")
	private String shipperServiceUrl;
	
	
	public OrderDTO getOrderById(Integer orderId) {
		Optional<Order> result = repo.findById(orderId);
		
		if(result.isEmpty()) {
			return null;
		}
		
		OrderDTO dto = new OrderDTO();
		BeanUtils.copyProperties(result.get(), dto);
		
		// get the shipper data from the shipper-service and add to dto
		
		return dto;
			
	}
}

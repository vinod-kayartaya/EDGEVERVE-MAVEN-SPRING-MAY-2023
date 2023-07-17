package com.infosys.orderservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="shipped_date")
	private Date shippedDate;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="ship_via")
	private Integer shipperId;
	
	private Double freight;

}

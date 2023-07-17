package com.infosys.orderservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer orderId;

	private Date orderDate;

	private Date requiredDate;

	private Date shippedDate;

	private String customerId;

	private ShipperRecord shipper;

	private Double freight;
}

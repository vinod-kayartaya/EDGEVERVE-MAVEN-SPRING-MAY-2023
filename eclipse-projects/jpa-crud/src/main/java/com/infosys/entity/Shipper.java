package com.infosys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="shippers")
public class Shipper {
	@Id
	@Column(name="shipper_id")
	private Integer shipperId;
	@Column(name="company_name")
	private String companyName;
	private String phone;
}

// insert into shippers values (?, ?, ?)
// select * from shippers where shipper_id=?
// update shippers set company_name=?, phone=? where shipper_id=?
// delete from shippers where shipper_id=?

package com.infosys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@Entity
@Table(name="shippers")
@XmlRootElement // permission for JAXB to convert Shipper object to XML and vice-versa
public class Shipper {
	
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name="shipper_id")
	private Integer shipperId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column
	private String phone;

}

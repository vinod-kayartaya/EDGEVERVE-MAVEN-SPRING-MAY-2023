package com.infosys.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column
	private String title;
	
	@Column(name="title_of_courtesy")
	private String titleOfCourtesy;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="hire_date")
	private Date hireDate;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column
	private String region;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column
	private String country;
	
	@Column(name="home_phone")
	private String homePhone;
	
	@Column
	private String extension;
	
	@Column
	private byte[] photo;
	
	@Column
	private String notes;
	
}

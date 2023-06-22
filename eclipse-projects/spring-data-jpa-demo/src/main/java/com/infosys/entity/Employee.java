package com.infosys.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.infosys.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "employee_id")
	private Integer employeeId;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column
	private String title;
	@Column(name = "title_of_courtesy")
	private String titleOfCourtesy;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "hire_date")
	private Date hireDate;

	@Embedded
	private Address address;

	@Column(name = "home_phone")
	private String homePhone;
	@Column
	private String extension;
	@Column
	private byte[] photo;
	@Column
	private String notes;
	
	// many employees report to one manager
	@ManyToOne
	@JoinColumn(name="reports_to")
	private Employee manager;
	
	// one employe has many (0 or more) subordinates
	@OneToMany
	@JoinColumn(name="reports_to")
	private List<Employee> subordinates;
	
	@Transient
//	@ManyToMany
//	@JoinTable(name = "orders", 
//		joinColumns = @JoinColumn(name="employee_id" ),
//		inverseJoinColumns = @JoinColumn(name="customer_id", referencedColumnName = "customerId"))
	private Set<Customer> customers;

}









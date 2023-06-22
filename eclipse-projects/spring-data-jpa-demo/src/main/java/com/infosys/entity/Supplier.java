package com.infosys.entity;

import java.util.List;
import java.util.Set;

import com.infosys.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {
	@Id
	@Column(name = "supplier_id")
	private Integer supplierId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_title")
	private String contactTitle;

	// substitute the properties of "address" here
	@Embedded
	private Address address; // has 5 properties that can be mapped to 5 columns of suppliers table

	@Column
	private String phone;
	@Column
	private String fax;
	@Column(name = "home_page")
	private String homepage;

	@OneToMany
	@JoinColumn(name = "supplier_id")
	private List<Product> productList;
	
	@Transient
	// Collection of all category of products supplied by this supplier
//	@ManyToMany
//	@JoinTable(name="products",
//			joinColumns = {@JoinColumn(name="supplier_id", insertable = false, updatable = false)},
//			inverseJoinColumns = {@JoinColumn(name="category_id", insertable = false, updatable = false)})
	private Set<Category> categories;
}















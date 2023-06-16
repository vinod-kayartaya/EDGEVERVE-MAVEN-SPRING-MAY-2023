package com.infosys.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	@Column
	private String description;
	@Column
	private byte[] picture;

	// one category has many products
	@OneToMany // (fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Product> productList;
}

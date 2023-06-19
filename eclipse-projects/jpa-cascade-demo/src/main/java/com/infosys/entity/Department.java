package com.infosys.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "dept_id")
	private List<Employee> employees;

	public Department(String name) {
		this.name = name;
	}

	// convenient method to add employees to department
	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp); // employee is added to the department
		emp.setDepartment(this); // departement is set for the employee
	}

}

package com.infosys.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Integer employeeId;
	private String firstname;
	private String lastname;
	private String title;
	private String titleOfCourtesy;
	private Date birthDate;
	private Date hireDate;
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
	private String homePhone;
	private String extension;
	private String notes;
}

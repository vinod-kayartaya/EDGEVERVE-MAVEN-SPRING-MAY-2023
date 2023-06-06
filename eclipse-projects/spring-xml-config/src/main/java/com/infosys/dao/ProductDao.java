package com.infosys.dao;

public class ProductDao {

	// dependencies expressed as member variables

	// 1. scalar types
	private String url;
	private String user;
	private String password;
	private Boolean autoCommit;
	private Integer batchSize;

	public ProductDao() {
	}

	public ProductDao(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public ProductDao(String url, String user, String password, Boolean autoCommit) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.autoCommit = autoCommit;
	}

	public ProductDao(String url, String user, String password, Boolean autoCommit, Integer batchSize) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.autoCommit = autoCommit;
		this.batchSize = batchSize;
	}
	
	public ProductDao(String a, String b) {
		this.url = a;
		this.user = b;
	}
	
	public ProductDao(String a, Integer b) {
		this.url = a;
		this.batchSize = b;
	}
	

	public void printInfo() {
		System.out.printf("url = %s%n", url);
		System.out.printf("user = %s%n", user);
		System.out.printf("password = %s%n", password);
		System.out.printf("autoCommit = %s%n", autoCommit);
		System.out.printf("batchSize = %s%n", batchSize);
		System.out.println();
	}

}

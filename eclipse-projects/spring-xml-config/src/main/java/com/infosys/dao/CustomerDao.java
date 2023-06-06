package com.infosys.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CustomerDao {

	// dependency expressed via member variables
	private Map<String, String> jdbcInfo = new HashMap<>();

	private Properties jdbcProps = new Properties();
	
	private Set<String> jdbcConfig = new HashSet<>();

	public CustomerDao() {
	}

	public CustomerDao(Map<String, String> jdbcInfo) {
		this.jdbcInfo = jdbcInfo;
	}

	public CustomerDao(Properties jdbcProps) {
		this.jdbcProps = jdbcProps;
	}

	public CustomerDao(Set<String> jdbcConfig) {
		this.jdbcConfig = jdbcConfig;
	}

	public void setJdbcInfo(Map<String, String> jdbcInfo) {
		this.jdbcInfo = jdbcInfo;
	}
	
	public void setJdbcProps(Properties jdbcProps) {
		this.jdbcProps = jdbcProps;
	}
	
	public void setJdbcConfig(Set<String> jdbcConfig) {
		this.jdbcConfig = jdbcConfig;
	}

	public void printInfo() {
		System.out.printf("jdbcInfo = %s (%s) %n", jdbcInfo, jdbcInfo.getClass().getName());
		System.out.printf("jdbcProps = %s (%s) %n", jdbcProps, jdbcProps.getClass().getName());
		System.out.printf("jdbcConfig = %s (%s) %n%n", jdbcConfig, jdbcConfig.getClass().getName());
	}
}

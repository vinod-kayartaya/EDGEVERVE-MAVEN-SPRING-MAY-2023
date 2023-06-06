package com.infosys.programs;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.CustomerDao;
import com.infosys.entity.Customer;

public class TestCustomerDao {
	
	static CustomerDao dao;
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("context2.xml");
		dao = ctx.getBean(CustomerDao.class);
		
		test2();
		
		ctx.close();
	}
	
	static void test1() {
		String name = dao.getCustomerName("anton");
		System.out.println(name);
	}
	
	static void test2() {
		List<Customer> list = dao.getCustomersFromCity("london");
		for(Customer c: list) {
			System.out.println(c);
		}
	}
	
	static void test3() {
		List<Customer> list = dao.getCustomersFromCountry("germany");
		for(Customer c: list) {
			System.out.println(c);
		}
	}
	
	static void test4() {
		Customer c1 = dao.getById("alfki");
		System.out.println(c1);
	}
	
	static void test5() {
		List<Customer> list = dao.getAllCustomers();
		System.out.printf("Got %d customers%n", list.size());
	}

}

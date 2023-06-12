package com.infosys.programs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infosys.dao.CustomerDao;
import com.infosys.entity.Customer;

public class TestCustomerDao {
	
	static Logger log = LoggerFactory.getLogger(TestCustomerDao.class);

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml")) {
			
			// spring container is ready with the beans defined in the context.xml file
			// "dataSource" injected to "jdbcTemplate" injected to "customerDao"
			CustomerDao dao = ctx.getBean(CustomerDao.class);
			
			Customer c1 = dao.findById("anton");
			log.trace("c1 = {}", c1);
			
			List<Customer> list;
			
			list = dao.findByCity("london");
			log.trace("There are {} customers in London", list.size());
			

			list = dao.findByCountry("usa");
			log.trace("There are {} customers in USA", list.size());

		} // ctx.close() is automatically called
	}
}

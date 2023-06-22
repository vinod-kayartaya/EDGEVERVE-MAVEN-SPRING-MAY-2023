package com.infosys.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.AppConfig;
import com.infosys.dao.ShipperDao;
import com.infosys.entity.Shipper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestShipperDao {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

			ShipperDao dao = ctx.getBean(ShipperDao.class);
			log.trace("dao is an instanceof {} class", dao.getClass().getName());

			// dao.findAll().forEach(System.out::println);
			
//			int id = 2;
//			Optional<Shipper> result = dao.findById(id);
//			if (result.isEmpty()) {
//				log.warn("no shipper data found for id {}", id);
//			} else {
//				log.trace("shipper = {}", result.get());
//			}
			
			Shipper s = new Shipper();
			s.setShipperId(4);
			s.setCompanyName("QWRT Transports");
			s.setPhone("(222) 282-4424");
			
			s = dao.save(s); // if shipperId is null adds (if auto increment is enabled), otherwise updates (if found)
			log.trace("new shipper added with id {}", s.getShipperId());
			

		} // ctx.close() is called here automatically

	}
}

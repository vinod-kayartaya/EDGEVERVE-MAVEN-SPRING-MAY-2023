package com.infosys.programs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggingDemo {

	static void testLogging() {
		Logger log = LoggerFactory.getLogger(LoggingDemo.class);

		// log levels --> TRACE, DEBUG, INFO, WARN, ERROR, OFF
		log.trace("this is a trace message");
		log.debug("this is a debug message");
		log.info("this is an info message");
		log.warn("this is a warn message");
		log.error("this is an error message");
	}

	public static void main(String[] args) {
		testLogging();
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("beans.xml"); // new spring container using XML found in class-path
		ctx.close();
	}

}

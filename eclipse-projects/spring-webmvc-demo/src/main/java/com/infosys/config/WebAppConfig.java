package com.infosys.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
public class WebAppConfig implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.trace("WebAppConfig.onStrartup() called...");

		// 1. create and load spring container
		AnnotationConfigWebApplicationContext ctx;
		ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class, AppConfig.class);

		// 2. create and load dispatcher-servlet
		Dynamic ds = servletContext.addServlet("ds", new DispatcherServlet(ctx));
		ds.setLoadOnStartup(1);
		ds.addMapping("/");
	}

}

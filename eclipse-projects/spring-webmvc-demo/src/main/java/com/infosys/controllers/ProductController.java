package com.infosys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infosys.dao.ProductDao;

@Controller
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@RequestMapping(path = "/product-list", method = RequestMethod.GET)
	public String handleGetProductList(Model model) { // spring injects a storage object as a dependency
		
		// spring stores this list of products with the name "products",
		// which will be made available to the JSP in the "request" scope
		model.addAttribute("products", dao.getAll());
		
		return "/WEB-INF/pages/display-products.jsp";
	}
}

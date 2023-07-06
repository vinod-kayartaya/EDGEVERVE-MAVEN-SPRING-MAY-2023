package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Product;
import com.infosys.model.ProductDTO;
import com.infosys.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> handleGetAll(){
		
		List<Product> list = service.getAllProducts();
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping(path="/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> hanldeGetOne(@PathVariable Integer productId){
		ProductDTO productDTO = service.getProductById(productId);
		if(productDTO==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(productDTO);
	}

}

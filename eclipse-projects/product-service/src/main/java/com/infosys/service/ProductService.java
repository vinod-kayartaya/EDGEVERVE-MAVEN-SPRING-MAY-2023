package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Product;
import com.infosys.model.ProductDTO;
import com.infosys.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	private static ProductDTO getProductDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setQuantityPerUnit(product.getQuantityPerUnit());
		dto.setUnitPrice(product.getUnitPrice());
		dto.setUnitsInStock(product.getUnitsInStock());
		dto.setUnitsOnOrder(product.getUnitsOnOrder());
		dto.setReorderLevel(product.getReorderLevel());
		dto.setDiscontinued(product.getDiscontinued());
		return dto;
	}

	public ProductDTO getProductById(Integer productId) {
		Optional<Product> result = repo.findById(productId);
		if (result.isEmpty()) {
			return null;
		}

		return getProductDTO(result.get());
	}

	

	public List<Product> getAllProducts(){
		return repo.findAll();
	}
}

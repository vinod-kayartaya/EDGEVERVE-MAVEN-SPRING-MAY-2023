package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.infosys.entity.Product;
import com.infosys.model.ProductDTO;
import com.infosys.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	private static ProductDTO getProductDTO(Product product) {
		return ProductDTO.builder().productId(product.getProductId()).productName(product.getProductName())
				.quantityPerUnit(product.getQuantityPerUnit()).unitPrice(product.getUnitPrice())
				.unitsInStock(product.getUnitsInStock()).unitsOnOrder(product.getUnitsOnOrder())
				.reorderLevel(product.getReorderLevel()).discontinued(product.getDiscontinued()).build();
	}

	public ProductDTO getProductById(Integer productId) {
		Optional<Product> result = repo.findById(productId);
		if (result.isEmpty()) {
			return null;
		}

		return getProductDTO(result.get());
	}

	public List<ProductDTO> getAllProducts(Integer pageNum, Integer pageSize) {

		PageRequest pr = PageRequest.of(pageNum - 1, pageSize);

		return repo.findAll(pr) // Page<Product>
				.stream() // Stream<Product>
				.map(ProductService::getProductDTO) // Stream<ProductDTO>
				.toList(); // List<ProductDTO>
	}

	public List<ProductDTO> searchByField(String fieldName, String fieldValue) {
		List<Product> list = null;

		switch (fieldName) {
		case "unitPrice":
			list = repo.findAllByUnitPrice(Double.valueOf(fieldValue));
			break;
		case "unitsInStock":
			list = repo.findAllByUnitsInStock(Integer.valueOf(fieldValue));
			break;
		case "unitsOnOrder":
			list = repo.findAllByUnitsOnOrder(Integer.valueOf(fieldValue));
			break;
		case "reorderLevel":
			list = repo.findAllByReorderLevel(Integer.valueOf(fieldValue));
			break;
		case "discontinued":
			list = repo.findAllByDiscontinued(Integer.valueOf(fieldValue));
			break;
		case "quantityPerUnit":
			list = repo.findAllByQuantityPerUnit(fieldValue);
			break;
		case "productName":
			list = repo.findAllByProductName(fieldValue);
			break;
		}

		return list.stream().map(ProductService::getProductDTO).toList();
	}

	public List<ProductDTO> getByPriceRange(Double min, Double max) {
		List<Product> list = repo.findAllByUnitPriceBetween(min, max);
		return list.stream().map(ProductService::getProductDTO).toList();
	}
}












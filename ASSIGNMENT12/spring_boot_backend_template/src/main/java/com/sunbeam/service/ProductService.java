package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import org.springframework.stereotype.Service;



public interface ProductService {
	
	//List<Product> getProductsByPrice(Double max, Double min);
	List<Product> findAll();	
	
	Product addNewCategory(Product product);
	ApiResponse updateproductDetails(Long ProductId,Product product);
	ApiResponse deleteProduct(Long ProductId);
}

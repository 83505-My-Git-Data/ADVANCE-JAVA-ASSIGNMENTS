package com.sunbeam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.entites.Product;

@Service
public interface ProductService {
	
	List<Product> getProductsByPrice(Double max, Double min);
	

}

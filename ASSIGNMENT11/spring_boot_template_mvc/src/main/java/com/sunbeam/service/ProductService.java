package com.sunbeam.service;

import java.util.List;
import com.sunbeam.entities.Product;

import org.springframework.stereotype.Service;


@Service
public interface ProductService {
	
	//List<Product> getProductsByPrice(Double max, Double min);
	List<Product> findAll();	

}

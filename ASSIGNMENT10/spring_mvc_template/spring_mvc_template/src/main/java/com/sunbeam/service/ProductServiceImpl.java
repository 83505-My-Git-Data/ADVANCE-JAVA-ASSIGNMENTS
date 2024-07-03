package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entites.Product;

public class ProductServiceImpl implements ProductService {
	
	ProductDao pdao;
	@Override
	public List<Product> getProductsByPrice(Double max, Double min) {
		
		return pdao.getProductsByPrice(max, min);
	}
}

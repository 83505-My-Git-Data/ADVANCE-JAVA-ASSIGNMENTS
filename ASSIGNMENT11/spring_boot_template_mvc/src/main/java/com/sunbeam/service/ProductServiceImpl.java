package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.entities.Product;

import com.sunbeam.dao.ProductDao;
@Service // spring bean holding B.L ,singleton n eager
@Transactional // for automatic tx management
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao pdao;

	@Override
	public List<Product> findAll() {
		
		return pdao.findAll();
	}
}

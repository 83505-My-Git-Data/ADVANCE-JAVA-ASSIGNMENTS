package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.entities.Product;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
@Service // spring bean holding B.L ,singleton n eager
@Transactional // for automatic tx management
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao pdao;

	@Override
	public List<Product> findAll() {
		
		return pdao.findAll();
	}
	
	
	@Override
	public Product addNewCategory(Product product) {
		Product persistentProduct  = pdao.save(product);
		return persistentProduct;
	}
	
	
	@Override
	public ApiResponse updateproductDetails(Long ProductId, Product product) {
		String mesg = "Product Updation Failed!!!";
		if(pdao.existsById(ProductId))
		{
			pdao.save(product);
			mesg = "Product Updated Succesfully!!!";
			
		}
		return new ApiResponse(mesg);
	}
	
	public ApiResponse deleteProduct(Long ProductId)
	{
		String msg = "Deletion Failed!!!";
		
		if(pdao.existsById(ProductId))
		{
			pdao.deleteById(ProductId);
			return new ApiResponse("Record Deleted Successfully!");
		}
		
		return new ApiResponse(msg);
	}
}

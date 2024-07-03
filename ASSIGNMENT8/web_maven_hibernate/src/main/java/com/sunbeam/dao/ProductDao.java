package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {

	String addProduct(Long categoryId, Product newProduct);
	Product getProductDetails(Long productId);
	String purchaseProduct(Long productId, int qty);
	List<Product> getAllProducts();
	Product searchByCategory();
	String deleteByProduct(String prodName);
}

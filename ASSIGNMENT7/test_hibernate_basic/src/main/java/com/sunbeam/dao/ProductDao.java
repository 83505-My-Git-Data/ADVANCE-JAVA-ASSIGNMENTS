package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {

	String insertData(Product product);
	Product getProductDetailsById(long productId);
	List<Product> getProductDetailsByCatAndPrice(Category c, double startPrice, double endPrice);
	String applyDiscountByCat(double discount, Category cat);
	String purchaseProduct(Long ProductId, int qty);
	String deleteByName(String productName);
	
	
	
}

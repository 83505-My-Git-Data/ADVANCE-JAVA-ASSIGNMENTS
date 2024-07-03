package com.sunbeam.beans;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {

	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	private long productId;
	
	//dependency - dao layer i/f
	private ProductDao productDao;
	
	public ProductBean() {
		// Creaate dao instance
		productDao = new ProductDaoImpl();
		System.out.println("product bean created");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	/*
	 * add b.l. method to add a new product
	 * */
	
	public String addNewProduct()
	{
		System.out.println("in add product" + categoryId);
		
		//1.create transisent product
		Product product = new Product(name,price,quantity);
		
		return productDao.addProduct(categoryId, product);	
	}
	
	public String purchaseProduct()
	{

		System.out.println("purchase product for " +productId + " for quantity");
		return productDao.purchaseProduct(productId, quantity);
		
	}
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	
}

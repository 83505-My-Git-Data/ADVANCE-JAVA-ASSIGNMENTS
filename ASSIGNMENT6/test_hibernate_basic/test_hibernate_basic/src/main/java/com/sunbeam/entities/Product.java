package com.sunbeam.entities;

import javax.persistence.*;

@Entity


@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING) 
	@Column(length = 20)
	private Category c;
	
	@Column(name="product_Name",length = 25)//col name , varchar(25)
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="available_Quantity")
	private int availableQuantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(Category c, String productName, double price, int availableQuantity) {
		super();
		this.c = c;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", c=" + c + ", productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}

}

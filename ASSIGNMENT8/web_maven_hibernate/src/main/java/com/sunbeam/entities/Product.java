package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product extends BaseEntity{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	@Column(length = 20,unique=true)//col name , varchar(25)
	private String productName;
	
	
	private double price;
	
	@Column(name="availableQty")
	private int availableQuantity;
	
	//Product *-->1 Category(many- to -one)
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private Category productCategory;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public Category getProductCategory() {
		return productCategory;
	}



	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
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


	



	public Product(String productName, double price, int availableQuantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}



	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", availableQuantity=" + availableQuantity
				+ "]";
	}

}

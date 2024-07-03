package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	
	
	@Column(length = 20, unique= true)
	private String name;
	private String description;
	//@OneToMany - mandatory (otherwise MappingException)
	//IF mappedBy is NOt specified in a bi dir asociation(one-many) -> hibernate creates additional table
	//default value of the cascade property = NONE!
	//i.e. none of the operations will be cascaded from src -> target entity
	//to specify - on save update n delete
	//use CascadeType.ALL
	
	@OneToMany(mappedBy ="productCategory", cascade =CascadeType.ALL) //cascade.save, cascade.update,cascade.delete
	
	private List<Product> products = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	/*
	 * add helper method to establish bi dir association between Category and product
	 * 
	 * */
	
	public void addProduct(Product product)
	{
		//parent(Category) --> child(Product)
		this.products.add(product);
		//child-->Parent
		product.setProductCategory(this);
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}
	
	
	

}

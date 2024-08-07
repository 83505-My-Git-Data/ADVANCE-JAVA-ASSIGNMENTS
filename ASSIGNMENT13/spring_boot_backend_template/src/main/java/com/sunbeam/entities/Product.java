package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	private double price;
	@Column(name = "availableQty")
	private int availableQty;
	// Product *-->1 Category (many - to - one)
	@ManyToOne // Mandatory , otherwise MappingException
//	// optional BUT recommended , to specify name 
//	//of FK column n adding NOT NULL  constraint
	@JoinColumn(name = "category_id", nullable = false)
	private Category productCategory;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, int availableQty) {
		super();
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
	}


}

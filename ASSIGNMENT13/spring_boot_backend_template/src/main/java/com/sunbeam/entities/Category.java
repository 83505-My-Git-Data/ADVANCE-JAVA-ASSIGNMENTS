package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString

@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	private String description;
	/*
	 * @OneToMany - mandatory (otherwise MappingException) If mappedBy is NOT
	 * specified in a bi dir asso(one-many) hibernate creates additional table
	 * 
	 * Default value of the cascade property=NONE ! i.e none of the operations will
	 * be cascaded from src -> target entity To specify - on save , update n delete
	 * use CascadeType.ALL
	 * 
	 */
	@OneToMany(mappedBy = "productCategory", 
			cascade = CascadeType.ALL)
	 //Category 1--->* Product (multiple products can be added under 1 category)
	private List<Product> products = new ArrayList<>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	


}

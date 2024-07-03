package com.sunbeam.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO extends BaseDTO {

	private String name;
	private double price;
	private int availableQty;

}

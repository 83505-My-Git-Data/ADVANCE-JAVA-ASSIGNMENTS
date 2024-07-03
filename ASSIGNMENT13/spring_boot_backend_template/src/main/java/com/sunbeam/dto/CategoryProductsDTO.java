package com.sunbeam.dto;

import java.util.List;

import com.sunbeam.entities.Product;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
public class CategoryProductsDTO {
	private String name;
	private String description;
	private List<ProductDTO> products;


}

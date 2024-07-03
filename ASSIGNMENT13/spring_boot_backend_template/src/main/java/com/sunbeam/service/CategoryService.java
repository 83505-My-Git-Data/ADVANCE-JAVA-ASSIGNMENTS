package com.sunbeam.service;

import java.util.Optional;

import com.sunbeam.dto.CategoryProductsDTO;
import com.sunbeam.entities.Category;

public interface CategoryService {
	
	CategoryProductsDTO getCategoryAndProducts(Long catid);
	
	

}

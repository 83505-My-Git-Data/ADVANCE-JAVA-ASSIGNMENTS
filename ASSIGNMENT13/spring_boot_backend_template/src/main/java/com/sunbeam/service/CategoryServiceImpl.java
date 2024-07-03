package com.sunbeam.service;


import org.modelmapper.ModelMapper;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dto.CategoryProductsDTO;
import com.sunbeam.entities.Category;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categorydao;
	ModelMapper modelmapper;

	@Override
	public CategoryProductsDTO getCategoryAndProducts(Long catid) {
		Category categoryEntity = categorydao.getCategoryAndProducts(catid)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Category Id!!"));
		
		
		return modelmapper.map(categoryEntity,  CategoryProductsDTO.class);
	}

}

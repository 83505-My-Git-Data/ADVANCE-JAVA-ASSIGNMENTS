package com.sunbeam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	CategoryService categoryService;
	
	@GetMapping("/{catId}/products")
	public ResponseEntity<?> getCategoryAndProducts(@PathVariable Long catId)
	{
		System.out.println("in get category n products" + catId);

		try {
			return ResponseEntity.ok(categoryService.getCategoryAndProducts(catId));
			
		}
		catch(RuntimeException e){
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
			
		}
	}

}

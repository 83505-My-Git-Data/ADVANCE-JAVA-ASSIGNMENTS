package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("In ctor" +getClass());
	}
	
	@Operation(description = "Get the Product List")
	@GetMapping("/productList")
	public List<Product> getProductList(Model map) {
		System.out.println("in product list page");
		map.addAttribute("products", productService.findAll());
		return productService.findAll();
	}
	
	@PostMapping("/add")
	@Operation(description = "Create New Category")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewCategory(newProduct));
			
		}
		catch(RuntimeException e){
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
			
		}
		
	}
	
	@Operation(description = "Update Category Details")
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody Product product )
	{
		System.out.println("in update " + productId + " Long " + product);
		return ResponseEntity.ok(productService.updateproductDetails(productId, product));
	}
	
	@Operation(description = "Delete Category Details")
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId, @RequestBody Product product )
	{
		System.out.println("in delete " + productId + " Long " + product);
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}
	

}

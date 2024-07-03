package com.sunbeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("In ctor" +getClass());
	}
	
	@GetMapping("/productList")
	public String getProductList(Model map) {
		System.out.println("in product list page");
		map.addAttribute("products", productService.findAll());
		return "/product/productList";
	}

}

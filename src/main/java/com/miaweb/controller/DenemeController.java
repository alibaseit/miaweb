package com.miaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miaweb.model.definition.Product;
import com.miaweb.service.product.ProductService;

@RestController
@RequestMapping("/deneme")
public class DenemeController {
	@Autowired
	private ProductService productService;

	@GetMapping("/code/{code}")
	public Product expiredProducts(@PathVariable(value = "code") String code) {
		return productService1.findByCode(code);
	}
}

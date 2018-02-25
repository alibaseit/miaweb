package com.miaweb.controller;

import com.miaweb.model.definition.Product;
import com.miaweb.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deneme")
public class DenemeController {

        @GetMapping()
        public String test() {
            return "the server running";
        }

//	private ProductService productService;
//
//	@Autowired
//	public DenemeController(ProductService productService) {
//		this.productService = productService;
//	}
//
//	@GetMapping("/")
//	public String hi() {
//		return "hi";
//	}
//
//	@GetMapping("/code/{code}")
//	public Product expiredProducts(@PathVariable(value = "code") String code) {
//		return productService.findByCode(code);
//	}
}

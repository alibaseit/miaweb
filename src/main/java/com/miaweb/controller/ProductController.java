package com.miaweb.controller;

import com.miaweb.model.definition.Product;
import com.miaweb.service.product.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("")
	public Page<Product> allProducts(Pageable pageable) {
		return productService.productsPageByPage(pageable);
	}

	@GetMapping("/code/{code}")
	public Product expiredProducts(@PathVariable(value = "code") String code) {
		return productService.findByCode(code);
	}

	@GetMapping("/id/{id}")
    public Product product(@PathVariable(value = "id") String id) {
        return productService.productById(id);
    }

	@GetMapping("/namelike/{name}")
	public List<Product> findNameLike(@PathVariable(value = "name") String name, Pageable pageable) {
		return productService.productNameLike(name, pageable);
	}

	@GetMapping("/async")
	public Future<List<Product>> productsAsync() {
		return productService.productsAsync();
	}

	@PostMapping
	public Product add(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping("")
	public int updateName(@RequestBody Product product){
        String id = product.getId();
        String name = product.getName();
        return productService.updateName(name, id);
    }

    @PatchMapping("/{id}")
    public Product modify(@PathVariable(name = "id") String id, @RequestBody Product product) {
        return productService.update(id, product);
    }

}

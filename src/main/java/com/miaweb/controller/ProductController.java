package com.miaweb.controller;

import com.miaweb.model.definition.Product;
import com.miaweb.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/products")
@Api(value = "products", description = "Product API")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation(value = "Get all product list. Pageable", notes = "All products are listed pageable", response = Product.class)
    HttpEntity<PagedResources<Product>> products(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Product> products = productService.productsPageByPage(pageable);
        return new ResponseEntity<>(assembler.toResource(products), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    Product expiredProducts(@PathVariable(value = "code") String code) {
        return productService.findByCode(code);
    }

    @GetMapping("/id/{id}")
    public Product product(@PathVariable(value = "id") String id) {
        return productService.productById(id);
    }

    @GetMapping("/name/{name}")
    List<Product> findNameLike(@PathVariable(value = "name") String name, Pageable pageable) {
        return productService.productNameLike(name, pageable);
    }

    @GetMapping("/async")
    @ApiOperation(value = "Get all product list. Run as async", notes = "Get all product list. Run as async", response = Product.class)
    Future<List<Product>> productsAsync() {
        return productService.productsAsync();
    }

    @PostMapping
    Product add(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("")
    int updateName(@RequestBody Product product) {
        String id = product.getId();
        String name = product.getName();
        return productService.updateName(name, id);
    }

    @PatchMapping("/{id}")
    Product modify(@PathVariable(name = "id") String id, @RequestBody Product product) {
        return productService.update(id, product);
    }
}

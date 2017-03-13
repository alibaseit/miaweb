package com.miaweb.service.product;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miaweb.model.definition.Product;
import com.miaweb.repository.jpa.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

    public Product productById(String id) {
        return productRepository.findOne(id);
    }

	public Page<Product> productsPageByPage(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public List<Product> productNameLike(String name, Pageable pageable) {
		return productRepository.productNameLike(name, pageable);
	}

	public Future<List<Product>> productsAsync() {
		return productRepository.productsAsync();
	}

	public List<Product> expiredProducts() {
		return productRepository.expiredProducts();
	}

	public Product findByCode(String code) {
		return productRepository.deneme(code);
	}

	@Transactional
    public int updateName(String name, String id) {
        return productRepository.updateName(name, id);
    }

    public Product update(String id, Product product) {
        Product old = productRepository.getOne(id);
        old.setName(product.getName());
        old.setCode(product.getCode());
        return productRepository.save(old);
    }
}

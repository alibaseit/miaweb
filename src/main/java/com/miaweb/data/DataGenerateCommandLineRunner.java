package com.miaweb.data;

import com.miaweb.model.definition.Product;
import com.miaweb.repository.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Profile(value = { "dev" })
public class DataGenerateCommandLineRunner implements CommandLineRunner {
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//generate fake Product data
		IntStream.range(1, 200).forEach(i -> {
			Product p = new Product();
			p.setCode(String.format("%05d", i));
			p.setName("PRODUCT NAME " + Integer.toString(i));
			productRepository.save(p);
		});
	}

}

package com.miaweb.config;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.miaweb.model.definition.Product;
import com.miaweb.repository.jpa.ProductRepository;

@Component
@Profile(value = { "dev" })
public class DataGenerateCommandLineRunner implements CommandLineRunner {
	private ProductRepository prodRepo;

	@Autowired
	public void setProdRepo(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		IntStream.range(1, 200).forEach(i -> {
			Product p = new Product();
			p.setCode(String.format("%05d", i));
			p.setName("PRODUCT NAME " + Integer.toString(i));
			prodRepo.save(p);
		});
	}

}

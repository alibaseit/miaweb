package com.miaweb.data;

import com.miaweb.model.RecordStatus;
import com.miaweb.model.definition.Product;
import com.miaweb.repository.jpa.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Profile(value = { "dev" })
public class DataGenerateCommandLineRunner implements CommandLineRunner {
	private final static Logger log = LoggerFactory.getLogger(DataGenerateCommandLineRunner.class);

	private final Environment environment;
	private ProductRepository productRepository;

	public DataGenerateCommandLineRunner(Environment environment,  ProductRepository productRepository) {
		this.productRepository = productRepository;
		this.environment = environment;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("dummy commandline runner");
		log.info("Oracle Db pass {}", environment.getProperty("orc_passwd"));
		//generate fake Product data
		IntStream.range(1, 200).forEach(i -> {
			Product p = new Product();
			p.setCode(String.format("%05d", i));
			p.setName("PRODUCT NAME " + Integer.toString(i));
//			p.setExemptDate(LocalDateTime.now().plusMonths(12));
			p.setStatus(RecordStatus.ACTIVE);
			productRepository.save(p);
		});
	}

}

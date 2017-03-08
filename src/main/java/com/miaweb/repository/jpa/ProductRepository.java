package com.miaweb.repository.jpa;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.miaweb.model.definition.Product;
import com.miaweb.repository.ABaseJpaRepository;

@Repository

public interface ProductRepository extends ABaseJpaRepository<Product, Long> {

	@Query("select p from Product p where p.name like CONCAT('%',:name,'%')")
	public List<Product> productNameLike(@Param("name") String name, Pageable pageable);

	@Async
	@Query("select p from Product p")
	public Future<List<Product>> productsAsync();

	@Query(value = "select * from pstkmc where pmckod like '%:code%'", nativeQuery = true)
	public List<Product> expiredProducts();

	@Query(value = "select p from Product p where p.code = ?1")
	public Product findByLalala(String code);

	public Product deneme(String code);

	@Modifying
	@Query("update Product p set p.name = ?1 where p.id = ?2 ")
	public int updateName(String name, long id);
}

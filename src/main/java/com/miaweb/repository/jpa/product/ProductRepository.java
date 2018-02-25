package com.miaweb.repository.jpa.product;

import com.miaweb.model.definition.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {
    Product findById(String id);

    @Query("select p from Product p where p.name like CONCAT('%',:name,'%')")
    List<Product> productNameLike(@Param("name") String name, Pageable pageable);

    @Async
    @Query("select p from Product p")
    Future<List<Product>> productsAsync();

    @Query(value = "select * from pstkmc where pmckod like '%:code%'", nativeQuery = true)
    List<Product> expiredProducts();

    @Query(value = "select p from Product p where p.code = ?1")
    Product findByLalala(String code);

    Product deneme(String code);

    @Modifying
    @Query("update Product p set p.name = ?1 where p.id = ?2 ")
    int updateName(String name, String id);

    public List<Product> tere(Long id);
}

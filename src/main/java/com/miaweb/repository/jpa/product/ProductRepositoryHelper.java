package com.miaweb.repository.jpa.product;

import com.miaweb.model.definition.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductRepositoryHelper {
    @PersistenceContext
    EntityManager entityManager;

    public List<Product> tere(Long id) {
        Query query = entityManager.createQuery("select p from Product p where p.id = :ids");
        query.setParameter("ids", id);
        return query.getResultList();
    }
}

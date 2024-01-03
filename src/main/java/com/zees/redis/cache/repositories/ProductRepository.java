package com.zees.redis.cache.repositories;

import com.zees.redis.cache.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findFirstById(Long id);

}

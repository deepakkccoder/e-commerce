package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

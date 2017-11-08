package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Subcategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends MongoRepository<Subcategory, String> {
}

package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}

package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends MongoRepository<Brand, String>{

}
